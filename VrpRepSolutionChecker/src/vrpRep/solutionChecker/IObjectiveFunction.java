/**
 * 
 */
package vrpRep.solutionChecker;

/**
 * Interface used to help implementation of constraint evaluators
 * 
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public interface IObjectiveFunction {
	
	/**
	 * Evaluates the objective function of a solution
	 * @return Result of solution 
	 */
	public double evaluate();
}
