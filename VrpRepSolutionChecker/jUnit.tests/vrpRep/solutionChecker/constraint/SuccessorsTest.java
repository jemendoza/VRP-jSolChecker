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
public class SuccessorsTest {
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		new InstanceTranslator(new File("./xmlTest/SuccessorsInstance.xml"));
		new SolutionTranslator(new File("./xmlTest/SuccessorsSolution.xml"));
	
	}

	@Test
	public void test() {
		ConstraintHandler ch = new ConstraintHandler();	
		ch.addConstraint(new Successors());	
		ch.evaluateConstraints("./solutionTestOutput/Successors", false);
		assertTrue(ch.getConstraintResult().isValid());
	}

}