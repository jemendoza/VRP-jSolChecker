/**
 * 
 */
package vrpRep.solutionChecker.constraint;

import vrpRep.solutionChecker.ConstraintEvaluation;
import vrpRep.solutionChecker.IConstraint;
import vrpRep.structure.instance.DoubleValue;
import vrpRep.structure.instance.Instance;
import vrpRep.structure.instance.Link;
import vrpRep.structure.solution.Route;
import vrpRep.structure.solution.Solution;

/**
 * Evaluates deterministic vehicle Max Work Time constraint when 
 * time is defined within the link attributes. 
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 *
 */
public class DeterministicMaxWorkTimeLinks implements IConstraint {
	/**
	 * Evaluation result
	 */
	private ConstraintEvaluation cEval;
	/* (non-Javadoc)
	 * @see vrpRep.solutionChecker.constraint.IConstraint#evaluate()
	 */
	@Override
	public ConstraintEvaluation checkConstraint() {
		cEval = new ConstraintEvaluation();
		checkWorkTimeOnLinks();

		return cEval;
	}

	/**
	 * 
	 */
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
				cEval.addMessage("DeterministicMaxWorkTimeLinks|On Route "+r.getId()+" time worked is "+totalTime+" greater than "+maxWorkTime);
			}
		}
	}

}