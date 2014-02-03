/**
 * 
 */
package vrpRep.solutionChecker.constraint;

import vrpRep.solChecker.ConstraintEvaluation;
import vrpRep.solChecker.IConstraint;
import vrpRep.solutionChecker.constraint.DeterministicCapacitySingleVehicleSingleProduct.VehicleCResult;
import vrpRep.structure.instance.DoubleValue;
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
public class DeterministicCapacityMultiVehicleSingleProduct implements IConstraint {

	private ConstraintEvaluation cEval;
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * vrpRep.solutionChecker.constraint.IConstraint#evaluate(vrpRep.solutionChecker
	 * .instance.DefaultInstance,
	 * vrpRep.solutionChecker.solution.DefaultSolution)
	 */
	@Override
	public ConstraintEvaluation checkConstraint() {
		cEval = new ConstraintEvaluation();
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
		return cEval;

	}

	private void checkDemands(VehicleCResult vcr) {
		
		double capacityMax = ((DoubleValue) Instance.getVehicle(
				vcr.getVehiType()).getAttribute("capacity")).getValue();
		if (vcr.getSumDemands().get(vcr.getProductIds().get(0)) > capacityMax) {
			cEval.addMessage("Deterministic capacity Multi Vehicle Single Product|Vehicle capacity " + vcr.getVehiType() + " - "
					+ vcr.getSumDemands().get(0) + " greater than " + capacityMax);
		}
	}

}