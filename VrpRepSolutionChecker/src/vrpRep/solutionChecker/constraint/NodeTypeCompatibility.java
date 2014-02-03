/**
 * 
 */
package vrpRep.solutionChecker.constraint;

import java.util.ArrayList;
import java.util.List;

import vrpRep.solChecker.ConstraintEvaluation;
import vrpRep.solChecker.IConstraint;
import vrpRep.structure.instance.Instance;
import vrpRep.structure.instance.IntValue;
import vrpRep.structure.instance.Node;
import vrpRep.structure.instance.Vehicle;
import vrpRep.structure.instance.VrpAtt;
import vrpRep.structure.solution.Request;
import vrpRep.structure.solution.Route;
import vrpRep.structure.solution.Solution;

/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class NodeTypeCompatibility implements IConstraint {

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
		List<List<Integer>> listCompatibilityInstance;
		try {
			listCompatibilityInstance = vehicleNodeCompatibilityInstance();
			List<Integer> listNodeType = getListNodeType();
			checkCompatibility(listCompatibilityInstance, listNodeType);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return cEval;

	}

	/**
	 * Check if every vehicle passes through a compatible node
	 * 
	 * @param listCompatibilityInstance
	 *            : contain all the node compatible for each vehicle
	 * @param listNodeType
	 *            : contain all type of each node
	 */
	private	void checkCompatibility(
			List<List<Integer>> listCompatibilityInstance,
			List<Integer> listNodeType) {

		for (Route r : Solution.getRoutes()) {
			// Type de véhicle de la route
			if(r.isHasType()) {
				int type = r.getType();
				for (Request n : r.getRequests()) {
					if (!listCompatibilityInstance.get(type).contains(
							listNodeType.get(n.getNodeId()))) {
						cEval.addMessage("NodeTypeCompatibility|The vehicle of type "+r.getType()+" is not compatible to pass on node "+n.getNodeId()+" on route "+r.getId());
					}
				}
			}
		}
	}

	/**
	 * 
	 * @param inst
	 *            : Object used to store XML instance data
	 * @return a list with all the node's type
	 * @throws NumberFormatException
	 */
	private List<Integer> getListNodeType() throws NumberFormatException {
		List<Integer> list = new ArrayList<Integer>();
		for (Node n : Instance.getNodes()) {
			list.add(n.getId(),
					((IntValue) n.getAttribute("type").get(0)).getValue());
		}
		return list;
	}

	/**
	 * 
	 * @param inst
	 *            : Object used to store XML instance data
	 * @return a list containing all the node compatible for each vehicle
	 * @throws NumberFormatException
	 */
	private List<List<Integer>> vehicleNodeCompatibilityInstance()
			throws NumberFormatException {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		for (Vehicle v : Instance.getFleet()) {
			list.add(((IntValue) v.getAttribute("type").get(0)).getValue(),
					getNodeTypesCompatible(v
							.getAttribute("nodeTypesCompatible")));
		}
		return list;
	}

	/**
	 * 
	 * @param listAtt
	 * @return List of compatible nodes
	 */
	private List<Integer> getNodeTypesCompatible(List<VrpAtt> listAtt) {
		List<Integer> listInt = new ArrayList<Integer>();
		for (VrpAtt att : listAtt) {
			listInt.add(((IntValue) att).getValue());
		}
		return listInt;
	}
}
