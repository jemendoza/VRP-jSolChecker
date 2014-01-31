/**
 * 
 */
package vrpRep.solutionChecker.constraint;

import java.util.ArrayList;
import java.util.HashMap;

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
public class DeterministicCapacitySingleVehicleSingleProduct implements IConstraint {

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
		if (!cValid) {
			String sResult = details.get(0);
			for (int i = 1; i < details.size(); i++)
				sResult = sResult.concat("\n" + details.get(i));

			return new ConstraintResult(cValid, sResult,
					"Deterministic capacity Single Vehicle Single Product");
		} else {
			return new ConstraintResult(cValid, "Deterministic capacity Single Vehicle Single Product");
		}

	}

	private void checkDemands(VehicleCResult vcr) {
		
		double capacityMax = ((DoubleValue) Instance.getVehicle()
				.getAttribute("capacity").get(0)).getValue();
		
		if (vcr.getSumDemands().get(vcr.getProductIds().get(0)) > capacityMax) {
			details.add("Vehicle capacity - "
					+ vcr.getSumDemands().get(0) + " greater than " + capacityMax);
			cValid = false;
		}

	}

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
