/**
 * 
 */
package vrpRep.solutionChecker.constraint;

import java.util.ArrayList;

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
public class DepartureArrivalNode implements IConstraint {

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

	@Override
	public ConstraintResult evaluate() {

		test();
		if(cValid)
			return new ConstraintResult(cValid , "DepartureArrivalNode");
		else{
			String sResult =details.get(0);
			for(int i=1;i<details.size();i++)
				sResult=sResult.concat("\n" + details.get(i));
			return new ConstraintResult(cValid, sResult,"DepartureArrivalNode");
		}
	}

	private void test() {
		for (Route r : Solution.getRoutes()) {
			int b = r.getType();

			if (r.getRequests().get(0).getNodeId() != -1) {
				int routeNodeStart = r.getRequests().get(0).getNodeId();
				int routeNodeArrival = r.getRequests().get(r.getRequests().size()-1)
						.getNodeId();
				for (Vehicle v : Instance.getFleet()) {
					if (v.getAttribute("type").get(0) != null) {
						int vehicleType = ((IntValue)v.getAttribute("type").get(0)).getValue();
						if (vehicleType == b) {
							int vehicleNodeArrival = ((IntValue) v.getAttribute("arrivalNode").get(0)).getValue();
							int vehicleNodeStart = ((IntValue) v.getAttribute("departureNode").get(0)).getValue();
							if (vehicleNodeArrival != routeNodeArrival|| vehicleNodeStart != routeNodeStart){
								details.add("On Route ID : "+r.getId()+
										", Departure Node : "+routeNodeStart+
										", Arrival Node : "+routeNodeArrival+
										" but Vehicle of type "+vehicleType+
										" Departure Node is "+vehicleNodeStart+
										" and Arrival Node is "+vehicleNodeArrival);
								cValid=false;
							}

						}
					} else {
						int vehicleNodeArrival = ((IntValue) v.getAttribute("arrivalNode").get(0)).getValue();
						int vehicleNodeStart = ((IntValue) v.getAttribute("departureNode").get(0)).getValue();
						if (((IntValue) v.getAttribute("arrivalNode").get(0)).getValue() != 
								routeNodeArrival|| ((IntValue) v.getAttribute("departureNode").get(0)).getValue() != routeNodeStart){
							details.add("On Route ID : "+r.getId()+
									", Departure Node : "+routeNodeStart+
									", Arrival Node : "+routeNodeArrival+
									" but Vehicle "+
									" Departure Node is "+vehicleNodeStart+
									" and Arrival Node is "+vehicleNodeArrival);
							cValid= false;
						}
					}
				}
			} 
		}
	}
}
