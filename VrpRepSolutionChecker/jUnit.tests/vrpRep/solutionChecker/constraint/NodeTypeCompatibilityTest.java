package vrpRep.solutionChecker.constraint;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import vrpRep.fileReaders.IInstanceReader;
import vrpRep.fileReaders.ISolutionReader;
import vrpRep.fileReaders.InstanceTranslator;
import vrpRep.fileReaders.SolutionTranslator;
import vrpRep.utilities.ConstraintResult;

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
		IConstraint constraint = new NodeTypeCompatibility();
		ConstraintResult result =constraint.evaluate();
		assertTrue(result.isValid());
	}

}
