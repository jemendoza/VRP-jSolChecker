/**
 * 
 */
package vrpRep.solutionChecker.constraint;

import java.util.ArrayList;
import java.util.List;

import vrpRep.exceptions.MissingAttributeException;
import vrpRep.schema.instance.Skill;
import vrpRep.structure.instance.Instance;
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
		} catch (MissingAttributeException e) {
			e.printStackTrace();
		}
	}

	private boolean checkVehicleSkill() throws MissingAttributeException {

		for (Route r : solution.getRoutes()) {
			int vehicle = 0;
			if (r.isHasType()) {
				vehicle = r.getType();
			}
			List<Skill> vehicleSkill = getSkillVehicle(instance.getFleet()
					.get(vehicle).getAttribute("skill"));
			List<Skill> requestSkill = new ArrayList<Skill>();
			for (Request n : r.getRequests()) {
				int id = n.getId();
				List<VrpAtt> list = instance.getRequests().get(id)
						.getAttribute("skill");
				for (VrpAtt vrpAtt : list) {
					requestSkill.add((Skill) vrpAtt);
				}
			}
			for (Skill s : requestSkill)
				if (!vehicleSkill.contains(s))
					return false;
		}
		return true;
	}

	private List<Skill> getSkillVehicle(List<VrpAtt> list) {
		List<Skill> sat = new ArrayList<Skill>();
		for (VrpAtt vrpAtt : list) {
			sat.add((Skill) vrpAtt);
		}

		return sat;
	}
}
