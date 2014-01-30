package vrpRep.solutionChecker.constraint;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import vrpRep.factory.ConstraintHandler;
import vrpRep.fileReaders.InstanceTranslator;
import vrpRep.fileReaders.SolutionTranslator;

public class DepartureArrivalNodeTest {

	@Before
	public void setUp() throws Exception {
		 new InstanceTranslator(new File(
				"./xmlTest/InstancetestDepartureArrivalNode.xml"));
		new SolutionTranslator(new File(
				"./xmlTest/SolutiontestDepartureArrivalNode.xml"));

	}

	@Test
	public void test() {
		ConstraintHandler ch = new ConstraintHandler();	
		ch.addConstraint(new DepartureArrivalNode());	
		ch.evaluateConstraints("./solutionTestOutput/DepartureArrivalNode", false);
		assertTrue(ch.getConstraintResult().isValid());
	}

}
