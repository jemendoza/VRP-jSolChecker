/**
 * 
 */
package vrpRep.solutionChecker.constraint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import vrpRep.solutionChecker.ConstraintEvaluation;
import vrpRep.solutionChecker.IConstraint;
import vrpRep.structure.instance.Instance;
import vrpRep.structure.instance.IntValue;
import vrpRep.structure.solution.Route;
import vrpRep.structure.solution.Solution;

/**
 * Verifies solution does not violate the number of available vehicles when only one vehicle
 * type exists.
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class NbVehicleAvailableSingleType implements IConstraint {
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
	public ConstraintEvaluation checkConstraint() {
		cEval = new ConstraintEvaluation();
		List<Integer> nbVehicleTypeInstance;
		try {
			nbVehicleTypeInstance = getInstanceVehicle();
			List<Integer> nbVehicleTypeSolution = getSolutionVehicle();
			compare(nbVehicleTypeInstance, nbVehicleTypeSolution);

		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return cEval;

	}

	/**
	 * Compare the number of vehicle used per type with the vehicle available in
	 * the instance
	 * 
	 * @param nbVehicleTypeInstance
	 *            is a list containing the number of vehicle AVAILABLE per type
	 * @param nbVehicleTypeSolution
	 *            is a list containing the number of vehicle USED per type
	 */
	private void compare(List<Integer> nbVehicleTypeInstance,
			List<Integer> nbVehicleTypeSolution) {

		if (nbVehicleTypeInstance.get(0) < nbVehicleTypeSolution.get(0)){
			cEval.addMessage("NbVehicleAvailableSingle|Number of vehicle available : "+nbVehicleTypeInstance.get(0)+" less than "+nbVehicleTypeSolution.get(0));
		}
	}

	/**
	 * 
	 * @return the list containing the number of vehicle AVAILABLE per type
	 */
	private List<Integer> getInstanceVehicle() {
		List<Integer> nbVehicleType = new ArrayList<Integer>();
		nbVehicleType.add(((IntValue) Instance.getFleet().get(0).getAttribute("number").get(0)).getValue());

		return nbVehicleType;
	}

	/**
	 * 
	 * @return the list containing the number of vehicle USED per type
	 */
	public List<Integer> getSolutionVehicle() {
		List<Integer> nbVehicleType = new ArrayList<Integer>(
				Collections.nCopies(Solution.getRoutes().size(), 0));
		for (Route r : Solution.getRoutes()) {
			// If there is no type of vehicle define in the instance
			if (r.isHasType() == false) {
				int b = nbVehicleType.get(0);
				nbVehicleType.set(0, nbVehicleType.get(b) + 1);
			} else
				nbVehicleType.set(r.getType(),
						nbVehicleType.get(r.getType()) + 1);
		}
		return nbVehicleType;
	}
}
