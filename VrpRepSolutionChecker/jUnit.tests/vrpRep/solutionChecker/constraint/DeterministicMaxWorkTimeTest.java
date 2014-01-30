/**
 * 
 */
package vrpRep.solutionChecker.constraint;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import vrpRep.factory.ConstraintHandler;
import vrpRep.fileReaders.InstanceTranslator;
import vrpRep.fileReaders.SolutionTranslator;

/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 *
 */
public class DeterministicMaxWorkTimeTest {

	
	@Before
	public void setUp() throws Exception {
		new InstanceTranslator(new File(
				"./xmlTest/DeterministicMaxWorkTimeLinksInstance.xml"));
		new SolutionTranslator(new File(
				"./xmlTest/DeterministicMaxWorkTimeLinksSolution.xml"));

	}

	@Test
	public void test() {
		ConstraintHandler ch = new ConstraintHandler();	
		ch.addConstraint(new DeterministicMaxWorkTime());	
		ch.evaluateConstraints("./solutionTestOutput/DeterministicMaxWorkTimeTest", false);
		
		assertTrue(ch.getConstraintResult().isValid());
	}

}
