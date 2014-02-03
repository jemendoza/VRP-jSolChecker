/**
 * 
 */
package vrpRep.solutionChecker.objective;

import java.util.List;

import vrpRep.solutionChecker.IObjectiveFunction;
import vrpRep.structure.solution.Request;
import vrpRep.structure.solution.Route;
import vrpRep.structure.solution.Solution;
import vrpRep.utilities.DistanceCalculator;

/**
 * Calculates the total distance traveled in a solution.
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 *
 */
public class TotalDistance implements IObjectiveFunction {

	/* (non-Javadoc)
	 * @see vrpRep.solutionChecker.IObjectiveFunction#evaluate()
	 */
	@Override
	public double evaluate() {
		double result = 0;
		// each route
		for (Route r : Solution.getRoutes()) {
			// sum demands
			List<Request> requests = r.getRequests();
			for(int i = 1; i < requests.size(); i++){
				result += DistanceCalculator.calculateDistance(requests.get(i-1).getNodeId(), requests.get(i).getNodeId());
			}
		}
		return result;
	}

}
