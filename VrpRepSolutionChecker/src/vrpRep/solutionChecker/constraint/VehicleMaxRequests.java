/**
 * 
 */
package vrpRep.solutionChecker.constraint;

import vrpRep.fileReaders.InstanceTranslator;
import vrpRep.fileReaders.SolutionTranslator;
import vrpRep.structure.instance.Instance;
import vrpRep.structure.instance.Request;
import vrpRep.structure.solution.Route;
import vrpRep.structure.solution.Solution;

/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class VehicleMaxRequests implements IConstraint {

	private Instance	instance;
	private Solution	solution;

	@Override
	public void evaluate(InstanceTranslator inst, SolutionTranslator sol) {
		this.instance = inst.getInstance();
		this.solution = sol.getSolution();
		boolean b = checkMaxRequests();
	}

	private boolean checkMaxRequests() {

		for (Route r : solution.getRoutes()) {
			for (Request n : r.getRequests()) {

			}
		}

		return false;
	}

}
