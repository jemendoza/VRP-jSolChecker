/**
 * 
 */
package vrpRep.solutionChecker.constraint;

import vrpRep.structure.instance.Instance;
import vrpRep.structure.instance.IntValue;
import vrpRep.structure.instance.Vehicle;
import vrpRep.structure.solution.Route;
import vrpRep.structure.solution.Solution;
import vrpRep.utilities.ConstraintResult;

/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class DepartureArrivalNode implements IConstraint {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * vrpRep.solutionChecker.constraint.IConstraint#evaluate(vrpRep.solutionChecker
	 * .instance.DefaultInstance,
	 * vrpRep.solutionChecker.solution.DefaultSolution)
	 */

	@Override
	public ConstraintResult evaluate() {
		boolean b = test();
		System.out.println(b);
		return null;
	}

	private boolean test() {
		for (Route r : Solution.getRoutes()) {
			int b = r.getType();

			int nodeStart = r.getRequests().get(0).getNodeId();
			int nodeArrival = r.getRequests().get(r.getRequests().size())
					.getNodeId();
			for (Vehicle v : Instance.getFleet()) {
				if (((IntValue) v.getAttribute("type").get(0)).getValue() == b) {
					if (((IntValue) v.getAttribute("arrivalNode").get(0))
							.getValue() != nodeArrival
							|| ((IntValue) v.getAttribute("departureNode").get(
									0)).getValue() != nodeStart)
						return false;

				}
			}

		}
		return true;
	}
}
