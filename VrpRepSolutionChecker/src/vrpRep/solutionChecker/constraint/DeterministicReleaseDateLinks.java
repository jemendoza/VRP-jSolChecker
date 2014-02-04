package vrpRep.solutionChecker.constraint;

import java.util.List;

import vrpRep.solutionChecker.ConstraintEvaluation;
import vrpRep.solutionChecker.IConstraint;
import vrpRep.structure.instance.DoubleValue;
import vrpRep.structure.instance.Instance;
import vrpRep.structure.instance.VrpAtt;
import vrpRep.structure.solution.Route;
import vrpRep.structure.solution.Solution;

/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 *
 */
public class DeterministicReleaseDateLinks implements IConstraint {
	/**
	 * Evaluation result
	 */
	private ConstraintEvaluation cEval;
	/* (non-Javadoc)
	 * @see vrpRep.solutionChecker.IConstraint#checkConstraint()
	 */
	@Override
	public ConstraintEvaluation checkConstraint() {
		cEval = new ConstraintEvaluation();
		checkReleaseDate();

		return cEval;
	}

	/**
	 * 
	 */
	private void checkReleaseDate() {
		// Gets this class for use it method getTime()
		DeterministicMaxWorkTimeLinks dmwtl = new DeterministicMaxWorkTimeLinks();
		
		for(Route r : Solution.getRoutes()) {
			double time=0;
			double serviceTime=0;
			for(int i=0;i<r.getRequests().size()-1;i++) {
				serviceTime += dmwtl.getServiceTime(r, i);
				time += dmwtl.getTime(r, i);
				
				vrpRep.structure.instance.Request request = Instance
						.getRequest(r.getRequests().get(i+1).getNodeId());
				List<VrpAtt> list = request.getAttribute("releaseDate");
				double releaseDate=0;
				if(list!=null)
					releaseDate = ((DoubleValue)list.get(0)).getValue();
				
				if(releaseDate > time+serviceTime) {
					cEval.addMessage("ReleaseDateLinks|On route "+r.getId()+" the request "+r.getRequests().get(i+1).getId()+" release date is "+releaseDate+" greater than "+(time+serviceTime));
				}
			}
		}
	}
	
}