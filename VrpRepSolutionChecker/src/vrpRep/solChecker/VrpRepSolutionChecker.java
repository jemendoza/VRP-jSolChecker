package vrpRep.solChecker;

import java.io.File;

import org.jdom.Element;

import vrpRep.fileReaders.InstanceTranslator;
import vrpRep.fileReaders.SolutionTranslator;

/**
 * 
 * @author Main : Jorge E. Mendoza (jorge.mendoza@uco.fr). Modified : Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 *
 */
public class VrpRepSolutionChecker {
	
	private ConstraintHandler ch;
	private IObjectiveFunction of;
	
	
	
	/**
	 * JUNIT TESTS ONLY
	 */
	private FeasibilityCheck check;
	public boolean isFeasible(){
		// TODO REMOVE AFTER TESTING
		return check.isFeasible();
	}
	/**
	 * JUNIT TESTS ONLY
	 */
	
	
	
	
	
	/**
	 * Builds a new instance and solution to check
	 * @param instance File path to xml instance
	 * @param solution File path to xml solution
	 */
	public VrpRepSolutionChecker(String instance, String solution){
		new InstanceTranslator(new File(
				"./xmlTest/DeterministicCapacityInstance.xml"));
		new SolutionTranslator(new File(
				"./xmlTest/DeterministicCapacitySolution.xml"));

	}
	
	
	
	
	/**
	 * Builds a new solution to check keeping instance from previous test
	 * @param solution File path to xml solution
	 */
	public void changeSolution(String solution){
		new SolutionTranslator(new File(
				"./xmlTest/DeterministicCapacitySolution.xml"));
		this.ch = null;
	}
	
	public void addConstraint(IConstraint c){
		if(this.ch==null)ch=new ConstraintHandler();
		ch.addConstraint(c);
	}
	
	public void setObjectiveFunction(IObjectiveFunction of){
		this.of=of;
	}
	
	public Element checkSolution(){
		Element e=new Element("report");
		Element f=new Element("feasible");
		check = null;
		check=ch.evaluateFeasibility();
		f.setText(check.isFeasible()?"TRUE":"FALSE");
		e.addContent(f);
		e.addContent(check.toXML());
		double of;
		of=check.isFeasible()?this.of.evaluate():Double.NaN;
		Element objective=new Element("objective");
		objective.setText(String.valueOf(of));
		e.addContent(objective);
		return e;
	}
	
}
