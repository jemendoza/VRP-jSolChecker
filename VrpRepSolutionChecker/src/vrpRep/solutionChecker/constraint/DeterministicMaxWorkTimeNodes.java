/**
 * 
 */
package vrpRep.solutionChecker.constraint;

import java.util.List;

import vrpRep.solutionChecker.ConstraintEvaluation;
import vrpRep.solutionChecker.IConstraint;
import vrpRep.structure.instance.DoubleValue;
import vrpRep.structure.instance.Instance;
import vrpRep.structure.instance.SpeedInt;
import vrpRep.structure.instance.TimeWindow;
import vrpRep.structure.instance.VrpAtt;
import vrpRep.structure.solution.Request;
import vrpRep.structure.solution.Route;
import vrpRep.structure.solution.Solution;
import vrpRep.utilities.DistanceCalculator;

/**
 * Class checking the deterministic MaxWorkTime constraint by calculating time spend between two nodes. 
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 *
 */
public class DeterministicMaxWorkTimeNodes implements IConstraint {

	private ConstraintEvaluation cEval;
	/* (non-Javadoc)
	 * @see vrpRep.solutionChecker.constraint.IConstraint#evaluate()
	 */
	@Override
	public ConstraintEvaluation checkConstraint() {
		cEval = new ConstraintEvaluation();
		checkWorkTimeOnNodes();

		return cEval;
	}
	
	/**
	 * Method checking the constraint
	 */
	private void checkWorkTimeOnNodes() {
		int vehiType = -1;
		
		int departureNode, arrivalNode;
		double timeSpent = 0, speed;
		Request req;
		//each route
		for(Route r : Solution.getRoutes()){
			vehiType = (r.isHasType()?r.getType():-1);	
			
			if(Instance.getRequest(r.getRequests().get(0).getId()).getAttribute("serviceTime") != null)
				timeSpent = ((DoubleValue)Instance.getRequest(r.getRequests().get(0).getId()).getAttribute("serviceTime")).getValue();
			else
				timeSpent = 0;

			departureNode = r.getRequests().get(0).getNodeId();

			for(int reqIndex = 1; reqIndex < r.getRequests().size(); reqIndex++){
				req = r.getRequests().get(reqIndex);
				arrivalNode = req.getNodeId();
				
				if(vehiType != -1)
					speed = getSpeed(Instance.getVehicle(vehiType).getAttribute("speedProfile"), timeSpent);
				else
					speed = getSpeed(Instance.getVehicle(vehiType).getAttribute("speedProfile"), timeSpent);
				timeSpent += DistanceCalculator.calculateDistance(departureNode, arrivalNode)/speed;	
				timeSpent += ((DoubleValue)Instance.getRequest(req.getId()).getAttribute("serviceTime")).getValue();
			}
			
			if(vehiType == -1)
				vehiType = 0;
			if(timeSpent > ((DoubleValue)Instance.getVehicle(vehiType).getAttribute("wLPMaxWorkTime")).getValue()){
				
				cEval.addMessage("DeterministicMaxWorkTimeNodes|Route id "+r.getId()+
						" Vehicle id "+vehiType+
						" - "+timeSpent+" greater than "+((DoubleValue)Instance.getVehicle(vehiType).getAttribute("wLPMaxWorkTime")).getValue());
			}
				
		}	
	}
	
	/**
	 * @param speedProfile
	 * @param time
	 * @return speed of vehicle
	 */
	private double getSpeed(List<VrpAtt> speedProfile, double time){
		VrpAtt vAtt;		
		double min, max, speed = 0;
		min = Double.MAX_VALUE;
		max = -Double.MAX_VALUE;
		SpeedInt si;
		TimeWindow tw;		


		if(speedProfile == null)
			throw new NullPointerException();
		else{
			vAtt = speedProfile.get(0);
		}

		if(vAtt instanceof DoubleValue)
			return ((DoubleValue)Instance.getVehicle(0).getAttribute("speedProfile")).getValue();
		else{		
			int i = -1, j;
			while (++i < speedProfile.size() && !(min <= time && time <= max)){
				si = (SpeedInt)speedProfile.get(i);
				speed = si.getSpeed();
				j = -1;
				while (++j < si.getTw().size() && !(min <= time && time <= max)){
					tw = (TimeWindow)si.getTw().get(j);
					min = tw.getBegin();
					max = tw.getEnd();		
				}	
			}
			return speed;
		}
	}

}
