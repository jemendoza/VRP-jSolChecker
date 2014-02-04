package vrpRep.solutionChecker.constraint;

import vrpRep.solutionChecker.ConstraintEvaluation;
import vrpRep.solutionChecker.IConstraint;
import vrpRep.structure.instance.DoubleValue;
import vrpRep.structure.instance.Instance;
import vrpRep.structure.solution.Request;
import vrpRep.structure.solution.Route;
import vrpRep.structure.solution.Solution;
import vrpRep.utilities.DistanceCalculator;
/**
 * Verifies the request release dates are respected when travel times are calculated
 * by node sepration distances and vehicle speeds.
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 *
 */
public class DeterministicReleaseDateOnNodes implements IConstraint {
	/**
	 * Evaluation result
	 */
	private ConstraintEvaluation cEval;


	@Override
	public ConstraintEvaluation checkConstraint() {
		cEval = new ConstraintEvaluation();
		evaluate();
		return cEval;
	}

	private void evaluate(){
		DeterministicMaxWorkTimeNodes mxton = new DeterministicMaxWorkTimeNodes();

		int vehiType = -1;

		int departureNode, arrivalNode;
		double timeSpent = 0, speed;
		Request req;
		//each route
		for(Route r : Solution.getRoutes()){
			vehiType = (r.isHasType()?r.getType():-1);	

			if(Instance.getRequest(r.getRequests().get(0).getId()).getAttribute("serviceTime") != null)
				timeSpent = ((DoubleValue)Instance.getRequest(r.getRequests().get(0).getId()).getAttribute("serviceTime").get(0)).getValue();
			else
				timeSpent = 0;

		

			for(int reqIndex = 1; reqIndex < r.getRequests().size(); reqIndex++){
				req = r.getRequests().get(reqIndex);
				departureNode = r.getRequests().get(reqIndex-1).getNodeId();
				arrivalNode = req.getNodeId();

				if(vehiType != -1)
					speed = mxton.getSpeed(Instance.getVehicle(vehiType).getAttribute("speedProfile"), timeSpent);
				else
					speed = mxton.getSpeed(Instance.getVehicle(vehiType).getAttribute("speedProfile"), timeSpent);
				timeSpent += DistanceCalculator.calculateDistance(departureNode, arrivalNode)/speed;	

				if(((DoubleValue)Instance.getRequest(req.getId()).getAttribute("releaseDate").get(0)).getValue() > timeSpent)
					cEval.addMessage("DeterministicReleaseDateOnNodes|"+
							"Request : "+req.getId()+
							"is served at : "+timeSpent+
							"which is before : "+((DoubleValue)Instance.getRequest(req.getId()).getAttribute("releaseDate").get(0)).getValue());

				if(Instance.getRequest(req.getId()).getAttribute("serviceTime") != null)
					timeSpent += ((DoubleValue)Instance.getRequest(req.getId()).getAttribute("serviceTime").get(0)).getValue();
			}				
		}	
	}

}
