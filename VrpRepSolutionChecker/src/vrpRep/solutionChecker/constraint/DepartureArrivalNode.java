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
	private Instance	instance;
	private Solution	solution;

	@Override
	public void evaluate(Instance inst, Solution sol) {
		instance = inst;
		solution = sol;
		try {
			boolean b = test();
		} catch (MissingAttributeException e) {
			e.printStackTrace();
		} catch (MissingElementException e) {
			e.printStackTrace();
		}
	}

	private boolean test() throws MissingAttributeException,
			MissingElementException {
		for (Route r : solution.getRoutes()) {
			Integer b = r.getType();

			int nodeStart = ((IntValue) instance.getRequest(
					r.getRequests().get(0).getId()).getAttribute("node"))
					.getValue();
			int nodeArrival = ((IntValue) instance.getRequest(
					r.getRequests().get(r.getRequests().size() - 1).getId())
					.getAttribute("node")).getValue();
			for (Vehicle v : instance.getFleet()) {
				if (Integer.valueOf(v.getAttribute("type").get(0).toString())
						.equals(b)) {
					if (!Integer.valueOf(
							v.getAttribute("arrivalNode").get(0).toString())
							.equals(nodeArrival)
							|| !Integer.valueOf(
									v.getAttribute("departureNode").get(0)
											.toString()).equals(nodeStart))
						return false;

				}
			}

		}
		return true;
	}
}
