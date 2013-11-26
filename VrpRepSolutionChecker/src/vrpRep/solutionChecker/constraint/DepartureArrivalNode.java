/**
 * 
 */
package vrpRep.solutionChecker.constraint;


import java.math.BigInteger;

import vrpRep.schema.instance.Instance;
import vrpRep.schema.instance.Instance.Fleet.Vehicle;
import vrpRep.schema.solution.Solution;
import vrpRep.schema.solution.Solution.Routes.Route;
import vrpRep.solutionChecker.instance.StandardInstance;
import vrpRep.solutionChecker.solution.DefaultSolution;

/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 *
 */
public class DepartureArrivalNode implements IConstraint {

	/* (non-Javadoc)
	 * @see vrpRep.solutionChecker.constraint.IConstraint#evaluate(vrpRep.solutionChecker.instance.DefaultInstance, vrpRep.solutionChecker.solution.DefaultSolution)
	 */
	private Instance instance;
	private Solution solution;

	@Override
	public void evaluate(StandardInstance inst, DefaultSolution sol) {
		instance = (Instance) inst.getInstance();
		solution = sol.getSolution();
		boolean b = test();

	}

	private boolean test() {
		for(Route r: solution.getRoutes().getRoute()){
			BigInteger b = r.getType();
			int nodeStart = Integer.parseInt(r.getNode().get(0).getContent());
			int nodeArrival = Integer.parseInt(r.getNode().get(r.getNode().size()-1).getContent());
			for(Vehicle v : instance.getFleet().getVehicle()){
				if(v.getType().equals(b)){
					if(!v.getArrivalNode().equals(nodeArrival) || !v.getDepartureNode().equals(nodeStart))
						return false;

				}
			}
			
		}
		return true;
	}
}
