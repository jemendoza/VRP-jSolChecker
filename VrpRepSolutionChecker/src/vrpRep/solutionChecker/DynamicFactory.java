/**
 * 
 */
package vrpRep.solutionChecker;

import java.io.IOException;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;

import vrpRep.utilities.DistanceCalculator;
import vrpRep.utilities.DistanceCalculatorEuc2D;
import vrpRep.utilities.JDomParser;

/**
 * Dynamic factory to build the parameterized solution checker (constraints, objective function and distance calulator)
 * 
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class DynamicFactory {

	/**
	 * List of constraint names
	 */
	private List<Element> constraints;
	/**
	 * List of objectives
	 */
	private List<Element> objectives;
	/**
	 * Name of distance calculator
	 */
	private Element distanceCalc;


	/**
	 * Constructor that extracts all necessary information from config file
	 * @param configFilePath path to xmlconfiguration file
	 */
	@SuppressWarnings("unchecked")
	public DynamicFactory(String configFilePath) {
		try {
			Document config = JDomParser.parseDocument(configFilePath);
			Element rootNode = config.getRootElement();
			
			constraints = rootNode.getChild("constraints").getChildren("constraint");
			objectives =  rootNode.getChild("objectives").getChildren("objective");
			distanceCalc = rootNode.getChild("distanceCalculator");
		} catch (JDOMException | IOException e1) {
			e1.printStackTrace();
		}
	}

	
	/**
	 * Load constraints into solution checkers constraint handler
	 * @param solC link to solution checker
	 */
	public void loadConstraints(VrpRepSolutionChecker solC){
		for(Element e : this.constraints){
			Class<?> tClass;
				try {
					tClass = Class.forName(e.getText());
					solC.addConstraint((IConstraint)tClass.newInstance());
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (InstantiationException e1) {
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					e1.printStackTrace();
				}		
		}
	}
	
	
	/**
	 * Load objective function calculation into solution checker
	 * @param solC link to solution checker
	 */
	public void loadObjective(VrpRepSolutionChecker solC){
		Class<?> tClass;
		try {
			tClass = Class.forName(this.objectives.get(0).getText());
			solC.setObjectiveFunction((IObjectiveFunction)tClass.newInstance());
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}	
	}
	
	/**
	 * Retrieves distance calculator. If exception thrown, ensure xml
	 * configuration file contains class path to demand reader under key
	 * "distanceCalculator". <br />
	 * If no configuration was found in xml config file. The euclidean 2D distance calculator is initialized.
	 * 
	 */
	public void setDistanceCalculator() {
		try {
			if (this.distanceCalc != null) {
				Class<?> tClass;
				tClass = Class.forName(this.distanceCalc.getText());
				DistanceCalculator
						.setDistanceCalculator((DistanceCalculator) tClass
								.newInstance());
			}else{
				DistanceCalculator.setDistanceCalculator(new DistanceCalculatorEuc2D());
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

}
