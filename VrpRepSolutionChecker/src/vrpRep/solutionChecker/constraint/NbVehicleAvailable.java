/**
 * 
 */
package vrpRep.solutionChecker.constraint;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import vrpRep.exceptions.MissingAttributeException;
import vrpRep.structure.instance.Instance;
import vrpRep.structure.instance.Vehicle;
import vrpRep.structure.solution.Route;
import vrpRep.structure.solution.Solution;

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

	private Instance	inst;
	private Solution	sol;

	public void evaluate(Instance instance, Solution solution) {

		this.inst = instance;
		this.sol = solution;
		List<BigInteger> nbVehicleTypeInstance;
		try {
			nbVehicleTypeInstance = getInstanceVehicle(inst);
			List<BigInteger> nbVehicleTypeSolution = getSolutionVehicle(sol);
			boolean b = compare(nbVehicleTypeInstance, nbVehicleTypeSolution);
			System.out.println(b);

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (MissingAttributeException e) {
			e.printStackTrace();
		}

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
	private boolean compare(List<BigInteger> nbVehicleTypeInstance,
			List<BigInteger> nbVehicleTypeSolution) {

		for (int i = 0; i < nbVehicleTypeInstance.size(); i++) {
			if (nbVehicleTypeSolution.get(i).compareTo(
					nbVehicleTypeInstance.get(i)) > 0)
				return false;
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
	private List<BigInteger> getInstanceVehicle(Instance inst)
			throws NumberFormatException, MissingAttributeException {
		List<BigInteger> nbVehicleType = new ArrayList<BigInteger>();
		for (Vehicle v : inst.getFleet()) {
			// If there is no type of vehicle define in the instance
			if (inst.getFleet().get(0).getAttribute("type") == null) {
				nbVehicleType.add(0, (BigInteger) v.getAttribute("number"));
			} else {
				nbVehicleType.add(
						Integer.valueOf(v.getAttribute("type").get(0)
								.toString()),
						(BigInteger) v.getAttribute("number").get(0));
			}

		}
		return nbVehicleType;
	}

	/**
	 * 
	 * @param sol
	 *            : Object used to store XML solution data
	 * @return the list containing the number of vehicle USED per type
	 */
	private List<BigInteger> getSolutionVehicle(Solution sol) {
		List<BigInteger> nbVehicleType = new ArrayList<BigInteger>(
				Collections.nCopies(sol.getRoutes().size(), BigInteger.ZERO));
		for (Route r : sol.getRoutes()) {
			// If there is no type of vehicle define in the instance
			if (r.isHasType() == false) {
				BigInteger b = nbVehicleType.get(0);
				nbVehicleType.set(0, b.add(new BigInteger("1")));
			} else
				nbVehicleType.set(r.getType(), nbVehicleType.get(r.getType())
						.add(new BigInteger("1")));
		}
		return nbVehicleType;
	}

}
