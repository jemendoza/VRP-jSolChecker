package vrpRep.solutionChecker.constraint;

import java.util.ArrayList;
import java.util.List;

import vrpRep.structure.instance.Instance;
import vrpRep.structure.instance.IntValue;
import vrpRep.structure.instance.VrpAtt;
import vrpRep.structure.solution.Request;
import vrpRep.structure.solution.Route;
import vrpRep.structure.solution.Solution;
import vrpRep.utilities.ConstraintResult;

/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class Predecessors implements IConstraint {

	private boolean				cValid	= true;
	private ArrayList<String>	details	= new ArrayList<String>();
	/*
	 * (non-Javadoc)
	 * 
	 * @see vrpRep.solutionChecker.constraint.IConstraint#evaluate()
	 */
	@Override
	public ConstraintResult evaluate() {

		checkPredecessors();
		if(cValid)
			return new ConstraintResult(cValid , "Predecessors");
		else{
			String sResult =details.get(0);
			for(int i=1;i<details.size();i++)
				sResult=sResult.concat("\n" + details.get(i));
			return new ConstraintResult(cValid, sResult, "Predecessors");
		}

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
							cValid= false;
							b=true;
							predecessors.add(((IntValue)v).getValue());
						}
					}
				}
				if(b){
					String sPredecessors= predecessors.get(0).toString();
					for(int i=1;i<predecessors.size();i++)
						sPredecessors=sPredecessors.concat("-" + predecessors.get(i));
					details.add("The request "+re.getId()+" must be preceded by the following requests : "+sPredecessors+" on route "+r.getId());
				}
			}
		}
	}
}