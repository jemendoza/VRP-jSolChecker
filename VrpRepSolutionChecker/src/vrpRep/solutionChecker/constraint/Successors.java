/**
 * 
 */
package vrpRep.solutionChecker.constraint;

import java.util.ArrayList;
import java.util.List;

import vrpRep.solChecker.ConstraintEvaluation;
import vrpRep.solChecker.IConstraint;
import vrpRep.structure.instance.Instance;
import vrpRep.structure.instance.IntValue;
import vrpRep.structure.instance.VrpAtt;
import vrpRep.structure.solution.Request;
import vrpRep.structure.solution.Route;
import vrpRep.structure.solution.Solution;

/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class Successors implements IConstraint {

	private ConstraintEvaluation cEval;
	/*
	 * (non-Javadoc)
	 * 
	 * @see vrpRep.solutionChecker.constraint.IConstraint#evaluate()
	 */
	@Override
	public ConstraintEvaluation checkConstraint() {
		cEval = new ConstraintEvaluation();

		checkSuccessors();

		return cEval;
	}

	/**
	 * 
	 */
	private void checkSuccessors() {
		List<Integer> listRequestByRoute = new ArrayList<Integer>();
		
		for(Route r : Solution.getRoutes()) {
			listRequestByRoute.clear();
			for(Request re : r.getRequests()) {
				listRequestByRoute.add(re.getId());
			}
			for(Request re : r.getRequests()) {
				vrpRep.structure.instance.Request request = Instance
						.getRequest(re.getId());
				List<VrpAtt> list = request.getAttribute("successor");
				
				listRequestByRoute.remove((Object)re.getId());
				
				if(list!=null)
					for(VrpAtt att : list)
						if(!listRequestByRoute.contains(((IntValue)att).getValue())) {
							cEval.addMessage("Successors|The request "+re.getId()+" must be succeeded by the request : "+((IntValue)att).getValue()+" on route "+r.getId());
						}
			}
		}

	}

}