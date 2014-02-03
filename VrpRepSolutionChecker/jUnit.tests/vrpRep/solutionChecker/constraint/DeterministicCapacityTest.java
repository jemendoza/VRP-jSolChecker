/**
 * 
 */
package vrpRep.solutionChecker.constraint;

import static org.junit.Assert.assertTrue;

import java.io.FileOutputStream;
import java.io.IOException;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import vrpRep.solChecker.VrpRepSolutionChecker;

/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 *
 */
public class DeterministicCapacityTest {

	private VrpRepSolutionChecker solC;
	private Element root;
	private Element experiment;

	private String instanceFile = "./xmlTest/DeterministicCapacityInstance.xml";
	private String solutionFile = "./xmlTest/DeterministicCapacitySolution.xml";
	private String outputFile = "./solutionTestOutput/DeterministicCapacity.xml";


	@Before
	public void setUp() throws Exception {	
		// set up test
		solC = new VrpRepSolutionChecker(instanceFile, solutionFile);

		// start building xml output
		root=new Element("test");		
		experiment=new Element("evaluation");
		experiment.setAttribute("solution_file",solutionFile);


	}


	@After
	public void tearDown() throws Exception {
		// close experiment
		root.addContent(experiment);

		//Output to XML
		XMLOutputter outp = new XMLOutputter();
		outp.setFormat(Format.getPrettyFormat());
		Document doc=new Document();
		doc.setRootElement(root);
		try {
			outp.output(doc, new FileOutputStream(outputFile));
		} catch (IOException e3) {
			e3.printStackTrace();
		}
	}


	@Test
	public void test() {
		// add constraint(s)
		solC.addConstraint(new DeterministicCapacity());
		// run experiment
		experiment.addContent(solC.checkSolution());

		assertTrue(solC.isFeasible());
	}

}
