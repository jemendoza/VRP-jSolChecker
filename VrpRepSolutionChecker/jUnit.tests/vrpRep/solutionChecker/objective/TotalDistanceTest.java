package vrpRep.solutionChecker.objective;

import static org.junit.Assert.assertEquals;

import java.io.FileOutputStream;
import java.io.IOException;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Text;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import vrpRep.solutionChecker.DynamicFactory;
import vrpRep.solutionChecker.VrpRepSolutionChecker;
import vrpRep.solutionChecker.constraint.MaxTravelDistanceWithType;

public class TotalDistanceTest {

	private VrpRepSolutionChecker solC;
	private Element root;
	private Element experiment;

	private String instanceFile = "./xmlTestObjective/TotalDistance/Instance.xml";
	private String solutionFile = "./xmlTestObjective/TotalDistance/Solution.xml";
	private String outputFile = "./solutionTestOutput/Objective/TotalDistance.xml";


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
	public void testTrue() {
		// add constraint(s)
		// run experiment
		solC.setObjectiveFunction(new TotalDistance());	
		solC.addConstraint(new MaxTravelDistanceWithType());
		Element e = solC.checkSolution();
		experiment.addContent(e);
		double of = Double.parseDouble(((Text)((Element)e.getContent().get(2)).getContent().get(0)).getValue());
		of = (double) Math.round(of*100)/100;
		assertEquals(of,33.88,0);
		
		
		
	}

}
