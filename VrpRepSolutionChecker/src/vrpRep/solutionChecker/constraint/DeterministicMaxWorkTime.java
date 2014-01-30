/**
 * 
 */
package vrpRep.solutionChecker.constraint;

import java.util.ArrayList;

import vrpRep.structure.instance.DoubleValue;
import vrpRep.structure.instance.Instance;
import vrpRep.structure.instance.Link;
import vrpRep.structure.solution.Route;
import vrpRep.structure.solution.Solution;
import vrpRep.utilities.ConstraintResult;

/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 *
 */
public class DeterministicMaxWorkTime implements IConstraint {

	/**
	 * true if constraint fully verified, false otherwise
	 */
	private boolean				cValid	= true;
	/**
	 * list of constraint failures
	 */
	private ArrayList<String>	details	= new ArrayList<String>();
	/* (non-Javadoc)
	 * @see vrpRep.solutionChecker.constraint.IConstraint#evaluate()
	 */
	@Override
	public ConstraintResult evaluate() {

		if(Instance.getLinks()!=null || Instance.getLinks().get(0).getAttribute("time")!=null)
			checkWorkTimeOnLinks();
		else
			checkWorkTimeOnNodes();

		if(cValid)
			return new ConstraintResult(cValid , "DeterministicMaxWorkTime");
		else{
			String sResult =details.get(0);
			for(int i=1;i<details.size();i++)
				sResult=sResult.concat("\n" + details.get(i));
			return new ConstraintResult(cValid, sResult,"DeterministicMaxWorkTime");
		}
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
				vrpRep.structure.instance.Request re = Instance.getRequest(r.getRequests().get(0).getId());
				if(re.getAttribute("serviceTime")!=null){
					totalTime+=((DoubleValue)re.getAttribute("serviceTime").get(0)).getValue();
				}

			}
			double maxWorkTime = ((DoubleValue)Instance.getFleet().get(r.getType()).getAttribute("wLPMaxWorkTime").get(0)).getValue();
			if(totalTime>maxWorkTime){
				cValid=false;
				details.add("On Route "+r.getId()+" time worked is "+totalTime+" greater than "+maxWorkTime);
			}
		}

	}

}
