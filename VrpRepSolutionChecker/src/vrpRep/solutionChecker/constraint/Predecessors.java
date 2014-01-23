package vrpRep.solutionChecker.constraint;

import java.util.ArrayList;
import java.util.List;

import vrpRep.exceptions.MissingAttributeException;
import vrpRep.exceptions.MissingElementException;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see vrpRep.solutionChecker.constraint.IConstraint#evaluate()
	 */
	@Override
	public ConstraintResult evaluate() {
		ConstraintResult cr = null;
		try {
			boolean b = checkPredecessors();
			System.out.println(b);
			if (b)
				cr = new ConstraintResult(b, "", "predecessors");
			else
				cr = new ConstraintResult(b, "", "predecessors");
			// TODO : écrire detail
		} catch (MissingAttributeException e) {
			e.printStackTrace();
		} catch (MissingElementException e) {
			e.printStackTrace();
		}
		return cr;

	}

	private boolean checkPredecessors() throws MissingAttributeException,
			MissingElementException {
		List<Integer> listRequest = new ArrayList<Integer>();
		for (Route r : Solution.getRoutes()) {
			listRequest.clear();
			for (Request re : r.getRequests()) {
				listRequest.add(re.getId());

				vrpRep.structure.instance.Request request = Instance
						.getRequest(re.getId());
				List<VrpAtt> list = request.getAttribute("predecessor");
				for (VrpAtt i : list)
					if (!listRequest.contains(((IntValue) i).getValue()))
						return false;

			}
		}
		return true;
	}
}