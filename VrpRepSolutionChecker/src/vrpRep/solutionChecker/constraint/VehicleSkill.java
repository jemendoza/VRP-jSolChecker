/**
 * 
 */
package vrpRep.solutionChecker.constraint;

import java.util.ArrayList;
import java.util.List;

import vrpRep.exceptions.MissingAttributeException;
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
public class VehicleSkill implements IConstraint {

	private Instance	instance;
	private Solution	solution;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * vrpRep.solutionChecker.constraint.IConstraint#evaluate(vrpRep.structure
	 * .instance.Instance, vrpRep.structure.solution.Solution)
	 */
	@Override
	public void evaluate(Instance inst, Solution sol) {
		this.instance = inst;
		this.solution = sol;

		try {
			boolean b = checkVehicleSkill();
			System.out.println(b);
		} catch (MissingAttributeException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @return
	 * @throws MissingAttributeException
	 */
	private boolean checkVehicleSkill() throws MissingAttributeException {

		for (Route r : solution.getRoutes()) {
			int vehicle = 0;
			if (r.isHasType()) {
				vehicle = r.getType();
			}
			List<SkillAndTool> vehicleSkill = getSkillVehicle(instance
					.getFleet().get(vehicle).getAttribute("skill"));
			List<SkillAndTool> requestSkill = new ArrayList<SkillAndTool>();
			for (Request n : r.getRequests()) {
				int id = n.getId();
				List<VrpAtt> list = instance.getRequests().get(id)
						.getAttribute("skill");
				for (VrpAtt vrpAtt : list) {
					requestSkill.add((SkillAndTool) vrpAtt);
				}
			}
			for (SkillAndTool s : requestSkill)
				if (!vehicleSkill.contains(s))
					return false;
		}
		return true;
	}

	/**
	 * 
	 * @param list
	 * @return
	 */
	private List<SkillAndTool> getSkillVehicle(List<VrpAtt> list) {
		List<SkillAndTool> sat = new ArrayList<SkillAndTool>();
		for (VrpAtt vrpAtt : list) {
			sat.add((SkillAndTool) vrpAtt);
		}

		return sat;
	}
}
