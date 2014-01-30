/**
 * 
 */
package vrpRep.solutionChecker.constraint;

import java.util.ArrayList;
import java.util.List;

import vrpRep.structure.instance.Instance;
import vrpRep.structure.instance.SkillAndTool;
import vrpRep.structure.instance.VrpAtt;
import vrpRep.structure.solution.Request;
import vrpRep.structure.solution.Route;
import vrpRep.structure.solution.Solution;
import vrpRep.utilities.ConstraintResult;

/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class VehicleSkill implements IConstraint {

	private boolean				cValid	= true;
	private ArrayList<String>	details	= new ArrayList<String>();
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * vrpRep.solutionChecker.constraint.IConstraint#evaluate(vrpRep.structure
	 * .instance.Instance, vrpRep.structure.solution.Solution)
	 */
	@Override
	public ConstraintResult evaluate() {

		checkVehicleSkill();

		if(cValid)
			return new ConstraintResult(cValid , "VehicleSkill");
		else{
			String sResult =details.get(0);
			for(int i=1;i<details.size();i++)
				sResult=sResult.concat("\n" + details.get(i));
			return new ConstraintResult(cValid, sResult,"VehicleSkill");
		}
	}

	/**
	 * 
	 * @return
	 * @throws MissingAttributeException
	 */
	private void checkVehicleSkill() {
		List<Integer> list = new ArrayList<Integer>();
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
			for (Request n : r.getRequests()) {
				int id = n.getId();
				List<VrpAtt> listAtt = Instance.getRequests().get(id)
						.getAttribute("skill");
				for (VrpAtt vrpAtt : listAtt) {
					requestSkill.add(((SkillAndTool) vrpAtt).getId());
				}
			}

			for (Integer s : requestSkill){

				if (!vehicleSkill.contains(s) && !list.contains(s)){
					list.add(s);
					cValid=false;
					b=true;
				}
			}
			if(b){
				String sSkillMissing =String.valueOf(list.get(0));
				for(int i=1;i<list.size();i++)
					sSkillMissing=sSkillMissing.concat("-"+list.get(i));
				details.add("The following skills are missing : "+sSkillMissing+" on route "+r.getId());
			}
		}
	}

	/**
	 * 
	 * @param list
	 * @return
	 */
	private List<Integer> getSkillVehicle(List<VrpAtt> list) {
		List<Integer> sat = new ArrayList<Integer>();
		for (VrpAtt vrpAtt : list) {
			sat.add(((SkillAndTool) vrpAtt).getId());
		}

		return sat;
	}
}
