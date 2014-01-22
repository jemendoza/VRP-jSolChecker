/**
 * 
 */
package vrpRep.solutionChecker.constraint;

import java.util.ArrayList;
import java.util.List;

import vrpRep.exceptions.MissingAttributeException;
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
		List<List<Integer>> listCompatibilityInstance;
		try {
			listCompatibilityInstance = vehicleNodeCompatibilityInstance();
			List<Integer> listNodeType = getListNodeType();
			boolean b = checkCompatibility(listCompatibilityInstance,
					listNodeType);
			System.out.println(b);

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MissingAttributeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Check if every vehicle pass through a compatible node
	 * 
	 * @param listCompatibilityInstance
	 *            : contain all the node compatible for each vehicle
	 * @param listNodeType
	 *            : contain all type of each node
	 * @param sol
	 *            : Object used to store XML solution data
	 * @return true if the node/vehicle compatibility is respected
	 */
	private boolean checkCompatibility(
			List<List<Integer>> listCompatibilityInstance,
			List<Integer> listNodeType) {

		for (Route r : Solution.getRoutes()) {
			// Type de véhicle de la route
			int b = r.getType();
			for (Request n : r.getRequests()) {
				if (!listCompatibilityInstance.get(b).contains(
						listNodeType.get(n.getId()))) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * 
	 * @param inst
	 *            : Object used to store XML instance data
	 * @return a list with all the node's type
	 * @throws MissingAttributeException
	 * @throws NumberFormatException
	 */
	private List<Integer> getListNodeType() throws NumberFormatException,
			MissingAttributeException {
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
	 * @throws MissingAttributeException
	 * @throws NumberFormatException
	 */
	private List<List<Integer>> vehicleNodeCompatibilityInstance()
			throws NumberFormatException, MissingAttributeException {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		for (Vehicle v : Instance.getFleet()) {
			list.add(((IntValue) v.getAttribute("type").get(0)).getValue(),
					getNodeTypesCompatible(v
							.getAttribute("nodeTypesCompatible")));
		}
		return list;
	}

	private List<Integer> getNodeTypesCompatible(List<VrpAtt> listAtt) {
		List<Integer> listInt = new ArrayList<Integer>();
		for (VrpAtt att : listAtt) {
			listInt.add(((IntValue) att).getValue());
		}
		return listInt;
	}
}
