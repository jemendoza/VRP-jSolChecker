/**
 * 
 */
package vrpRep.solutionChecker.constraint;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import vrpRep.schema.instance.Instance.Fleet.Vehicle;
import vrpRep.schema.solution.Solution.Routes.Route;
import vrpRep.solutionChecker.instance.DefaultInstance;
import vrpRep.solutionChecker.solution.DefaultSolution;

/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 *
 */
public class NbVehicleAvailable implements IConstraint {

	/* (non-Javadoc)
	 * @see vrpRep.solutionChecker.constraint.IConstraint#evaluate(vrpRep.solutionChecker.instance.DefaultInstance, vrpRep.solutionChecker.solution.DefaultSolution)
	 */
	@Override
	public void evaluate(DefaultInstance inst, DefaultSolution sol) {

		List<BigInteger> nbVehicleTypeInstance = getInstanceVehicle(inst);

		List<BigInteger> nbVehicleTypeSolution = getSolutionVehicle(sol);

		boolean b = compare(nbVehicleTypeInstance,nbVehicleTypeSolution);
		System.out.println(b);
		

	}
	/**
	 * Compare the number of vehicle used per type with the vehicle available in the instance
	 * 
	 * @param nbVehicleTypeInstance is a list containing the number of vehicle AVAILABLE per type
	 * @param nbVehicleTypeSolution is a list containing the number of vehicle USED per type
	 * @return true if the number of vehicles contraint is verified
	 */
	private boolean compare(List<BigInteger> nbVehicleTypeInstance, List<BigInteger> nbVehicleTypeSolution) {
		boolean b=true;
		for(int i=0; i<nbVehicleTypeInstance.size();i++){
			if(nbVehicleTypeSolution.get(i).compareTo(nbVehicleTypeInstance.get(i))>0)
				b=false;
		}
		return b;
	}
	
	/**
	 * 
	 * @param inst : Object used to store XML solution data
	 * @return the list containing the number of vehicle AVAILABLE per type
	 */
	private List<BigInteger> getInstanceVehicle(DefaultInstance inst) {
		List<BigInteger> nbVehicleType = new ArrayList<BigInteger>();
		for(Vehicle v : inst.getFleet()){
			//If there is no type of vehicle define in the instance
			if(inst.getFleet().get(0).getType()==null){
				nbVehicleType.add(0,v.getNumber());
			}else{
				nbVehicleType.add(v.getType().intValue(),v.getNumber());
			}

		}
		return nbVehicleType;
	}

	/**
	 * 
	 * @param sol : Object used to store XML solution data
	 * @return the list containing the number of vehicle USED per type
	 */
	private List<BigInteger> getSolutionVehicle(DefaultSolution sol) {
		List<BigInteger> nbVehicleType = new ArrayList<BigInteger>(Collections.nCopies(sol.getSolution().getRoutes().getRoute().size(), BigInteger.ZERO));
		for(Route r: sol.getSolution().getRoutes().getRoute()){
			//If there is no type of vehicle define in the instance
			if(r.getType()==null){
				BigInteger b = nbVehicleType.get(0);
				nbVehicleType.set(0, b.add(new BigInteger("1")));
			}
			else
				nbVehicleType.set(r.getType().intValue(), nbVehicleType.get(r.getType().intValue()).add(new BigInteger("1")));
		}
		return nbVehicleType;
	}
}
