/**
 * 
 */
package vrpRep.solutionChecker.constraint;

import vrpRep.structure.instance.Instance;
import vrpRep.structure.solution.Request;
import vrpRep.structure.solution.Route;
import vrpRep.structure.solution.Solution;

/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class DemandSatisfied implements IConstraint {
	private Instance	instance;
	private Solution	solution;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * vrpRep.solutionChecker.constraint.IConstraint#evaluate(vrpRep.solutionChecker
	 * .instance.DefaultInstance,
	 * vrpRep.solutionChecker.solution.DefaultSolution)
	 */
	@Override
	public void evaluate(Instance inst, Solution sol) {
		this.instance = inst;
		this.solution = sol;
		isDemandSatisfied();
	}

	/**
	 * 
	 * @return
	 */
	private boolean isDemandSatisfied() {

		for (Route r : solution.getRoutes()) {
			for (Request n : r.getRequests()) {
				// TODO wait for probability distribution to be code
			}
		}
		return false;

	}

}
