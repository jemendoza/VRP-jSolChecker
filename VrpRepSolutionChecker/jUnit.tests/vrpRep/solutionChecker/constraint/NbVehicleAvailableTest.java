package vrpRep.solutionChecker.constraint;

import static org.junit.Assert.assertFalse;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import vrpRep.factory.ConstraintHandler;
import vrpRep.fileReaders.InstanceTranslator;
import vrpRep.fileReaders.SolutionTranslator;

public class NbVehicleAvailableTest {

	
	@Before
	public void setUp() throws Exception {
		 new InstanceTranslator(new File(
				"./xmlTest/InstanceNbVehicleAvailable.xml"));
		 new SolutionTranslator(new File(
				"./xmlTest/SolutionNbVehicleAvailable.xml"));

	}

	@Test
	public void test() {
		ConstraintHandler ch = new ConstraintHandler();	
		ch.addConstraint(new NbVehicleAvailable());	
		ch.evaluateConstraints("./solutionTestOutput/NbVehicleAvailable", false);
		assertFalse(ch.getConstraintResult().isValid());
	}

}
