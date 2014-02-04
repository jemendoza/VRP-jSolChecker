/**
 * 
 */
package vrpRep.solutionChecker.objective;

import vrpRep.solutionChecker.IObjectiveFunction;
import vrpRep.structure.instance.DoubleValue;
import vrpRep.structure.instance.Instance;
import vrpRep.structure.instance.Link;
import vrpRep.structure.solution.Route;
import vrpRep.structure.solution.Solution;

/**
 * Calculates vehicle travel time when time stored on links and service times for requests are taken into account
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 *
 */
public class TotalTravelTimeOnLinks implements IObjectiveFunction{

	@Override
	public double evaluate() {		
		double totalTime=0;
		// each route
		for(Route r : Solution.getRoutes()){	
			vrpRep.structure.instance.Request requete = Instance.getRequest(r.getRequests().get(0).getId());
			if(requete.getAttribute("serviceTime") != null)
				totalTime+=((DoubleValue)requete.getAttribute("serviceTime").get(0)).getValue();
			for(int i=0;i<r.getRequests().size()-1;i++){
				int startNode =r.getRequests().get(i).getNodeId();
				int arrivalNode = r.getRequests().get(i+1).getNodeId();
				Link l = Instance.getLink(startNode, arrivalNode);
				//Si on a un temps sur les arcs.
				if(l.getAttribute("time")!=null){
					totalTime+=((DoubleValue)l.getAttribute("time").get(0)).getValue();
				}
				vrpRep.structure.instance.Request re = Instance.getRequest(r.getRequests().get(i+1).getId());
				if(re.getAttribute("serviceTime") != null)
					totalTime+=((DoubleValue)re.getAttribute("serviceTime").get(0)).getValue();
			}
		}
		return totalTime;
	}

}
