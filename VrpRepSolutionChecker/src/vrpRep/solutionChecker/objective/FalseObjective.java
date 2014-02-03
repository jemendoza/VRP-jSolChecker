/**
 * 
 */
package vrpRep.solutionChecker.objective;

import vrpRep.solutionChecker.IObjectiveFunction;

/**
 * Utiliser pour les JunitTest quand pas besoin de fonction objectif
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 *
 */
public class FalseObjective implements IObjectiveFunction {

	/* (non-Javadoc)
	 * @see vrpRep.solutionChecker.IObjectiveFunction#evaluate()
	 */
	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return 0;
	}

}
