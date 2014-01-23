/**
 * 
 */
package vrpRep.solutionChecker.constraint;

import vrpRep.utilities.ConstraintResult;


/**
 * Interface used to help implementation of constraint evaluators
 * 
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public interface IConstraint {

	/**
	 * Evaluates a constraint of solution
	 * 
	 * @param sol
	 *            Solution to evaluate
	 * @return TODO
	 */
	public ConstraintResult evaluate();

}
