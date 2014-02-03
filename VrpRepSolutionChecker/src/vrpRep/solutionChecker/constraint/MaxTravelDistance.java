/**
 * 
 */
package vrpRep.solutionChecker.constraint;

import java.util.List;

import vrpRep.solChecker.ConstraintEvaluation;
import vrpRep.solChecker.IConstraint;
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
		if (Instance.getFleet().get(0).getAttribute("type") != null)
			evaluateMtdWithTypes();
		else
			evaluateMtd();
		return cEval;
	}

	/**
	 * Evaluate constraint with only one type of vehicle
	 * 
	 * @return result
	 */
	private void evaluateMtd() {
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
			int maxTravelDist = ((IntValue) (Instance.getFleet().get(0)
					.getAttribute("maxTravelDistance").get(0))).getValue();
			if (travelDist > maxTravelDist) {
				System.out
						.println("Max travel distance of vehicle failed on route "
								+ r.getId());
				cEval.addMessage("MaxTravelDistance|On route :"+r.getId()+" distance travelled :"+travelDist+" greater than "+maxTravelDist);
			}
		}
	}

	/**
	 * Evaluate constraint with several types of vehicles
	 * 
	 * @return result
	 */
	private void evaluateMtdWithTypes() {
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
				currentType = ((IntValue) (fleet.get(i).getAttribute("Type")
						.get(0))).getValue();
				if (currentType == r.getType()) {
					int maxTravelDist=((IntValue) (Instance.getFleet().get(i)
							.getAttribute("maxTravelDistance").get(0)))
							.getValue();
					if (travelDist >maxTravelDist ) {
						System.out
								.println("Max travel distance of vehicle failed on route "
										+ r.getId());
						cEval.addMessage("MaxTravelDistance|On route :"+r.getId()+"vehicle of type : "+currentType+" travelled a distance of:"+travelDist+" greater than "+maxTravelDist);
					}
				}
			}
		}
	}
}
