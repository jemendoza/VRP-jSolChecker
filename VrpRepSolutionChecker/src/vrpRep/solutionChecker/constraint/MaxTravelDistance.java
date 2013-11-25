/**
 * 
 */
package vrpRep.solutionChecker.constraint;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import vrpRep.schema.instance.Instance.Fleet.Vehicle;
import vrpRep.schema.instance.Instance.Network.Nodes.Node;
import vrpRep.schema.instance.Instance.Requests.Request;
import vrpRep.solutionChecker.instance.DefaultInstance;
import vrpRep.solutionChecker.solution.DefaultSolution;
import vrpRep.solutionChecker.solution.Route;
import vrpRep.utilities.DistanceCalculator;

/**
 * Class verifies that all vehicle traveling distance constraints are respected.
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 *
 */
public class MaxTravelDistance implements IConstraint {

	private DefaultInstance inst;
	
	
	/* (non-Javadoc)
	 * @see vrpRep.solutionChecker.constraint.IConstraint#evaluate(vrpRep.solutionChecker.instance.DefaultInstance, vrpRep.solutionChecker.solution.DefaultSolution)
	 */
	@Override
	public void evaluate(DefaultInstance inst, DefaultSolution sol) {
		this.inst = inst;
		boolean result = true;

		// TODO requests on links

		List<Vehicle> fleet = inst.getFleet();
		double travelDist;

		if(fleet.get(0).getType() != null){	
			BigInteger currentType;

			for(int i = 0; i < fleet.size(); i++){ // for each vehicle type
				currentType = fleet.get(i).getType();

				for(Route r : sol.getRoutes()){ // for each route
					travelDist = 0;
					
					if(BigInteger.valueOf(r.getType()) == currentType){	// if route requires current type
						for(int j = 0; j < r.getRoute().size()-1; j++){ // for each node pair
							try {
								travelDist += DistanceCalculator.getDistance(inst.getInstance(), getNode(BigInteger.valueOf(r.getRoute().get(j))), getNode(BigInteger.valueOf(r.getRoute().get(j+1))));
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
					if(travelDist > Double.valueOf(fleet.get(i).getMaxTravelDistance().getContent())){			
						System.out.println("Max travel distance of vehicle "+fleet.get(i).getType()+" failed on route "+r.getId());
						result = false;
					}
				}

			}

		}else{
			for(Route r : sol.getRoutes()){ // for each route
				travelDist = 0;
				for(int j = 0; j < r.getRoute().size()-1; j++){ // for each node pair
					try {
						travelDist += DistanceCalculator.getDistance(inst.getInstance(), getNode(BigInteger.valueOf(r.getRoute().get(j))), getNode(BigInteger.valueOf(r.getRoute().get(j+1))));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				if(travelDist > Double.valueOf(fleet.get(0).getMaxTravelDistance().getContent())){			
					System.out.println("Max travel distance of vehicle failed on route "+r.getId());
					result = false;
				}
			}
		}
		System.out.println(result);
	}

	
	/**
	 * Retrieve node in instance file based on node id
	 * @param nodeId Id of node
	 * @return Node object in instance file of id nodeId
	 */
	private Node getNode(BigInteger nodeId){
		List<Node> nodes = this.inst.getNodes();
		int i = 0;

		while(i < nodes.size() && nodes.get(i).getId() != nodeId){
			i++;
		}

		if(i < nodes.size())
			return nodes.get(i);
		else
			return null;
	}



}
