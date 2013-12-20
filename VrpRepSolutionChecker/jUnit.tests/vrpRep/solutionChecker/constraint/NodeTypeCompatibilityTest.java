package vrpRep.solutionChecker.constraint;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import vrpRep.fileReaders.InstanceReader;
import vrpRep.solutionChecker.solution.DefaultSolution;

public class NodeTypeCompatibilityTest {

private InstanceReader d;
	
	private DefaultSolution sol;
	@Before
	public void setUp() throws Exception {
		d = new InstanceReader(new File("./schemaFiles/instancesNodeTypeCompatibility.zip"));
		this.sol = new DefaultSolution(new File("./schemaFiles/testSolutionNbVehicle.xml"));
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
