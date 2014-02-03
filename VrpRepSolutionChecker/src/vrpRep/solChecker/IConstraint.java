/**
 * 
 */
package vrpRep.solChecker;



/**
 * Interface used to help implementation of constraint evaluators
 * 
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public interface IConstraint {

	/**
	 * Evaluates a constraint of solution
	 * @return Result of constraint
	 */
	public ConstraintEvaluation checkConstraint();

}