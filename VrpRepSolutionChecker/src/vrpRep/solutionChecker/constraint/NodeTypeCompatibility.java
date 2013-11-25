/**
 * 
 */
package vrpRep.solutionChecker.constraint;


import java.util.*;
import java.math.BigInteger;

import vrpRep.schema.instance.Instance.Fleet.Vehicle;
import vrpRep.schema.instance.Instance.Network.Nodes.Node;
import vrpRep.schema.solution.Solution.Routes.Route;
import vrpRep.solutionChecker.instance.DefaultInstance;
import vrpRep.solutionChecker.solution.DefaultSolution;

/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 *
 */
public class NodeTypeCompatibility implements IConstraint {

	/* (non-Javadoc)
	 * @see vrpRep.solutionChecker.constraint.IConstraint#evaluate(vrpRep.solutionChecker.instance.DefaultInstance, vrpRep.solutionChecker.solution.DefaultSolution)
	 */
	@Override
	public void evaluate(DefaultInstance inst, DefaultSolution sol) {
		
		List<List<BigInteger>> listCompatibilityInstance = vehicleNodeCompatibilityInstance(inst);
		List<BigInteger>listNodeType = getListNodeType(inst);
		boolean b = checkCompatibility(listCompatibilityInstance, listNodeType, sol);
		
	}

	
	/**
	 * Check if every vehicle pass through a compatible node
	 * 
	 * @param listCompatibilityInstance : contain all the node compatible for each vehicle
	 * @param listNodeType : contain all type of each node
	 * @param sol : Object used to store XML solution data
	 * @return true if the node/vehicle compatibility is respected
	 */
	private boolean checkCompatibility(List<List<BigInteger>> listCompatibilityInstance, List<BigInteger> listNodeType, DefaultSolution sol) {
		
		for(Route r: sol.getSolution().getRoutes().getRoute()){
			//Type de véhicle de la route
			BigInteger b = r.getType();
			for (vrpRep.schema.solution.Solution.Routes.Route.Node n :r.getNode()){
				if(!listCompatibilityInstance.get(b.intValue()).contains(listNodeType.get(Integer.parseInt(n.getContent())))){
					return false;
				}
			}
		}
		return true;
	}


	/**
	 * 
	 * @param inst : Object used to store XML instance data
	 * @return a list with all the node's type
	 */
	private List<BigInteger> getListNodeType(DefaultInstance inst) {
		List<BigInteger> list = new ArrayList<BigInteger>();
		for(Node n : inst.getInstance().getNetwork().getNodes().getNode()){
			list.add(n.getId().intValue(),n.getType());
		}
		return list;
	}


	/**
	 * 
	 * @param inst : Object used to store XML instance data
	 * @return a list containing all the node compatible for each vehicle
	 */
	private List<List<BigInteger>> vehicleNodeCompatibilityInstance(DefaultInstance inst) {
		List<List<BigInteger>> list = new ArrayList<List<BigInteger>>();
		for(Vehicle v : inst.getFleet()){
			list.add(v.getType().intValue(),v.getNodeTypesCompatible());
		}
		return list;
	}

}
