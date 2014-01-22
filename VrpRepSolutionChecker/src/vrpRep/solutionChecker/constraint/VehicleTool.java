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
public class VehicleTool implements IConstraint {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * vrpRep.solutionChecker.constraint.IConstraint#evaluate(vrpRep.structure
	 * .instance.Instance, vrpRep.structure.solution.Solution)
	 */
	@Override
	public void evaluate() {
		try {
			boolean b = checkVehicletool();
			System.out.println(b);
		} catch (MissingAttributeException e) {
			e.printStackTrace();
		}
	}

	private boolean checkVehicletool() throws MissingAttributeException {

		for (Route r : Solution.getRoutes()) {
			int vehicle = 0;
			if (r.isHasType()) {
				vehicle = r.getType();
			}
			List<SkillAndTool> vehicletool = getToolVehicle(Instance.getFleet()
					.get(vehicle).getAttribute("tool"));
			List<SkillAndTool> requesttool = new ArrayList<SkillAndTool>();
			for (Request n : r.getRequests()) {
				int id = n.getId();
				List<VrpAtt> list = Instance.getRequests().get(id)
						.getAttribute("tool");
				for (VrpAtt vrpAtt : list) {
					requesttool.add((SkillAndTool) vrpAtt);
				}
			}
			for (SkillAndTool s : requesttool)
				if (!vehicletool.contains(s))
					return false;
		}
		return true;
	}

	private List<SkillAndTool> getToolVehicle(List<VrpAtt> list) {
		List<SkillAndTool> sat = new ArrayList<SkillAndTool>();
		for (VrpAtt vrpAtt : list) {
			sat.add((SkillAndTool) vrpAtt);
		}

		return sat;
	}
}
