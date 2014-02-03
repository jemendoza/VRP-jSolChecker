/**
 * 
 */
package vrpRep.solutionChecker.constraint;

import vrpRep.solChecker.ConstraintEvaluation;
import vrpRep.solChecker.IConstraint;
import vrpRep.solutionChecker.constraint.DeterministicCapacitySingleVehicleSingleProduct.VehicleCResult;
import vrpRep.structure.instance.Compartment;
import vrpRep.structure.instance.Instance;
import vrpRep.structure.solution.Demand;
import vrpRep.structure.solution.Request;
import vrpRep.structure.solution.Route;
import vrpRep.structure.solution.Solution;

/**
 * Class used to evaluate capacity constraint for Multi Vehicles and Multi Products VRP.
 * 
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class DeterministicCapacityMultiVehicleMultiProduct implements IConstraint {

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

	/**
	 * Method testing that the capacity constraint is respected
	 * @param vcr : VehicleCResult containing type of the vehicle, Ids of product and the sum of the demand.
	 */
	private void checkDemands(VehicleCResult vcr) {
		double capacityMin, capacityMax;
		Compartment compartement;
		// each product
		for (int pId : vcr.getProductIds()) {
			compartement = (Compartment) Instance.getVehicle(
					vcr.getVehiType()).getAttribute("compartment").get(pId);
			capacityMin = compartement.getMin();
			capacityMax = compartement.getMax();
			if (vcr.getSumDemands().get(pId) > capacityMax) {
				cEval.addMessage("Deterministic capacity Multi Vehicle Multi Product|Vehicle capacity type "
						+ vcr.getVehiType() + " , Product Id " + pId
						+ " - " + vcr.getSumDemands().get(pId) + " greater than "
						+ capacityMax);
			} else if (vcr.getSumDemands().get(pId) < capacityMin) {
				cEval.addMessage("Deterministic capacity Multi Vehicle Multi Product|Vehicle capacity type "
						+ vcr.getVehiType() + " , Product Id " + pId
						+ " - " + vcr.getSumDemands().get(pId) + " less than "
						+ capacityMin);
			}
		}
	}

}