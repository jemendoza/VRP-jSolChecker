package vrpRep.solutionChecker.constraint;

import static org.junit.Assert.assertFalse;

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
				"./schemaFiles/NodeTypeCompatibilityInstance.xml"));
		ISolutionReader solR = new SolutionTranslator(new File(
				"./schemaFiles/NodeTypeCompatibilitySolution.xml"));
	}
	
	@Test
	public void test() {
		IConstraint constraint = new NodeTypeCompatibility();
		ConstraintResult result =constraint.evaluate();
		assertFalse(result.isValid());
	}

}
