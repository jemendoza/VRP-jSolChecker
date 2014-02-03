/**
 * 
 */
package vrpRep.solutionChecker.constraint;

import java.util.List;

import vrpRep.solChecker.ConstraintEvaluation;
import vrpRep.solChecker.IConstraint;
import vrpRep.structure.instance.DoubleValue;
import vrpRep.structure.instance.Instance;
import vrpRep.structure.instance.Link;
import vrpRep.structure.instance.SpeedInt;
import vrpRep.structure.instance.TimeWindow;
import vrpRep.structure.instance.VrpAtt;
import vrpRep.structure.solution.Request;
import vrpRep.structure.solution.Route;
import vrpRep.structure.solution.Solution;
import vrpRep.utilities.DistanceCalculator;

/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 *
 */
public class DeterministicMaxWorkTime implements IConstraint {

	private ConstraintEvaluation cEval;
	/* (non-Javadoc)
	 * @see vrpRep.solutionChecker.constraint.IConstraint#evaluate()
	 */
	@Override
	public ConstraintEvaluation checkConstraint() {
		cEval = new ConstraintEvaluation();
		if(Instance.getLinks()!=null || Instance.getLinks().get(0).getAttribute("time")!=null)
			checkWorkTimeOnLinks();
		else
			checkWorkTimeOnNodes();

		return cEval;
	}


	private void checkWorkTimeOnLinks() {
		for(Route r : Solution.getRoutes()){
			double totalTime=0;
			vrpRep.structure.instance.Request requete = Instance.getRequest(r.getRequests().get(0).getId());
			if(requete.getAttribute("serviceTime")!=null){
				totalTime+=((DoubleValue)requete.getAttribute("serviceTime").get(0)).getValue();
			}
			for(int i=0;i<r.getRequests().size()-1;i++){

				int startNode =r.getRequests().get(i).getNodeId();
				int arrivalNode = r.getRequests().get(i+1).getNodeId();
				Link l = Instance.getLink(startNode, arrivalNode);
				//Si on a un temps sur les arcs.
				if(l.getAttribute("time")!=null){
					totalTime+=((DoubleValue)l.getAttribute("time").get(0)).getValue();
				}
				vrpRep.structure.instance.Request re = Instance.getRequest(r.getRequests().get(i+1).getId());
				if(re.getAttribute("serviceTime")!=null){
					totalTime+=((DoubleValue)re.getAttribute("serviceTime").get(0)).getValue();
				}

			}
			double maxWorkTime = ((DoubleValue)Instance.getFleet().get(r.getType()).getAttribute("wLPMaxWorkTime").get(0)).getValue();
			if(totalTime>maxWorkTime){
				cEval.addMessage("DeterministicMaxWorkTime|On Route "+r.getId()+" time worked is "+totalTime+" greater than "+maxWorkTime);
			}
		}
	}
	
	private void checkWorkTimeOnNodes() {
		int vehiType = -1;
		
		int departureNode, arrivalNode;
		double timeSpent = 0, speed;
		Request req;

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
					//speed = ((DoubleValue)Instance.getVehicleAttribute(vehiType, "speedProfile")).getValue();
				else
					speed = getSpeed(Instance.getVehicle(0).getAttribute("speedProfile"), timeSpent);
					//speed = ((DoubleValue)Instance.getVehicleAttribute(0, "speedProfile")).getValue();

				timeSpent += DistanceCalculator.calculateDistance(departureNode, arrivalNode)/speed;	
				timeSpent += ((DoubleValue)Instance.getRequest(req.getId()).getAttribute("serviceTime")).getValue();
			}
			
			if(vehiType == -1)
				vehiType = 0;
			if(timeSpent > ((DoubleValue)Instance.getVehicle(vehiType).getAttribute("wLPMaxWorkTime")).getValue()){
				cEval.addMessage("DeterministicMaxWorkTime|Route id "+r.getId()+
						" Vehicle id "+vehiType+
						" - "+timeSpent+" greater than "+((DoubleValue)Instance.getVehicle(vehiType).getAttribute("wLPMaxWorkTime")).getValue());
			}
				
		}	
	}
	
	private double getSpeed(List<VrpAtt> serviceTimes, double time){
		VrpAtt vAtt;		
		double min, max, speed = 0;
		min = Double.MAX_VALUE;
		max = -Double.MAX_VALUE;
		SpeedInt si;
		TimeWindow tw;		


		if(serviceTimes == null)
			throw new NullPointerException();
		else{
			vAtt = serviceTimes.get(0);
		}

		if(vAtt instanceof DoubleValue)
			return ((DoubleValue)Instance.getVehicle(0).getAttribute("speedProfile")).getValue();
		else{		
			int i = -1, j;
			while (++i < serviceTimes.size() && !(min <= time && time <= max)){
				si = (SpeedInt)serviceTimes.get(i);
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
