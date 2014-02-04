/**
 * 
 */
package vrpRep.solutionChecker.constraint;

import java.util.List;

import vrpRep.solutionChecker.ConstraintEvaluation;
import vrpRep.solutionChecker.IConstraint;
import vrpRep.structure.instance.DoubleValue;
import vrpRep.structure.instance.Instance;
import vrpRep.structure.instance.TimeWindow;
import vrpRep.structure.instance.VrpAtt;
import vrpRep.structure.solution.Route;
import vrpRep.structure.solution.Solution;

/**
 * Verifies the request time windows are respected when travel times are calculated over links
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 *
 */
public class DeterministicRequestTimeWindowOnLinks implements IConstraint {
	/**
	 * Evaluation result
	 */
	private ConstraintEvaluation cEval;
	/* (non-Javadoc)
	 * @see vrpRep.solutionChecker.IConstraint#checkConstraint()
	 */
	@Override
	public ConstraintEvaluation checkConstraint() {
		cEval = new ConstraintEvaluation();
		evaluate();

		return cEval;
	}
	
	
	/**
	 * 
	 */
	private void evaluate() {
		DeterministicMaxWorkTimeLinks mxtol = new DeterministicMaxWorkTimeLinks();
		for(Route r : Solution.getRoutes()){
			double totalTime=0;
			vrpRep.structure.instance.Request requete = Instance.getRequest(r.getRequests().get(0).getId());
			if(requete.getAttribute("serviceTime")!=null){
				totalTime+=((DoubleValue)requete.getAttribute("serviceTime").get(0)).getValue();
			}
			
			for(int i=0;i<r.getRequests().size()-1;i++){
				totalTime+=mxtol.getTime(r, i);
				if(checkTimeWindow(totalTime, r.getRequests().get(i).getId()))
					cEval.addMessage("DeterministicRequestTimeWindowOnLinks|"+
							"Request : "+r.getRequests().get(i).getId()+
							"is visited at time : "+totalTime);
				
			}
		}
	}
	
	
	/**
	 * Checks if a request is visited during a valid time window
	 * @param arrivalTime arrival time at request
	 * @param requestId id of request
	 * @return true if visited at valid time, false otherwise
	 */
	public boolean checkTimeWindow(double arrivalTime, int requestId){
		List<VrpAtt> tws = Instance.getRequest(requestId).getAttribute("tw");
		double begin = -1, end = -1;
		int i = -1;
		TimeWindow tw;
		while(i++ < tws.size() && !(begin <= arrivalTime && arrivalTime <= end)){
			tw = (TimeWindow)tws.get(i);
			begin = tw.getBegin();
			end = tw.getEnd();
		}		
		return((i != tws.size())?true:false);
	}

}
