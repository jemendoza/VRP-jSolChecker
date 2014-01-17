/**
 * 
 */
package vrpRep.solutionChecker.constraint;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import vrpRep.fileReaders.InstanceTranslator;
import vrpRep.schema.instance.Instance;
import vrpRep.schema.instance.Instance.Fleet.Vehicle;
import vrpRep.schema.instance.Instance.Network.Nodes.Node;
import vrpRep.schema.instance.Instance.Requests.Request;
import vrpRep.solutionChecker.solution.DefaultSolution;
import vrpRep.solutionChecker.solution.Route;
import vrpRep.utilities.DistanceCalculator;

/**
 * Class verifies that all vehicle traveling distance constraints are respected.
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 *
 */
public class MaxTravelDistance implements IConstraint {

	private Instance inst;
	private DefaultSolution sol;
	
	
	/* (non-Javadoc)
	 * @see vrpRep.solutionChecker.constraint.IConstraint#evaluate(vrpRep.solutionChecker.instance.DefaultInstance, vrpRep.solutionChecker.solution.DefaultSolution)
	 */
	@Override
	public void evaluate(InstanceTranslator inst, DefaultSolution sol) {
		boolean result;
		this.inst = (Instance)inst.getInstance();
		this.sol = sol;
		
		if(this.inst.getFleet().getVehicle().get(0).getType() != null){	
			result = evaluateMtdWithTypes();
		}else{
			result = evaluateMtd();
		}
		System.out.println(result);
	}


	/**
	 * Evaluate constraint with only one type of vehicle
	 * @return result
	 */
	private boolean evaluateMtd(){
		boolean result = true;
		List<Vehicle> fleet = this.inst.getFleet().getVehicle();
		double travelDist;
		
		for(Route r : sol.getRoutes()){ // for each route
			travelDist = 0;
			for(int j = 0; j < r.getRoute().size()-1; j++){ // for each node pair
				try {
					travelDist += DistanceCalculator.getDistance(inst, BigInteger.valueOf(r.getRoute().get(j)), BigInteger.valueOf(r.getRoute().get(j+1)));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(travelDist > Double.valueOf(fleet.get(0).getMaxTravelDistance().getContent())){			
				System.out.println("Max travel distance of vehicle failed on route "+r.getId());
				result = false;
			}
		}
		return result;
	}
	
	
	/**
	 * Evaluate constraint with several types of vehicles
	 * @return result
	 */
	private boolean evaluateMtdWithTypes(){
		boolean result = true;
		List<Vehicle> fleet = this.inst.getFleet().getVehicle();
		BigInteger currentType;
		double travelDist;

		for(int i = 0; i < fleet.size(); i++){ // for each vehicle type
			currentType = fleet.get(i).getType();

			for(Route r : sol.getRoutes()){ // for each route
				travelDist = 0;
				
				if(BigInteger.valueOf(r.getType()) == currentType){	// if route requires current type
					for(int j = 0; j < r.getRoute().size()-1; j++){ // for each node pair
						try {
							travelDist += DistanceCalculator.getDistance(inst, BigInteger.valueOf(r.getRoute().get(j)), BigInteger.valueOf(r.getRoute().get(j+1)));
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
		
		return result;
	}	
	
}
