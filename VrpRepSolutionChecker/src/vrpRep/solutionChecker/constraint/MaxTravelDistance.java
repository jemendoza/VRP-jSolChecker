/**
 * 
 */
package vrpRep.solutionChecker.constraint;

import java.util.List;

import vrpRep.exceptions.MissingAttributeException;
import vrpRep.factory.DynamicFactory;
import vrpRep.structure.instance.Instance;
import vrpRep.structure.instance.IntValue;
import vrpRep.structure.instance.Node;
import vrpRep.structure.instance.Vehicle;
import vrpRep.structure.solution.Route;
import vrpRep.structure.solution.Solution;

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
	public void evaluate(Instance inst, Solution sol) {
		boolean result;
		this.inst = inst;
		this.sol = sol;

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
		double travelDist;
		int nodeId1, nodeId2;
		Node head, tail;

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
					head = inst.getNode(nodeId1);
					tail = inst.getNode(nodeId2);
					travelDist += DynamicFactory.getFactory()
							.getDistanceCalculator().calculDistance(head, tail);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			try {
				if (travelDist > ((IntValue) (inst.getFleet().get(0)
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
		List<Vehicle> fleet = this.inst.getFleet();
		int currentType = 0, nodeId1, nodeId2;
		double travelDist;
		Node head, tail;

		for (Route r : sol.getRoutes()) {
			travelDist = 0;
			for (int j = 0; j < r.getRequests().size() - 1; j++) {
				try {
					nodeId1 = ((IntValue) inst.getRequest(
							r.getRequests().get(j).getId())
							.getAttribute("node")).getValue();
					nodeId2 = ((IntValue) inst.getRequest(
							r.getRequests().get(j + 1).getId()).getAttribute(
							"node")).getValue();
					head = inst.getNode(nodeId1);
					tail = inst.getNode(nodeId2);
					travelDist += DynamicFactory.getFactory()
							.getDistanceCalculator().calculDistance(head, tail);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			for (int i = 0; i < fleet.size(); i++) {
				try {
					currentType = ((IntValue) (fleet.get(i)
							.getAttribute("Type").get(0))).getValue();
					if (currentType == r.getType()) {
						if (travelDist > ((IntValue) (inst.getFleet().get(i)
								.getAttribute("maxTravelDistance").get(0)))
								.getValue()) {
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
