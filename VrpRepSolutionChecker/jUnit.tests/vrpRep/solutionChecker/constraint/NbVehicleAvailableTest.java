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

public class NbVehicleAvailableTest {

	
	@Before
	public void setUp() throws Exception {
		IInstanceReader instR = new InstanceTranslator(new File(
				"./xmlTest/InstanceNbVehicleAvailable.xml"));
		ISolutionReader solR = new SolutionTranslator(new File(
				"./xmlTest/SolutionNbVehicleAvailable.xml"));

	}

	@Test
	public void test() {
		IConstraint constraint = new NbVehicleAvailable();
		ConstraintResult result =constraint.evaluate();
		assertFalse(result.isValid());
	}

}
