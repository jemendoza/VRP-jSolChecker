/**
 * 
 */
package vrpRep.solutionChecker.constraint;

import java.util.ArrayList;
import java.util.List;

import vrpRep.solutionChecker.ConstraintEvaluation;
import vrpRep.solutionChecker.IConstraint;
import vrpRep.structure.instance.Instance;
import vrpRep.structure.instance.Request;
import vrpRep.structure.solution.Route;
import vrpRep.structure.solution.Solution;


/**
 * Class checking that all request are satisfied.
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 *
 */
public class AllRequestVisited implements IConstraint {

	private ConstraintEvaluation cEval;
	/* (non-Javadoc)
	 * @see vrpRep.solChecker.IConstraint#checkConstraint()
	 */
	@Override
	public ConstraintEvaluation checkConstraint() {
		cEval = new ConstraintEvaluation();
		evaluateRequest();
		return cEval;
	}
	
	/**
	 * Evaluate the constraint
	 */
	private void evaluateRequest() {
		List<Request> instRequest = Instance.getRequests();
		List<Integer> solRequest = getSolRequest();
		//each request
		for(Request r  : instRequest){
			if(!solRequest.contains(r.getId())){
				cEval.addMessage("AllRequestVisited|The request : "+r.getId()+" isn't satisfied on the solution" );
			}
		}
	}
	/**
	 * 
	 * @return requests satisfied in the solution
	 */
	private List<Integer> getSolRequest() {
		List<Integer> reqId = new ArrayList<Integer>();
		//each route
		for(Route r : Solution.getRoutes()){
			//each request
			for(vrpRep.structure.solution.Request req : r.getRequests()){
				Request requete = Instance.getRequest(req.getId());
				if(!reqId.contains(requete.getId())){
					reqId.add(requete.getId());
				}
			}		
		}
		return reqId;
	}

}
