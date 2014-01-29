package vrpRep.solutionChecker.constraint;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import vrpRep.fileReaders.InstanceTranslator;
import vrpRep.fileReaders.SolutionTranslator;
import vrpRep.utilities.ConstraintResult;

/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class PredecessorsTest {
	/**
	 * 
	 */
	private ConstraintResult	cr;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		new InstanceTranslator(new File("./xmlTest/testXmlFile.xml"));
		new SolutionTranslator(new File("./xmlTest/sampleSolution.xml"));

		Predecessors pred = new Predecessors();
		cr = pred.evaluate();
	}

	@Test
	public void test() {
		assertTrue(cr.isValid());
	}

}