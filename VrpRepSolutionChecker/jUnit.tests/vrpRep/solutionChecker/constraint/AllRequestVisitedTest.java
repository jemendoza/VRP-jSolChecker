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

import vrpRep.solutionChecker.DynamicFactory;
import vrpRep.solutionChecker.VrpRepSolutionChecker;

public class AllRequestVisitedTest {

	private VrpRepSolutionChecker solC;
	private Element root;
	private Element experiment;

	private String instanceFile = "./xmlTest/AllRequestVisited/Instance.xml";
	private String solutionFile = "./xmlTest/AllRequestVisited/Solution.xml";
	private String outputFile = "./solutionTestOutput/AllRequestVisited.xml";

	@Before
	public void setUp() throws Exception {
		// set up test
		solC = new VrpRepSolutionChecker(instanceFile, solutionFile);
		
		// start building xml output
		root=new Element("test");
		root.setAttribute("instance_file", instanceFile);
		experiment=new Element("evaluation");
		experiment.setAttribute("solution_file",solutionFile);
		
		DynamicFactory factory = new DynamicFactory("./config/config.xml");
		factory.loadObjective(solC);
		factory.setDistanceCalculator();
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
		solC.addConstraint(new AllRequestVisited());
		// run experiment
		experiment.addContent(solC.checkSolution());
			
		assertTrue(solC.isFeasible());
	}

}
