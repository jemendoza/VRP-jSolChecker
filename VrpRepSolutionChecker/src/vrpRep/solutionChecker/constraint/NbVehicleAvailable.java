/**
 * 
 */
package vrpRep.solutionChecker.constraint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import vrpRep.structure.instance.Instance;
import vrpRep.structure.instance.IntValue;
import vrpRep.structure.instance.Vehicle;
import vrpRep.structure.solution.Route;
import vrpRep.structure.solution.Solution;
import vrpRep.utilities.ConstraintResult;

/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class NbVehicleAvailable implements IConstraint {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * vrpRep.solutionChecker.constraint.IConstraint#evaluate(vrpRep.solutionChecker
	 * .instance.DefaultInstance,
	 * vrpRep.solutionChecker.solution.DefaultSolution)
	 */
	public ConstraintResult evaluate() {
		List<Integer> nbVehicleTypeInstance;
		boolean valid = false;
		try {
			nbVehicleTypeInstance = getInstanceVehicle();
			List<Integer> nbVehicleTypeSolution = getSolutionVehicle();
			
			valid  = compare(nbVehicleTypeInstance, nbVehicleTypeSolution);
			;

		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return new ConstraintResult(valid, "","");

	}

	/**
	 * Compare the number of vehicle used per type with the vehicle available in
	 * the instance
	 * 
	 * @param nbVehicleTypeInstance
	 *            is a list containing the number of vehicle AVAILABLE per type
	 * @param nbVehicleTypeSolution
	 *            is a list containing the number of vehicle USED per type
	 * @return true if the number of vehicles contraint is verified
	 */
	private boolean compare(List<Integer> nbVehicleTypeInstance,
			List<Integer> nbVehicleTypeSolution) {
		if (nbVehicleTypeInstance.size() == 1) {
			if (nbVehicleTypeInstance.get(0) < nbVehicleTypeSolution.get(0))
				return false;
		} else {
			for (int i = 0; i < nbVehicleTypeInstance.size(); i++) {
				if (nbVehicleTypeSolution.get(i) > nbVehicleTypeInstance.get(i))
					return false;
			}
		}
		return true;
	}

	/**
	 * 
	 * @param inst2
	 *            : Object used to store XML solution data
	 * @return the list containing the number of vehicle AVAILABLE per type
	 * @throws MissingAttributeException
	 * @throws NumberFormatException
	 */
	private List<Integer> getInstanceVehicle() {
		List<Integer> nbVehicleType = new ArrayList<Integer>();
		if (Instance.getFleet().size() == 1) {
			nbVehicleType.add(((IntValue) Instance.getFleet().get(0)
					.getAttribute("number").get(0)).getValue());
		} else {
			for (Vehicle v : Instance.getFleet()) {

				nbVehicleType
						.add(((IntValue) v.getAttribute("type").get(0))
								.getValue(),
								((IntValue) v.getAttribute("number").get(0))
										.getValue());
			}

		}

		return nbVehicleType;
	}

	/**
	 * 
	 * @return the list containing the number of vehicle USED per type
	 */
	private List<Integer> getSolutionVehicle() {
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
