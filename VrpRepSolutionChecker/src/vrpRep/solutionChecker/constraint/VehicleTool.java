/**
 * 
 */
package vrpRep.solutionChecker.constraint;

import java.util.ArrayList;
import java.util.List;

import vrpRep.solChecker.ConstraintEvaluation;
import vrpRep.solChecker.IConstraint;
import vrpRep.structure.instance.Instance;
import vrpRep.structure.instance.SkillAndTool;
import vrpRep.structure.instance.VrpAtt;
import vrpRep.structure.solution.Request;
import vrpRep.structure.solution.Route;
import vrpRep.structure.solution.Solution;

/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class VehicleTool implements IConstraint {

	private ConstraintEvaluation cEval;
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * vrpRep.solutionChecker.constraint.IConstraint#evaluate(vrpRep.structure
	 * .instance.Instance, vrpRep.structure.solution.Solution)
	 */
	@Override
	public ConstraintEvaluation checkConstraint() {
		cEval = new ConstraintEvaluation();
		checkVehicletool();
		return cEval;

	}

	private void checkVehicletool() {
		List<Integer> list = new ArrayList<Integer>();
		for (Route r : Solution.getRoutes()) {
			list.clear();
			int vehicle = 0;
			boolean b=false;
			if (r.isHasType()) {
				vehicle = r.getType();
			}
			List<Integer> vehicleTool = getToolVehicle(Instance.getFleet()
					.get(vehicle).getAttribute("tool"));
			List<Integer> requestTool = new ArrayList<Integer>();
			for (Request n : r.getRequests()) {
				int id = n.getId();
				List<VrpAtt> listAtt = Instance.getRequests().get(id)
						.getAttribute("tool");
				for (VrpAtt vrpAtt : listAtt) {
					requestTool.add(((SkillAndTool) vrpAtt).getId());
				}
			}
			for (Integer s : requestTool){
				if (!vehicleTool.contains(s) && !list.contains(s)){
					list.add(s);
					b=true;
				}
			}
			if(b){
				String sToolMissing =""+list.get(0);
				for(int i=1;i<list.size();i++)
					sToolMissing=sToolMissing.concat("-"+list.get(i));
				cEval.addMessage("VehicleTool|The following tools are missing : "+sToolMissing+" on route "+r.getId());
			}
		}
	}

	private List<Integer> getToolVehicle(List<VrpAtt> list) {
		List<Integer> sat = new ArrayList<Integer>();
		for (VrpAtt vrpAtt : list) {
			sat.add(((SkillAndTool) vrpAtt).getId());
		}

		return sat;
	}
}
