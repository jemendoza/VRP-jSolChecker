package vrpRep.solutionChecker;

import java.io.File;

import org.jdom.Element;

import vrpRep.fileReaders.InstanceTranslator;
import vrpRep.fileReaders.SolutionTranslator;

/**
 * Class that stores global structure of solution checker. 
 * It contains the constraint and objective handlers and the test methods to verify a solution 
 * against an instance.
 * @author Main : Jorge E. Mendoza (jorge.mendoza@uco.fr). Modified : Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 *
 */
public class VrpRepSolutionChecker {
	
	/**
	 * Constraint handler
	 */
	private ConstraintHandler ch;
	/**
	 * Objective handler
	 */
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
	
	/**
	 * Add constraint to the constraint handler
	 * @param constraint new constraint
	 */
	public void addConstraint(IConstraint constraint){
		if(this.ch==null)ch=new ConstraintHandler();
		ch.addConstraint(constraint);
	}
	
	/**
	 * Sets objective function
	 * @param of new objective function
	 */
	public void setObjectiveFunction(IObjectiveFunction of){
		this.of=of;
	}
	
	/**
	 * Runs tests of constraints and objective function.
	 * @return Stores and returns the results in a JDom XML element
	 */
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
