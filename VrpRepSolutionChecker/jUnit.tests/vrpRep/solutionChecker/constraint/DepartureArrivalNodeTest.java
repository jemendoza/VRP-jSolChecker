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

public class DepartureArrivalNodeTest {

	@Before
	public void setUp() throws Exception {
		IInstanceReader instR = new InstanceTranslator(new File(
				"./xmlTest/InstancetestDepartureArrivalNode.xml"));
		ISolutionReader solR = new SolutionTranslator(new File(
				"./xmlTest/SolutiontestDepartureArrivalNode.xml"));

	}

	@Test
	public void test() {
		IConstraint contrainte = new DepartureArrivalNode();
		ConstraintResult c = contrainte.evaluate();;
		assertFalse(c.isValid());
	}

}
