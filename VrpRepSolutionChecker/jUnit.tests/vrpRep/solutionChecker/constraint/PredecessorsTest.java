package vrpRep.solutionChecker.constraint;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import vrpRep.fileReaders.InstanceTranslator;
import vrpRep.fileReaders.SolutionTranslator;

/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class PredecessorsTest {
	private InstanceTranslator	instance;
	private SolutionTranslator	solution;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.instance = new InstanceTranslator(new File(
				"./schemaFiles/testXmlFile.xml"));
		this.solution = new SolutionTranslator(new File(
				"./schemaFiles/sampleSolution.xml"));

		Predecessors pred = new Predecessors();
		pred.evaluate();
	}

	@Test
	public void test() {

	}

}