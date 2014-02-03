/**
 * 
 */
package vrpRep.solutionChecker.constraint;

import java.util.ArrayList;
import java.util.List;

import vrpRep.solutionChecker.ConstraintEvaluation;
import vrpRep.solutionChecker.IConstraint;
import vrpRep.structure.instance.Instance;
import vrpRep.structure.instance.SkillAndTool;
import vrpRep.structure.instance.VrpAtt;
import vrpRep.structure.solution.Request;
import vrpRep.structure.solution.Route;
import vrpRep.structure.solution.Solution;

/**
 * Class checking that the vehicle satisfying a request has the skills required to complete the request.
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class VehicleSkill implements IConstraint {

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

		checkVehicleSkill();

		return cEval;
	}


	/**
	 * Evaluate constraint
	 */
	private void checkVehicleSkill() {
		List<Integer> list = new ArrayList<Integer>();
		//each route
		for (Route r : Solution.getRoutes()) {
			list.clear();
			int vehicle = 0;
			boolean b=false;
			if (r.isHasType()) {
				vehicle = r.getType();
			}
			List<Integer> vehicleSkill = getSkillVehicle(Instance
					.getFleet().get(vehicle).getAttribute("skill"));
			List<Integer> requestSkill = new ArrayList<Integer>();
			//each request
			for (Request n : r.getRequests()) {
				int id = n.getId();
				List<VrpAtt> listAtt = Instance.getRequests().get(id)
						.getAttribute("skill");
				for (VrpAtt vrpAtt : listAtt) {
					requestSkill.add(((SkillAndTool) vrpAtt).getId());
				}
			}
			//each skill
			for (Integer s : requestSkill){

				if (!vehicleSkill.contains(s) && !list.contains(s)){
					list.add(s);
					b=true;
				}
			}
			if(b){
				String sSkillMissing =String.valueOf(list.get(0));
				for(int i=1;i<list.size();i++)
					sSkillMissing=sSkillMissing.concat("-"+list.get(i));
				cEval.addMessage("VehicleSkill|The following skills are missing : "+sSkillMissing+" on route "+r.getId());
			}
		}
	}

	/**
	 * 
	 * @param list list of skills the vehicle has
	 * @return list of skill vehicle has cast as integers
	 */
	private List<Integer> getSkillVehicle(List<VrpAtt> list) {
		List<Integer> sat = new ArrayList<Integer>();
		for (VrpAtt vrpAtt : list) {
			sat.add(((SkillAndTool) vrpAtt).getId());
		}

		return sat;
	}
}
