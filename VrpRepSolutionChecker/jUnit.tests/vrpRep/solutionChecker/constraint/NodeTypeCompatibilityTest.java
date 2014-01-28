package vrpRep.solutionChecker.constraint;

import static org.junit.Assert.fail;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import vrpRep.fileReaders.InstanceTranslator;

public class NodeTypeCompatibilityTest {

	private InstanceTranslator	d;

	private Solution			sol;

	@Before
	public void setUp() throws Exception {
		d = new InstanceTranslator(new File(
				"./schemaFiles/instancesNodeTypeCompatibility.zip"));
		this.sol = new DefaultSolution(new File(
				"./schemaFiles/testSolutionNbVehicle.xml"));
		NodeTypeCompatibility nb = new NodeTypeCompatibility();
		nb.evaluate(d, sol);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
