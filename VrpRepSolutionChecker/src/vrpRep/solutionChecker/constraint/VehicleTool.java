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
public class VehicleTool implements IConstraint {

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
		checkVehicletool();
		if(cValid)
			return new ConstraintResult(cValid , "VehicleTool");
		else{
			String sResult =details.get(0);
			for(int i=1;i<details.size();i++)
				sResult=sResult.concat("\n" + details.get(i));
			return new ConstraintResult(cValid, sResult,"VehicleTool");
		}

	}

	private void checkVehicletool() {
		List<SkillAndTool> list = new ArrayList<SkillAndTool>();
		for (Route r : Solution.getRoutes()) {
			list.clear();
			int vehicle = 0;
			boolean b=false;
			if (r.isHasType()) {
				vehicle = r.getType();
			}
			List<SkillAndTool> vehicleTool = getToolVehicle(Instance.getFleet()
					.get(vehicle).getAttribute("tool"));
			List<SkillAndTool> requestTool = new ArrayList<SkillAndTool>();
			for (Request n : r.getRequests()) {
				int id = n.getId();
				List<VrpAtt> listAtt = Instance.getRequests().get(id)
						.getAttribute("tool");
				for (VrpAtt vrpAtt : listAtt) {
					requestTool.add((SkillAndTool) vrpAtt);
				}
			}
			for (SkillAndTool s : requestTool){
				if (!vehicleTool.contains(s)){
					list.add(s);
					cValid=false;
					b=true;
				}
			}
			if(b){
				String sToolMissing =""+list.get(0).getValue();
				for(int i=1;i<list.size();i++)
					sToolMissing=sToolMissing.concat(list.get(i)+"-");
				details.add("The following tools are missing : "+sToolMissing);
			}
		}
	}

	private List<SkillAndTool> getToolVehicle(List<VrpAtt> list) {
		List<SkillAndTool> sat = new ArrayList<SkillAndTool>();
		for (VrpAtt vrpAtt : list) {
			sat.add((SkillAndTool) vrpAtt);
		}

		return sat;
	}
}
