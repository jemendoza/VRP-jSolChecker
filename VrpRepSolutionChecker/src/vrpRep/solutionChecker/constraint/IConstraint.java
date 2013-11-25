/**
 * 
 */
package vrpRep.solutionChecker.constraint;

import vrpRep.solutionChecker.instance.DefaultInstance;
import vrpRep.solutionChecker.solution.DefaultSolution;

/**
 * Interface used to help implementation of constraint evaluators
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 *
 */
public interface IConstraint {
	
	/**
	 * Evaluates a constraint of solution
	 * @param sol Solution to evaluate
	 */
	public void evaluate(DefaultInstance inst, DefaultSolution sol);

}
