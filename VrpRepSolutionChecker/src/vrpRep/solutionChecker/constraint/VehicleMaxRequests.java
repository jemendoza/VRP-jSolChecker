/**
 * 
 */
package vrpRep.solutionChecker.constraint;

import vrpRep.structure.instance.Instance;
import vrpRep.structure.instance.IntValue;
import vrpRep.structure.solution.Route;
import vrpRep.structure.solution.Solution;
import vrpRep.utilities.ConstraintResult;

/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class VehicleMaxRequests implements IConstraint {

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
			boolean b = checkMaxRequests();
			System.out.println(b);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return null;
	}

	private boolean checkMaxRequests() throws NumberFormatException {

		int maxRequest;
		for (Route r : Solution.getRoutes()) {
			if (r.isHasType()) {
				int type = r.getType();
				maxRequest = ((IntValue) Instance.getFleet().get(type)
						.getAttribute("maxRequests").get(0)).getValue();
			} else
				maxRequest = ((IntValue) Instance.getFleet().get(0)
						.getAttribute("maxRequests").get(0)).getValue();
			if (maxRequest < r.getRequests().size())
				return false;
		}

		return true;
	}

}
