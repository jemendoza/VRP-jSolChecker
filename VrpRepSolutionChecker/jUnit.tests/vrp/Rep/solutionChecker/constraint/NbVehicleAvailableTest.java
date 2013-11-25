package vrp.Rep.solutionChecker.constraint;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import vrpRep.solutionChecker.constraint.NbVehicleAvailable;
import vrpRep.solutionChecker.instance.DefaultInstance;
import vrpRep.solutionChecker.solution.DefaultSolution;

public class NbVehicleAvailableTest {

	private DefaultInstance d;
	
	private DefaultSolution sol;
	@Before
	public void setUp() throws Exception {
		d = new DefaultInstance(new File("./schemaFiles/A-n32-k5.xml.zip"));
		this.sol = new DefaultSolution(new File("./schemaFiles/testSolutionNbVehicle.xml"));
		NbVehicleAvailable nb = new NbVehicleAvailable();
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
