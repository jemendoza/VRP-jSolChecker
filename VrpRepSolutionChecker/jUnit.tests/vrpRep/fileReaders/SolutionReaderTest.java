package vrpRep.fileReaders;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import vrpRep.structure.solution.Demand;
import vrpRep.structure.solution.Request;
import vrpRep.structure.solution.Route;

/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class SolutionReaderTest {

	private SolutionTranslator	instS;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.instS = new SolutionTranslator(new File(
				"./schemaFiles/sampleSolution.xml"));
	}

	@Test
	public void testSolution() {
		assertEquals(instS.getSolution().getOf(), 3.14, 0);

		ArrayList<Route> routes = instS.getSolution().getRoutes();
		for (Route r : routes) {
			if (r.getId() == 0) {
				assertEquals(r.getType(), 0);
				ArrayList<Request> requests = r.getRequests();
				for (Request re : requests) {
					if (re.getId() == 0) {
						ArrayList<Demand> demands = re.getDemand();
						for (Demand d : demands) {
							if (d.getId() == 0) {
								assertEquals(d.getDemand(), 10, 0);
							}
							if (d.getId() == 1) {
								assertEquals(d.getDemand(), 11, 0);
							}
						}
					}
					if (re.getId() == 1) {
						ArrayList<Demand> demands = re.getDemand();
						for (Demand d : demands) {
							if (d.getId() == 0) {
								assertEquals(d.getDemand(), 10, 0);
							}
							if (d.getId() == 1) {
								assertEquals(d.getDemand(), 11, 0);
							}
						}
					}
				}

			}
			if (r.getId() == 1) {
				assertEquals(r.getType(), 0);
				ArrayList<Request> requests = r.getRequests();
				for (Request re : requests) {
					if (re.getId() == 2) {
						ArrayList<Demand> demands = re.getDemand();
						for (Demand d : demands) {
							if (d.getId() == 0) {
								assertEquals(d.getDemand(), 10, 0);
							}
							if (d.getId() == 1) {
								assertEquals(d.getDemand(), 11, 0);
							}
						}
					}
					if (re.getId() == 3) {
						ArrayList<Demand> demands = re.getDemand();
						for (Demand d : demands) {
							if (d.getId() == 0) {
								assertEquals(d.getDemand(), 10, 0);
							}
							if (d.getId() == 1) {
								assertEquals(d.getDemand(), 11, 0);
							}
						}
					}
				}
			}
		}
	}

}
