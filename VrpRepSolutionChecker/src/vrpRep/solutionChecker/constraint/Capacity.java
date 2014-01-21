/**
 * 
 */
package vrpRep.solutionChecker.constraint;

import vrpRep.exceptions.MissingAttributeException;
import vrpRep.structure.instance.Instance;
import vrpRep.structure.solution.Demand;
import vrpRep.structure.solution.Request;
import vrpRep.structure.solution.Route;
import vrpRep.structure.solution.Solution;

/**
 * Class used to evaluate capacity constraints
 * 
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public abstract class Capacity implements IConstraint {

	private Instance	instance;
	private Solution	solution;

	@Override
	public void evaluate(Instance inst, Solution sol) {
		this.instance = inst;
		this.solution = sol;

		try {
			boolean b = checkVehicleCapacity();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (MissingAttributeException e) {
			e.printStackTrace();
		}
	}

	private boolean checkVehicleCapacity() throws NumberFormatException,
			MissingAttributeException {

		for (Route r : solution.getRoutes()) {
			int vehicleType = 0;
			if (r.isHasType()) {
				vehicleType = r.getType();
			}
			int vehicleCapacity = Integer.valueOf(instance.getFleet()
					.get(vehicleType).getAttribute("capacity").toString());
			double demand = 0.0;
			for (Request n : r.getRequests()) {
				if (n.getDemand().size() != 0)
					for (Demand d : n.getDemand()) {
						demand += d.getDemand();
					}
			}
			if (vehicleCapacity < demand)
				return false;
		}
		return true;
	}
}
