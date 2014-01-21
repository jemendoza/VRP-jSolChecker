/**
 * 
 */
package vrpRep.solutionChecker.constraint;

import java.math.BigInteger;
import java.util.List;

import vrpRep.exceptions.MissingAttributeException;
import vrpRep.fileReaders.InstanceTranslator;
import vrpRep.fileReaders.SolutionTranslator;
import vrpRep.structure.instance.Instance;
import vrpRep.structure.instance.IntValue;
import vrpRep.structure.instance.Vehicle;
import vrpRep.structure.solution.Route;
import vrpRep.structure.solution.Solution;
import vrpRep.utilities.DistanceCalculator;

/**
 * Class verifies that all vehicle traveling distance constraints are respected.
 * 
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class MaxTravelDistance implements IConstraint {

	private Instance	inst;
	private Solution	sol;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * vrpRep.solutionChecker.constraint.IConstraint#evaluate(vrpRep.solutionChecker
	 * .instance.DefaultInstance,
	 * vrpRep.solutionChecker.solution.DefaultSolution)
	 */
	@Override
	public void evaluate(InstanceTranslator inst, SolutionTranslator sol) {
		boolean result;
		this.inst = inst.getInstance();
		this.sol = sol.getSolution();

		try {
			this.inst.getFleet().get(0).getAttribute("type");
			result = evaluateMtdWithTypes();
		} catch (MissingAttributeException e) {
			result = evaluateMtd();
		}
		System.out.println(result);
	}

	/**
	 * Evaluate constraint with only one type of vehicle
	 * 
	 * @return result
	 */
	private boolean evaluateMtd() {
		boolean result = true;
		List<Vehicle> fleet = this.inst.getFleet();
		double travelDist;
		int nodeId1, nodeId2;

		for (Route r : sol.getRoutes()) { // for each route
			travelDist = 0;
			// for each pair of node
			for (int j = 0; j < r.getRequests().size() - 1; j++) {
				try {
					nodeId1 = ((IntValue) inst.getRequest(
							r.getRequests().get(j).getId())
							.getAttribute("node")).getValue();
					nodeId2 = ((IntValue) inst.getRequest(
							r.getRequests().get(j + 1).getId()).getAttribute(
							"node")).getValue();
					travelDist += DistanceCalculator.getDistance(inst, nodeId1,
							nodeId2);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			try {
				if (travelDist > ((IntValue) (fleet.get(0).getAttribute(
						"maxTravelDistance").get(0))).getValue()) {
					System.out
							.println("Max travel distance of vehicle failed on route "
									+ r.getId());
					result = false;
				}
			} catch (MissingAttributeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * Evaluate constraint with several types of vehicles
	 * 
	 * @return result
	 */
	private boolean evaluateMtdWithTypes() {
		boolean result = true;
		List<Vehicle> fleet = this.inst.getFleet().getVehicle();
		BigInteger currentType;
		double travelDist;

		for (int i = 0; i < fleet.size(); i++) { // for each vehicle type
			currentType = fleet.get(i).getType();

			for (Route r : sol.getRoutes()) { // for each route
				travelDist = 0;

				if (BigInteger.valueOf(r.getType()) == currentType) { // if
					// route
					// requires
					// current
					// type
					for (int j = 0; j < r.getRoute().size() - 1; j++) { // for
						// each
						// node
						// pair
						try {
							travelDist += DistanceCalculator
									.getDistance(inst, BigInteger.valueOf(r
											.getRoute().get(j)), BigInteger
											.valueOf(r.getRoute().get(j + 1)));
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				if (travelDist > Double.valueOf(fleet.get(i)
						.getMaxTravelDistance().getContent())) {
					System.out.println("Max travel distance of vehicle "
							+ fleet.get(i).getType() + " failed on route "
							+ r.getId());
					result = false;
				}
			}
		}

		return result;
	}
}
