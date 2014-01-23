/**
 * 
 */
package vrpRep.solutionChecker.constraint;

import vrpRep.exceptions.MissingAttributeException;
import vrpRep.exceptions.MissingElementException;
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
		try {
			boolean b = test();
			System.out.println(b);
		} catch (MissingAttributeException e) {
			e.printStackTrace();
		} catch (MissingElementException e) {
			e.printStackTrace();
		}
		return null;
	}

	private boolean test() throws MissingAttributeException,
			MissingElementException {
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
