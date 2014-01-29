package vrpRep.solutionChecker.constraint;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import vrpRep.factory.ConstraintHandler;
import vrpRep.fileReaders.IInstanceReader;
import vrpRep.fileReaders.ISolutionReader;
import vrpRep.fileReaders.InstanceTranslator;
import vrpRep.fileReaders.SolutionTranslator;

public class NodeTypeCompatibilityTest {


	@Before
	public void setUp() throws Exception {
		IInstanceReader instR = new InstanceTranslator(new File(
				"./xmlTest/NodeTypeCompatibilityInstance.xml"));
		ISolutionReader solR = new SolutionTranslator(new File(
				"./xmlTest/NodeTypeCompatibilitySolution.xml"));
	}
	
	@Test
	public void test() {
		ConstraintHandler ch = new ConstraintHandler();	
		ch.addConstraint(new NodeTypeCompatibility());	
		ch.evaluateConstraints("./solutionTestOutput/NodeTypeCompatibility", false);
		assertTrue(ch.getConstraintResult().isValid());
	}

}
