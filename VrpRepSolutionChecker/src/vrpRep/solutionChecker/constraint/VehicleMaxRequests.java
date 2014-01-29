/**
 * 
 */
package vrpRep.solutionChecker.constraint;

import java.util.ArrayList;

import vrpRep.structure.instance.Instance;
import vrpRep.structure.instance.IntValue;
import vrpRep.structure.solution.Route;
import vrpRep.structure.solution.Solution;
import vrpRep.utilities.ConstraintResult;

/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class VehicleMaxRequests implements IConstraint {

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
		try {
			checkMaxRequests();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		if(cValid)
			return new ConstraintResult(cValid , "DepartureArrivalNode");
		else{
			String sResult =details.get(0);
			for(int i=1;i<details.size();i++)
				sResult=sResult.concat("\n" + details.get(i));
			return new ConstraintResult(cValid, sResult,"DepartureArrivalNode");
		}
	}

	private void checkMaxRequests() throws NumberFormatException {

		int maxRequest;
		for (Route r : Solution.getRoutes()) {
			int type =0;
			if (r.isHasType()) 
				type = r.getType();
			maxRequest = ((IntValue) Instance.getFleet().get(type)
					.getAttribute("maxRequests").get(0)).getValue();

			if (maxRequest < r.getRequests().size()){
				cValid=false;
				details.add("Number of requests for the vehicle "+r.getType()+" greater than "+maxRequest);
			}
		}
	}
}
