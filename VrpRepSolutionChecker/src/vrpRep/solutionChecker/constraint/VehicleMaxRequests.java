/**
 * 
 */
package vrpRep.solutionChecker.constraint;

import vrpRep.solutionChecker.ConstraintEvaluation;
import vrpRep.solutionChecker.IConstraint;
import vrpRep.structure.instance.Instance;
import vrpRep.structure.instance.IntValue;
import vrpRep.structure.solution.Route;
import vrpRep.structure.solution.Solution;

/**
 * Verifies the solution does not viloate the maximum number of requests each vehicle can serve.
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class VehicleMaxRequests implements IConstraint {
	/**
	 * Evaluation result
	 */
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
		try {
			checkMaxRequests();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return cEval;
	}
	/**
	 * Evaluate constraint
	 * @throws NumberFormatException
	 */
	private void checkMaxRequests() throws NumberFormatException {

		int maxRequest;
		//each route
		for (Route r : Solution.getRoutes()) {
			int type =0;
			if (r.isHasType()) 
				type = r.getType();
			
			maxRequest = ((IntValue) Instance.getFleet().get(type)
					.getAttribute("maxRequests").get(0)).getValue();

			if (maxRequest < r.getRequests().size()){
				cEval.addMessage("VehicleMaxRequests|Number of requests for the vehicle "+r.getType()+" greater than "+maxRequest+" on the route "+r.getId());
			}
		}
	}
}
