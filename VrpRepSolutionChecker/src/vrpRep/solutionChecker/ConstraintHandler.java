/**
 * 
 */
package vrpRep.solutionChecker;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Stores all the constraints that need to be evaluated.
 * 
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class ConstraintHandler {

	/**
	 * List of constraints
	 */
	private ArrayList<IConstraint>	constraints;
	
	
	/**
	 * Default constructor. Initializes constraints list
	 */
	public ConstraintHandler() {
		this.constraints = new ArrayList<IConstraint>();
	}


	/**
	 * Run all the constraints and return the result.
	 * @return feasibilty in {@link vrpRep.solutionChecker.FeasibilityCheck} object
	 */
	public FeasibilityCheck evaluateFeasibility(){
		FeasibilityCheck check=new FeasibilityCheck();
		check.setFeasible();
		Iterator<IConstraint> it=this.constraints.iterator();
		while(it.hasNext()){
			ConstraintEvaluation eval=it.next().checkConstraint();
			if(!eval.isFeasible()){
				check.setUnfeasible();
			}
			check.addEvaluation(eval);			
		}		
		return check;
	}


	/**
	 * Adds a constraint to the list of constraints to be evaluated
	 * 
	 * @param constraint
	 *            constraint to add
	 */
	public void addConstraint(IConstraint constraint) {
		this.constraints.add(constraint);
	}


	/**
	 * 
	 * @return List of constraints to evaluate
	 */
	public ArrayList<IConstraint> getConstraints() {
		return constraints;
	}


}
