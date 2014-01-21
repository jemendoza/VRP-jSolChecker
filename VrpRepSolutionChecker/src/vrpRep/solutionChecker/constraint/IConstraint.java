/**
 * 
 */
package vrpRep.solutionChecker.constraint;

import vrpRep.structure.instance.Instance;
import vrpRep.structure.solution.Solution;

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
	 */
	public void evaluate(Instance inst, Solution sol);

}
