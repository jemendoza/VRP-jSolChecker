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
public class Predecessors implements IConstraint {

	private ConstraintEvaluation cEval;
	/*
	 * (non-Javadoc)
	 * 
	 * @see vrpRep.solutionChecker.constraint.IConstraint#evaluate()
	 */
	@Override
	public ConstraintEvaluation checkConstraint() {
		cEval = new ConstraintEvaluation();

		checkPredecessors();
		return cEval;

	}

	private void checkPredecessors() {
		List<Integer> listRequest = new ArrayList<Integer>();
		List<Integer> predecessors =new ArrayList<Integer>();
		boolean b=false;
		
		for (Route r : Solution.getRoutes()) {
			listRequest.clear();
			for (Request re : r.getRequests()) {
				listRequest.add(re.getId());

				vrpRep.structure.instance.Request request = Instance
						.getRequest(re.getId());
				List<VrpAtt> list = request.getAttribute("predecessor");
				predecessors.clear(); 
				b=false;
				
				if(list!=null){
					for (VrpAtt v : list){
						if (!listRequest.contains(((IntValue) v).getValue())){
							b=true;
							predecessors.add(((IntValue)v).getValue());
						}
					}
				}
				if(b){
					String sPredecessors= predecessors.get(0).toString();
					for(int i=1;i<predecessors.size();i++)
						sPredecessors=sPredecessors.concat("-" + predecessors.get(i));
					cEval.addMessage("Predecessors|The request "+re.getId()+" must be preceded by the following requests : "+sPredecessors+" on route "+r.getId());
				}
			}
		}
	}
}