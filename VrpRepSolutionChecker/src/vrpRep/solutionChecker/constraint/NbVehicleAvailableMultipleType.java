/**
 * 
 */
package vrpRep.solutionChecker.constraint;

import java.util.ArrayList;
import java.util.List;

import vrpRep.solutionChecker.ConstraintEvaluation;
import vrpRep.solutionChecker.IConstraint;
import vrpRep.structure.instance.Instance;
import vrpRep.structure.instance.IntValue;
import vrpRep.structure.instance.Vehicle;

/**
 * Verifies solution does not violate the number of available vehicles when multiples vehicle
 * types exist.
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class NbVehicleAvailableMultipleType implements IConstraint {
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
			NbVehicleAvailableSingleType nvas = new NbVehicleAvailableSingleType();
			List<Integer> nbVehicleTypeSolution = nvas.getSolutionVehicle();
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
	private void compare(List<Integer> nbVehicleTypeInstance, List<Integer> nbVehicleTypeSolution) {

		for (int i = 0; i < nbVehicleTypeInstance.size(); i++) {
			if (nbVehicleTypeSolution.get(i) > nbVehicleTypeInstance.get(i)){
				cEval.addMessage("NbVehicleAvailableMultiple|Number of vehicle of type "+i+" available : "+nbVehicleTypeInstance.get(i)+" less than "+nbVehicleTypeSolution.get(i));
			}
		}
	}

	/**
	 * 
	 * @return the list containing the number of vehicle AVAILABLE per type
	 */
	private List<Integer> getInstanceVehicle() {
		List<Integer> nbVehicleType = new ArrayList<Integer>();
		for (Vehicle v : Instance.getFleet()) {
			nbVehicleType.add(((IntValue) v.getAttribute("type").get(0)).getValue(),
					((IntValue) v.getAttribute("number").get(0)).getValue());
		}

		return nbVehicleType;
	}

}