/**
 * 
 */
package vrpRep.solutionChecker.constraint;

import java.util.List;

import vrpRep.exceptions.MissingAttributeException;
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
		boolean result;
		try {
			Instance.getFleet().get(0).getAttribute("type");
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
		double travelDist;
		int nodeId1, nodeId2;

		for (Route r : Solution.getRoutes()) { // for each route
			travelDist = 0;
			// for each pair of node
			for (int j = 0; j < r.getRequests().size() - 1; j++) {
				try {
					nodeId1 = ((IntValue) Instance.getRequest(
							r.getRequests().get(j).getId())
							.getAttribute("node")).getValue();
					nodeId2 = ((IntValue) Instance.getRequest(
							r.getRequests().get(j + 1).getId()).getAttribute(
							"node")).getValue();
					travelDist += DistanceCalculator.calculateDistance(nodeId2,
							nodeId1);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			try {
				if (travelDist > ((IntValue) (Instance.getFleet().get(0)
						.getAttribute("maxTravelDistance").get(0))).getValue()) {
					System.out
							.println("Max travel distance of vehicle failed on route "
									+ r.getId());
					result = false;
				}
			} catch (MissingAttributeException e) {
				System.out.println("Missing maxTravelDistance attribute");
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
		List<Vehicle> fleet = Instance.getFleet();
		int currentType = 0, nodeId1, nodeId2;
		double travelDist;

		for (Route r : Solution.getRoutes()) {
			travelDist = 0;
			for (int j = 0; j < r.getRequests().size() - 1; j++) {
				try {
					nodeId1 = ((IntValue) Instance.getRequest(
							r.getRequests().get(j).getId())
							.getAttribute("node")).getValue();
					nodeId2 = ((IntValue) Instance.getRequest(
							r.getRequests().get(j + 1).getId()).getAttribute(
							"node")).getValue();
					travelDist += DistanceCalculator.calculateDistance(nodeId2,
							nodeId1);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			for (int i = 0; i < fleet.size(); i++) {
				try {
					currentType = ((IntValue) (fleet.get(i)
							.getAttribute("Type").get(0))).getValue();
					if (currentType == r.getType()) {
						if (travelDist > ((IntValue) (Instance.getFleet()
								.get(i).getAttribute("maxTravelDistance")
								.get(0))).getValue()) {
							System.out
									.println("Max travel distance of vehicle failed on route "
											+ r.getId());
							result = false;
						}
					}
				} catch (MissingAttributeException e) {
					System.out.println("No type attribute for fleet number "
							+ i);
					e.printStackTrace();
				}
			}
		}
		return result;
	}
}
