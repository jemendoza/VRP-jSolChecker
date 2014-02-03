/**
 * 
 */
package vrpRep.solutionChecker.constraint;

import java.util.ArrayList;
import java.util.HashMap;

import vrpRep.solChecker.ConstraintEvaluation;
import vrpRep.solChecker.IConstraint;
import vrpRep.structure.instance.DoubleValue;
import vrpRep.structure.instance.Instance;
import vrpRep.structure.solution.Demand;
import vrpRep.structure.solution.Request;
import vrpRep.structure.solution.Route;
import vrpRep.structure.solution.Solution;

/**
 * Class used to evaluate capacity constraint for Single Vehicle and Single Product VRP.
 * 
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class DeterministicCapacitySingleVehicleSingleProduct implements IConstraint {

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

		// each route
		for (Route r : Solution.getRoutes()) {
			vcr = new VehicleCResult(-1);

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
		
		double capacityMax = ((DoubleValue) Instance.getVehicle()
				.getAttribute("capacity").get(0)).getValue();
		
		if (vcr.getSumDemands().get(vcr.getProductIds().get(0)) > capacityMax) {
			cEval.addMessage("Deterministic capacity Single Vehicle Single Product|Vehicle capacity - "
					+ vcr.getSumDemands().get(0) + " greater than " + capacityMax);
		}

	}
	/**
	 * Creation of an Object VehicleCResult
	 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
	 *
	 */
	protected class VehicleCResult {
		private int							vehiType;
		private ArrayList<Integer>			productIds	= new ArrayList<Integer>();
		private HashMap<Integer, Double>	sumDemands	= new HashMap<Integer, Double>();

		public VehicleCResult(int vehiType) {
			this.vehiType = vehiType;
		}

		public void addDemand(int productId, double demand) {
			if (!productIds.contains(productId)) {
				productIds.add(productId);
				sumDemands.put(productId, demand);
			} else {
				sumDemands.put(productId, sumDemands.get(productId) + demand);
			}
		}

		/**
		 * @return the vehiType
		 */
		public int getVehiType() {
			return vehiType;
		}

		/**
		 * @return the productIds
		 */
		public ArrayList<Integer> getProductIds() {
			return productIds;
		}

		/**
		 * @return the sumDemands
		 */
		public HashMap<Integer, Double> getSumDemands() {
			return sumDemands;
		}

	}
}
