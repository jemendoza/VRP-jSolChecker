/**
 * 
 */
package vrpRep.fileReaders;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.io.File;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import vrpRep.exceptions.MissingAttributeException;
import vrpRep.instance.v2.BooleanValue;
import vrpRep.instance.v2.DoubleValue;
import vrpRep.instance.v2.Euclidian;
import vrpRep.instance.v2.IntValue;
import vrpRep.instance.v2.Link;
import vrpRep.instance.v2.LinkProbaDist;
import vrpRep.instance.v2.Node;

/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class InstanceReaderTest {

	private InstanceReader	instR;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.instR = new InstanceReader(new File(
				"./schemaFiles/testXmlFile.xml"));
	}

	@Test
	public void testNetworkNode() {
		List<Node> nodes = instR.getInstance().getNodes();
		for (Node n : nodes) {
			Euclidian e;
			try {
				e = (Euclidian) n.getAttribute("location").get(0);

				if (n.getId() == 0) {

					assertEquals(e.getCx(), 1.1, 0);
					assertEquals(e.getCy(), 2.1, 0);
					assertEquals(e.getCz(), 3.1, 0);
					assertEquals(
							((IntValue) n.getAttribute("type").get(0))
									.getValue(),
							0);

				}
				if (n.getId() == 1) {

					assertEquals(e.getCx(), 1.2, 0);
					assertEquals(e.getCy(), 2.2, 0);
					assertEquals(e.getCz(), 3.2, 0);
					assertEquals(
							((IntValue) n.getAttribute("type").get(0))
									.getValue(),
							1);
				}
			} catch (MissingAttributeException e1) {
				e1.printStackTrace();
			}

		}
	}

	@Test
	public void testNetworkLinks() {
		List<Link> links = instR.getInstance().getLinks();
		for (Link l : links) {
			try {
				if (((IntValue) l.getAttribute("id").get(0)).getValue() == 0) {
					assertFalse(((BooleanValue) l.getAttribute("directed").get(
							0)).getValue());
					assertEquals(
							((IntValue) l.getAttribute("tail").get(0))
									.getValue(),
							1);
					assertEquals(
							((IntValue) l.getAttribute("head").get(0))
									.getValue(),
							0);
					assertEquals(
							((IntValue) l.getAttribute("type").get(0))
									.getValue(),
							0);
					assertEquals(
							((DoubleValue) l.getAttribute("cost").get(0))
									.getValue(),
							111, 0);
					assertEquals(
							((DoubleValue) l.getAttribute("length").get(0))
									.getValue(),
							222, 0);
					assertEquals(
							((LinkProbaDist) l.getAttribute(
									"probabilityDistribution").get(0))
									.getMoments().get(0), 1.1);
					assertEquals(
							((LinkProbaDist) l.getAttribute(
									"probabilityDistribution").get(0))
									.getMoments().get(1), 2.1);
					assertEquals(
							((LinkProbaDist) l.getAttribute(
									"probabilityDistribution").get(0))
									.getName(),
							"normal");
				}
			} catch (MissingAttributeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
