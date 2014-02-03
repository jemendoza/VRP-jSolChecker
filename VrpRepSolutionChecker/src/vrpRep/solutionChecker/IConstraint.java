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
public interface IConstraint {

	/**
	 * Evaluates a constraint of a solution
	 * @return Result of constraint evaluation in {@link vrpRep.solutionChecker.ConstraintEvaluation}
	 */
	public ConstraintEvaluation checkConstraint();

}
