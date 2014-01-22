/**
 * 
 */
package vrpRep.factory;

import java.io.File;
import java.util.ArrayList;

import vrpRep.solutionChecker.constraint.IConstraint;
import vrpRep.structure.instance.Instance;
import vrpRep.structure.solution.Solution;

/**
 * Stores add evaluates all the constraints.
 * 
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class ConstraintHandler {

	/**
	 * List of constraints
	 */
	private ArrayList<IConstraint>	constraints;

	/**
	 * Default constructor. Initializes constraints list
	 */
	public ConstraintHandler() {
		this.constraints = new ArrayList<IConstraint>();
	}

	/**
	 * Evaluates all constraints and stores the results in a xml file
	 * 
	 * @return XML file of constraint validity results
	 */
	public File evaluateConstraints() {
		for (IConstraint c : this.constraints) {
			c.evaluate(Instance.getInstance(), Solution.getSolution());
			// TODO add result to xml file
		}
		return null;
	}

	/**
	 * Adds a constraint to the list of constraints to be evaluated
	 * 
	 * @param constraint
	 *            constraint to add
	 */
	public void addConstraint(IConstraint constraint) {
		this.constraints.add(constraint);
	}
}
