
package vrpRep.solutionChecker.constraint;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import vrpRep.factory.ConstraintHandler;
import vrpRep.fileReaders.InstanceTranslator;
import vrpRep.fileReaders.SolutionTranslator;
import vrpRep.utilities.ConstraintResult;

/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class SuccessorsTest {
	/**
	 * 
	 */
	private ConstraintResult	cr;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		new InstanceTranslator(new File(
				"./xmlTest/NodeTypeCompatibilityInstance.xml"));
		new SolutionTranslator(new File(
				"./xmlTest/NodeTypeCompatibilitySolution.xml"));
	}

	@Test
	public void test() {
		ConstraintHandler ch = new ConstraintHandler();	
		ch.addConstraint(new Successors());	
		ch.evaluateConstraints("./solutionTestOutput/Successors", false);
		assertTrue(ch.getConstraintResult().isValid());
	}

}