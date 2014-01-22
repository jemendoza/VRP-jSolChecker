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

	private Instance	instance;
	private Solution	solution;

	@Override
	public void evaluate(Instance inst, Solution sol) {
		this.instance = inst;
		this.solution = sol;
		try {
			boolean b = checkMaxRequests();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (MissingAttributeException e) {
			e.printStackTrace();
		}
	}

	private boolean checkMaxRequests() throws NumberFormatException,
			MissingAttributeException {

		int maxRequest;
		for (Route r : solution.getRoutes()) {
			if (r.isHasType()) {
				int type = r.getType();
				maxRequest = ((IntValue) instance.getFleet().get(type)
						.getAttribute("maxRequests").get(0)).getValue();
			} else
				maxRequest = ((IntValue) instance.getFleet().get(0)
						.getAttribute("maxRequests").get(0)).getValue();
			if (maxRequest < r.getRequests().size())
				return false;
		}

		return true;
	}

}
