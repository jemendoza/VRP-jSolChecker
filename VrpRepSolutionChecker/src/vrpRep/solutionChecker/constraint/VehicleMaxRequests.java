/**
 * 
 */
package vrpRep.solutionChecker.constraint;

import vrpRep.exceptions.MissingAttributeException;
import vrpRep.structure.instance.Instance;
import vrpRep.structure.instance.IntValue;
import vrpRep.structure.solution.Route;
import vrpRep.structure.solution.Solution;

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
	public void evaluate() {
		try {
			boolean b = checkMaxRequests();
			System.out.println(b);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (MissingAttributeException e) {
			e.printStackTrace();
		}
	}

	private boolean checkMaxRequests() throws NumberFormatException,
			MissingAttributeException {

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
