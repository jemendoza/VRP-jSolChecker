/**
 * 
 */
package vrpRep.solutionChecker.constraint;

import java.util.ArrayList;
import java.util.List;

import vrpRep.structure.instance.Instance;
import vrpRep.structure.instance.IntValue;
import vrpRep.structure.instance.Vehicle;
import vrpRep.utilities.ConstraintResult;

/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class NbVehicleAvailableMultiple implements IConstraint {

	private boolean				cValid	= true;
	private ArrayList<String>	details	= new ArrayList<String>();
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
		try {
			nbVehicleTypeInstance = getInstanceVehicle();
			NbVehicleAvailableSingle nvas = new NbVehicleAvailableSingle();
			List<Integer> nbVehicleTypeSolution = nvas.getSolutionVehicle();
			compare(nbVehicleTypeInstance, nbVehicleTypeSolution);

		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		if(cValid)
			return new ConstraintResult(cValid , "NbVehicleAvailableMultiple");
		else{
			String sResult =details.get(0);
			for(int i=1;i<details.size();i++)
				sResult=sResult.concat("\n" + details.get(i));
			return new ConstraintResult(cValid, sResult,"NbVehicleAvailableMultiple");
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
	 */
	private void compare(List<Integer> nbVehicleTypeInstance, List<Integer> nbVehicleTypeSolution) {

		for (int i = 0; i < nbVehicleTypeInstance.size(); i++) {
			if (nbVehicleTypeSolution.get(i) > nbVehicleTypeInstance.get(i)){
				cValid= false;
				details.add("Number of vehicle of type "+i+" available : "+nbVehicleTypeInstance.get(i)+" less than "+nbVehicleTypeSolution.get(i));
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