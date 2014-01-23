/**
 * 
 */
package vrpRep.solutionChecker.constraint;

import vrpRep.exceptions.MissingAttributeException;
import vrpRep.structure.instance.Instance;
import vrpRep.structure.instance.IntValue;
import vrpRep.structure.solution.Demand;
import vrpRep.structure.solution.Request;
import vrpRep.structure.solution.Route;
import vrpRep.structure.solution.Solution;
import vrpRep.utilities.ConstraintResult;

/**
 * Class used to evaluate capacity constraints
 * 
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public abstract class Capacity implements IConstraint {

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
			boolean b = checkVehicleCapacity();
			System.out.println(b);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (MissingAttributeException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @return
	 * @throws NumberFormatException
	 * @throws MissingAttributeException
	 */
	private boolean checkVehicleCapacity() throws NumberFormatException,
			MissingAttributeException {

		for (Route r : Solution.getRoutes()) {
			int vehicleType = 0;
			if (r.isHasType()) {
				vehicleType = r.getType();
			}
			int vehicleCapacity = ((IntValue) Instance.getFleet()
					.get(vehicleType).getAttribute("capacity").get(0))
					.getValue();
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
