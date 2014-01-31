/**
 * 
 */
package vrpRep.solutionChecker.constraint;

import java.util.ArrayList;

import vrpRep.structure.instance.Instance;
import vrpRep.structure.instance.IntValue;
import vrpRep.structure.solution.Route;
import vrpRep.structure.solution.Solution;
import vrpRep.utilities.ConstraintResult;
import vrpRep.utilities.DistanceCalculator;

/**
 * Class verifies that all vehicle traveling distance constraints are respected.
 * 
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class MaxTravelDistanceNoType implements IConstraint {

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
		evaluateMtd();
		
		if(cValid)
			return new ConstraintResult(cValid , "MaxTravelDistanceNoType");
		else{
			String sResult =details.get(0);
			for(int i=1;i<details.size();i++)
				sResult=sResult.concat("\n" + details.get(i));
			return new ConstraintResult(cValid, sResult,"MaxTravelDistanceNoType");
		}
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
				cValid = false;
				details.add("On route :"+r.getId()+" distance travelled :"+travelDist+" greater than "+maxTravelDist);
			}
		}
	}

}