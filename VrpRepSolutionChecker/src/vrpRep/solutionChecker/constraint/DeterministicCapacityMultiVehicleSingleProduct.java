/**
 * 
 */
package vrpRep.solutionChecker.constraint;

import java.util.ArrayList;

import vrpRep.solutionChecker.constraint.DeterministicCapacitySingleVehicleSingleProduct.VehicleCResult;
import vrpRep.structure.instance.DoubleValue;
import vrpRep.structure.instance.Instance;
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
public class DeterministicCapacityMultiVehicleSingleProduct implements IConstraint {

	private boolean				cValid	= true;
	private ArrayList<String>	details	= new ArrayList<String>();

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
		VehicleCResult vcr;
		DeterministicCapacitySingleVehicleSingleProduct dcsvsp = new DeterministicCapacitySingleVehicleSingleProduct();


		// each route
		for (Route r : Solution.getRoutes()) {
			vcr = dcsvsp.new VehicleCResult(r.getType());

			// sum demands
			for (Request n : r.getRequests()) {
				if (n.getDemand().size() != 0) {
					for (Demand d : n.getDemand()) {
						vcr.addDemand(d.getId(), d.getDemand());
					}
				}
			}

			checkDemands(vcr);
		}
		if (!cValid) {
			String sResult = details.get(0);
			for (int i = 1; i < details.size(); i++)
				sResult = sResult.concat("\n" + details.get(i));

			return new ConstraintResult(cValid, sResult,
					"Deterministic capacity Multi Vehicle Single Product");
		} else {
			return new ConstraintResult(cValid, "Deterministic capacity Multi Vehicle Single Product");
		}

	}

	private void checkDemands(VehicleCResult vcr) {
		
		double capacityMax = ((DoubleValue) Instance.getVehicle(
				vcr.getVehiType()).getAttribute("capacity")).getValue();
		if (vcr.getSumDemands().get(vcr.getProductIds().get(0)) > capacityMax) {
			details.add("Vehicle capacity " + vcr.getVehiType() + " - "
					+ vcr.getSumDemands().get(0) + " greater than " + capacityMax);
			cValid = false;
		}
	}

}