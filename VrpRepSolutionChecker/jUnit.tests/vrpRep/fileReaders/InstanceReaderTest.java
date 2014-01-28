/**
 * 
 */
package vrpRep.fileReaders;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import vrpRep.exceptions.MissingAttributeException;
import vrpRep.structure.instance.BooleanValue;
import vrpRep.structure.instance.Compartment;
import vrpRep.structure.instance.DemandProbaDist;
import vrpRep.structure.instance.DoubleValue;
import vrpRep.structure.instance.Euclidian;
import vrpRep.structure.instance.Instance;
import vrpRep.structure.instance.IntValue;
import vrpRep.structure.instance.Link;
import vrpRep.structure.instance.LinkProbaDist;
import vrpRep.structure.instance.Network;
import vrpRep.structure.instance.Node;
import vrpRep.structure.instance.Request;
import vrpRep.structure.instance.RequestProbaDist;
import vrpRep.structure.instance.SkillAndTool;
import vrpRep.structure.instance.TimeWindow;
import vrpRep.structure.instance.Vehicle;

/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class InstanceReaderTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {

		IInstanceReader instR = new InstanceTranslator(new File(
				"./schemaFiles/testXMLFile.xml"));

	}

	@Test
	public void testNetworkNode() {
		List<Node> nodes = Instance.getNodes();
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
		List<Link> links = Instance.getLinks();
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
									.getMoments().get(0).getValue(), 1.1, 0);
					assertEquals(
							((LinkProbaDist) l.getAttribute(
									"probabilityDistribution").get(0))
									.getMoments().get(1).getValue(), 2.1, 0);
					assertEquals(
							((LinkProbaDist) l.getAttribute(
									"probabilityDistribution").get(0))
									.getName(),
							"normal");
					assertEquals(
							((LinkProbaDist) l.getAttribute(
									"probabilityDistribution").get(0))
									.getMoments().get(0).getName(), "String1");
					assertEquals(
							((LinkProbaDist) l.getAttribute(
									"probabilityDistribution").get(0))
									.getMoments().get(1).getName(), "String2");

				}

				if (((IntValue) l.getAttribute("id").get(0)).getValue() == 1) {
					assertFalse(((BooleanValue) l.getAttribute("directed").get(
							0)).getValue());
					assertEquals(
							((IntValue) l.getAttribute("tail").get(0))
									.getValue(),
							0);
					assertEquals(
							((IntValue) l.getAttribute("head").get(0))
									.getValue(),
							1);
					assertEquals(
							((IntValue) l.getAttribute("type").get(0))
									.getValue(),
							1);
					assertEquals(
							((DoubleValue) l.getAttribute("cost").get(0))
									.getValue(),
							333, 0);
					assertEquals(
							((DoubleValue) l.getAttribute("length").get(0))
									.getValue(),
							444, 0);
					assertEquals(
							((LinkProbaDist) l.getAttribute(
									"probabilityDistribution").get(0))
									.getMoments().get(0).getValue(), 3.1, 0);
					assertEquals(
							((LinkProbaDist) l.getAttribute(
									"probabilityDistribution").get(0))
									.getMoments().get(1).getValue(), 3.2, 0);
					assertEquals(
							((LinkProbaDist) l.getAttribute(
									"probabilityDistribution").get(0))
									.getName(),
							"poisson");
					assertEquals(
							((LinkProbaDist) l.getAttribute(
									"probabilityDistribution").get(0))
									.getMoments().get(0).getName(), "String1");
					assertEquals(
							((LinkProbaDist) l.getAttribute(
									"probabilityDistribution").get(0))
									.getMoments().get(1).getName(), "String2");
				}
			} catch (MissingAttributeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Test
	public void testNetworkDescriptor() {
		Network n = Instance.getNetwork();
		assertFalse(n.isComplete());
		assertEquals(n.getDistanceType(), "euclidean");
		assertEquals(n.getRoundingRule(), "upperValue");
	}

	@Test
	public void testFleetVehicle() {
		for (Vehicle v : Instance.getFleet()) {
			try {
				if (((IntValue) v.getAttribute("type").get(0)).getValue() == 0) {
					assertEquals(((DoubleValue) v.getAttribute("fixedCost")
							.get(0)).getValue(), 3.1, 0);
					assertEquals(((DoubleValue) v.getAttribute("fixedCost")
							.get(1)).getValue(), 3.14, 0);
					assertEquals(((DoubleValue) v.getAttribute("variableCost")
							.get(0)).getValue(), 3.141, 0);
					assertEquals(((DoubleValue) v.getAttribute("variableCost")
							.get(1)).getValue(), 3.1415, 0);
					assertEquals(
							((IntValue) v.getAttribute("number").get(0))
									.getValue(),
							0);
					assertEquals(
							((IntValue) v.getAttribute("nodeTypesCompatible")
									.get(0)).getValue(), 0);
					assertEquals(
							((IntValue) v.getAttribute("nodeTypesCompatible")
									.get(1)).getValue(), 1);
					assertEquals(((DoubleValue) v.getAttribute("speedProfile")
							.get(0)).getValue(), 3.14159, 0);
					assertEquals(
							((DoubleValue) v.getAttribute("maxTravelDistance")
									.get(0)).getValue(), 34, 0);
					assertFalse(((BooleanValue) v.getAttribute(
							"maxTravelDistanceIsFlexible").get(0)).getValue());
					assertEquals(((DoubleValue) v.getAttribute("maxRequests")
							.get(0)).getValue(), 44, 0);
					assertFalse(((BooleanValue) v.getAttribute(
							"maxRequestsIsFlexible").get(0)).getValue());

					assertEquals(((DoubleValue) v
							.getAttribute("wLPMaxWorkTime").get(0)).getValue(),
							32, 0);
					assertFalse(((BooleanValue) v.getAttribute(
							"wLPMaxWorkTimeIsFlexible").get(0)).getValue());
					assertEquals(
							((TimeWindow) v.getAttribute("vLPtw").get(0))
									.getBegin(),
							22, 0);
					assertEquals(
							((TimeWindow) v.getAttribute("vLPtw").get(0))
									.getEnd(),
							23, 0);
					assertTrue(((TimeWindow) v.getAttribute("vLPtw").get(0))
							.isFlexStart());
					assertTrue(((TimeWindow) v.getAttribute("vLPtw").get(0))
							.isFlexEnd());
					assertEquals(
							((TimeWindow) v.getAttribute("vLPtw").get(0))
									.getPeriod(),
							0);

					assertEquals(
							((TimeWindow) v.getAttribute("vLPtw").get(1))
									.getBegin(),
							45, 0);
					assertEquals(
							((TimeWindow) v.getAttribute("vLPtw").get(1))
									.getEnd(),
							46, 0);
					assertTrue(((TimeWindow) v.getAttribute("vLPtw").get(1))
							.isFlexStart());
					assertTrue(((TimeWindow) v.getAttribute("vLPtw").get(1))
							.isFlexEnd());
					assertEquals(
							((TimeWindow) v.getAttribute("vLPtw").get(1))
									.getPeriod(),
							1);
					assertEquals(
							((DoubleValue) v.getAttribute("capacity").get(0))
									.getValue(),
							3.14, 0);
					assertEquals(
							((DoubleValue) v.getAttribute("capacity").get(1))
									.getValue(),
							3.141, 0);
					assertEquals(((Compartment) v.getAttribute("compartment")
							.get(0)).getType(), 0);
					assertEquals(((Compartment) v.getAttribute("compartment")
							.get(0)).getMin(), 3.1, 0);
					assertEquals(((Compartment) v.getAttribute("compartment")
							.get(0)).getMax(), 3.14, 0);
					assertEquals(((Compartment) v.getAttribute("compartment")
							.get(1)).getType(), 1);
					assertEquals(((Compartment) v.getAttribute("compartment")
							.get(1)).getMin(), 3.141, 0);
					assertEquals(((Compartment) v.getAttribute("compartment")
							.get(1)).getMax(), 3.141, 0);
					assertEquals(((IntValue) v.getAttribute("departureNode")
							.get(0)).getValue(), 0);
					assertEquals(
							((IntValue) v.getAttribute("arrivalNode").get(0))
									.getValue(),
							1);
					assertEquals(
							((SkillAndTool) v.getAttribute("skill").get(0))
									.getId(),
							0);
					assertEquals(
							((SkillAndTool) v.getAttribute("skill").get(0))
									.getValue(),
							1);
					assertEquals(
							((SkillAndTool) v.getAttribute("skill").get(1))
									.getId(),
							1);
					assertEquals(
							((SkillAndTool) v.getAttribute("skill").get(1))
									.getValue(),
							2);
					//
					assertEquals(
							((SkillAndTool) v.getAttribute("tool").get(0))
									.getId(),
							0);
					assertEquals(
							((SkillAndTool) v.getAttribute("tool").get(0))
									.getValue(),
							3);
					assertEquals(
							((SkillAndTool) v.getAttribute("tool").get(1))
									.getId(),
							1);
					assertEquals(
							((SkillAndTool) v.getAttribute("tool").get(1))
									.getValue(),
							4);
				}
				if (((IntValue) v.getAttribute("type").get(0)).getValue() == 1) {
					assertEquals(((DoubleValue) v.getAttribute("fixedCost")
							.get(0)).getValue(), 3.14, 0);
					assertEquals(((DoubleValue) v.getAttribute("fixedCost")
							.get(1)).getValue(), 3.141, 0);
					assertEquals(((DoubleValue) v.getAttribute("variableCost")
							.get(0)).getValue(), 3.1, 0);
					assertEquals(((DoubleValue) v.getAttribute("variableCost")
							.get(1)).getValue(), 3.14, 0);
					assertEquals(
							((IntValue) v.getAttribute("number").get(0))
									.getValue(),
							4);
					assertEquals(
							((IntValue) v.getAttribute("nodeTypesCompatible")
									.get(0)).getValue(), 1);
					assertEquals(
							((IntValue) v.getAttribute("nodeTypesCompatible")
									.get(1)).getValue(), 0);
					assertEquals(((DoubleValue) v.getAttribute("speedProfile")
							.get(0)).getValue(), 3.1415, 0);
					assertEquals(
							((DoubleValue) v.getAttribute("maxTravelDistance")
									.get(0)).getValue(), 34, 0);
					assertTrue(((BooleanValue) v.getAttribute(
							"maxTravelDistanceIsFlexible").get(0)).getValue());
					assertEquals(((DoubleValue) v.getAttribute("maxRequests")
							.get(0)).getValue(), 23, 0);
					assertFalse(((BooleanValue) v.getAttribute(
							"maxRequestsIsFlexible").get(0)).getValue());

					assertEquals(((DoubleValue) v
							.getAttribute("wLPMaxWorkTime").get(0)).getValue(),
							45, 0);
					assertTrue(((BooleanValue) v.getAttribute(
							"wLPMaxWorkTimeIsFlexible").get(0)).getValue());
					assertEquals(
							((TimeWindow) v.getAttribute("vLPtw").get(0))
									.getBegin(),
							45, 0);
					assertEquals(
							((TimeWindow) v.getAttribute("vLPtw").get(0))
									.getEnd(),
							46, 0);
					assertTrue(((TimeWindow) v.getAttribute("vLPtw").get(0))
							.isFlexStart());
					assertFalse(((TimeWindow) v.getAttribute("vLPtw").get(0))
							.isFlexEnd());
					assertEquals(
							((TimeWindow) v.getAttribute("vLPtw").get(0))
									.getPeriod(),
							0);

					assertEquals(
							((TimeWindow) v.getAttribute("vLPtw").get(1))
									.getBegin(),
							22, 0);
					assertEquals(
							((TimeWindow) v.getAttribute("vLPtw").get(1))
									.getEnd(),
							23, 0);
					assertTrue(((TimeWindow) v.getAttribute("vLPtw").get(1))
							.isFlexStart());
					assertFalse(((TimeWindow) v.getAttribute("vLPtw").get(1))
							.isFlexEnd());
					assertEquals(
							((TimeWindow) v.getAttribute("vLPtw").get(1))
									.getPeriod(),
							0);
					assertEquals(
							((DoubleValue) v.getAttribute("capacity").get(0))
									.getValue(),
							3.1, 0);
					assertEquals(
							((DoubleValue) v.getAttribute("capacity").get(1))
									.getValue(),
							3.14, 0);
					assertEquals(((Compartment) v.getAttribute("compartment")
							.get(0)).getType(), 0);
					assertEquals(((Compartment) v.getAttribute("compartment")
							.get(0)).getMin(), 3.1415, 0);
					assertEquals(((Compartment) v.getAttribute("compartment")
							.get(0)).getMax(), 3.14, 0);
					assertEquals(((Compartment) v.getAttribute("compartment")
							.get(1)).getType(), 1);
					assertEquals(((Compartment) v.getAttribute("compartment")
							.get(1)).getMin(), 3.141, 0);
					assertEquals(((Compartment) v.getAttribute("compartment")
							.get(1)).getMax(), 3.12, 0);
					assertEquals(((IntValue) v.getAttribute("departureNode")
							.get(0)).getValue(), 1);
					assertEquals(
							((IntValue) v.getAttribute("arrivalNode").get(0))
									.getValue(),
							0);
					assertEquals(
							((SkillAndTool) v.getAttribute("skill").get(0))
									.getId(),
							0);
					assertEquals(
							((SkillAndTool) v.getAttribute("skill").get(0))
									.getValue(),
							4);
					assertEquals(
							((SkillAndTool) v.getAttribute("skill").get(1))
									.getId(),
							1);
					assertEquals(
							((SkillAndTool) v.getAttribute("skill").get(1))
									.getValue(),
							3);
					//
					assertEquals(
							((SkillAndTool) v.getAttribute("tool").get(1))
									.getId(),
							0);
					assertEquals(
							((SkillAndTool) v.getAttribute("tool").get(1))
									.getValue(),
							1);
					assertEquals(
							((SkillAndTool) v.getAttribute("tool").get(0))
									.getId(),
							1);
					assertEquals(
							((SkillAndTool) v.getAttribute("tool").get(0))
									.getValue(),
							2);
				}
			} catch (MissingAttributeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Test
	public void testRequests() {
		for (Request r : Instance.getRequests()) {
			try {
				if (r.getId() == 0) {

					assertEquals(
							((IntValue) r.getAttribute("type").get(0))
									.getValue(),
							0);
					assertEquals(
							((IntValue) r.getAttribute("link").get(0))
									.getValue(),
							0);
					assertEquals(
							((IntValue) r.getAttribute("node").get(0))
									.getValue(),
							0);
					assertEquals(
							((TimeWindow) r.getAttribute("tw").get(0))
									.getBegin(),
							53, 0);
					assertEquals(
							((TimeWindow) r.getAttribute("tw").get(0)).getEnd(),
							54, 0);
					assertTrue(((TimeWindow) r.getAttribute("tw").get(0))
							.isHardStart());
					assertTrue(((TimeWindow) r.getAttribute("tw").get(0))
							.isHardEnd());
					assertEquals(
							((TimeWindow) r.getAttribute("tw").get(0))
									.getPeriod(),
							0);

					//
					assertEquals(
							((TimeWindow) r.getAttribute("tw").get(1))
									.getBegin(),
							56, 0);
					assertEquals(
							((TimeWindow) r.getAttribute("tw").get(1)).getEnd(),
							57, 0);
					assertTrue(((TimeWindow) r.getAttribute("tw").get(1))
							.isHardStart());
					assertTrue(((TimeWindow) r.getAttribute("tw").get(1))
							.isHardEnd());
					assertEquals(
							((TimeWindow) r.getAttribute("tw").get(1))
									.getPeriod(),
							1);

					assertFalse(((DemandProbaDist) r.getAttribute("demand")
							.get(0)).isSplittable());
					assertEquals(((DemandProbaDist) r.getAttribute("demand")
							.get(0)).getType(), 0);
					assertEquals(((DemandProbaDist) r.getAttribute("demand")
							.get(0)).getName(), "poisson");
					assertEquals(((DemandProbaDist) r.getAttribute("demand")
							.get(0)).getMoments().get(0).getValue(), 3.1415, 0);
					assertEquals(((DemandProbaDist) r.getAttribute("demand")
							.get(0)).getMoments().get(0).getName(), "String");
					assertEquals(((DemandProbaDist) r.getAttribute("demand")
							.get(0)).getMoments().get(1).getValue(), 3.1410, 0);
					assertEquals(((DemandProbaDist) r.getAttribute("demand")
							.get(0)).getMoments().get(1).getName(), "String");
					//
					assertFalse(((DemandProbaDist) r.getAttribute("demand")
							.get(1)).isSplittable());
					assertEquals(((DemandProbaDist) r.getAttribute("demand")
							.get(1)).getType(), 0);
					assertEquals(((DemandProbaDist) r.getAttribute("demand")
							.get(1)).getName(), "normal");
					assertEquals(((DemandProbaDist) r.getAttribute("demand")
							.get(1)).getMoments().get(0).getValue(), 3.1415, 0);
					assertEquals(((DemandProbaDist) r.getAttribute("demand")
							.get(1)).getMoments().get(0).getName(), "String");
					assertEquals(((DemandProbaDist) r.getAttribute("demand")
							.get(1)).getMoments().get(1).getValue(), 3.14, 0);
					assertEquals(((DemandProbaDist) r.getAttribute("demand")
							.get(1)).getMoments().get(1).getName(), "String");

					assertEquals(
							((DoubleValue) r.getAttribute("prize").get(0))
									.getValue(),
							0, 0);
					assertEquals(
							((DoubleValue) r.getAttribute("cost").get(0))
									.getValue(),
							3.141, 0);
					assertEquals(((DoubleValue) r.getAttribute("releaseDate")
							.get(0)).getValue(), 3.1, 0);

					assertEquals(
							((RequestProbaDist) r.getAttribute("serviceTime")
									.get(0)).getName(), "normal");
					assertEquals(
							((RequestProbaDist) r.getAttribute("serviceTime")
									.get(0)).getMoments().get(0).getValue(),
							3.141, 0);
					assertEquals(
							((RequestProbaDist) r.getAttribute("serviceTime")
									.get(0)).getMoments().get(0).getName(),
							"String");
					assertEquals(
							((RequestProbaDist) r.getAttribute("serviceTime")
									.get(0)).getMoments().get(1).getValue(),
							3.14, 0);
					assertEquals(
							((RequestProbaDist) r.getAttribute("serviceTime")
									.get(0)).getMoments().get(1).getName(),
							"String");
					assertEquals(
							((IntValue) r.getAttribute("predecessor").get(0))
									.getValue(),
							0);
					/*
					 * assertEquals( ((IntValue)
					 * r.getAttribute("predecessor").get(1)) .getValue(), 1);
					 */
					assertEquals(
							((IntValue) r.getAttribute("successor").get(0))
									.getValue(),
							1);
					/*
					 * assertEquals( ((IntValue)
					 * r.getAttribute("successor").get(1)) .getValue(), 0);
					 */

					assertEquals(
							((SkillAndTool) r.getAttribute("skill").get(0))
									.getId(),
							0);
					assertEquals(
							((SkillAndTool) r.getAttribute("skill").get(0))
									.getValue(),
							1);
					assertEquals(
							((SkillAndTool) r.getAttribute("skill").get(1))
									.getId(),
							1);
					assertEquals(
							((SkillAndTool) r.getAttribute("skill").get(1))
									.getValue(),
							2);
					//
					assertEquals(
							((SkillAndTool) r.getAttribute("tool").get(1))
									.getId(),
							1);
					assertEquals(
							((SkillAndTool) r.getAttribute("tool").get(1))
									.getValue(),
							4);
					assertEquals(
							((SkillAndTool) r.getAttribute("tool").get(0))
									.getId(),
							2);
					assertEquals(
							((SkillAndTool) r.getAttribute("tool").get(0))
									.getValue(),
							3);
				}
				if (r.getId() == 1) {

					assertEquals(
							((IntValue) r.getAttribute("type").get(0))
									.getValue(),
							0);
					assertEquals(
							((IntValue) r.getAttribute("link").get(0))
									.getValue(),
							0);
					assertEquals(
							((IntValue) r.getAttribute("node").get(0))
									.getValue(),
							0);
					assertEquals(
							((TimeWindow) r.getAttribute("tw").get(0))
									.getBegin(),
							34, 0);
					assertEquals(
							((TimeWindow) r.getAttribute("tw").get(0)).getEnd(),
							35, 0);
					assertTrue(((TimeWindow) r.getAttribute("tw").get(0))
							.isHardStart());
					assertTrue(((TimeWindow) r.getAttribute("tw").get(0))
							.isHardEnd());
					assertEquals(
							((TimeWindow) r.getAttribute("tw").get(0))
									.getPeriod(),
							0);

					//
					assertEquals(
							((TimeWindow) r.getAttribute("tw").get(1))
									.getBegin(),
							23, 0);
					assertEquals(
							((TimeWindow) r.getAttribute("tw").get(1)).getEnd(),
							12, 0);
					assertTrue(((TimeWindow) r.getAttribute("tw").get(1))
							.isHardStart());
					assertTrue(((TimeWindow) r.getAttribute("tw").get(1))
							.isHardEnd());
					assertEquals(
							((TimeWindow) r.getAttribute("tw").get(1))
									.getPeriod(),
							1);

					assertFalse(((DemandProbaDist) r.getAttribute("demand")
							.get(0)).isSplittable());
					assertEquals(((DemandProbaDist) r.getAttribute("demand")
							.get(0)).getType(), 0);
					assertEquals(((DemandProbaDist) r.getAttribute("demand")
							.get(0)).getName(), "poisson");
					assertEquals(((DemandProbaDist) r.getAttribute("demand")
							.get(0)).getMoments().get(0).getValue(), 3.1415, 0);
					assertEquals(((DemandProbaDist) r.getAttribute("demand")
							.get(0)).getMoments().get(0).getName(), "String");
					assertEquals(((DemandProbaDist) r.getAttribute("demand")
							.get(0)).getMoments().get(1).getValue(), 3.1415, 0);
					assertEquals(((DemandProbaDist) r.getAttribute("demand")
							.get(0)).getMoments().get(1).getName(), "String");
					//
					assertFalse(((DemandProbaDist) r.getAttribute("demand")
							.get(1)).isSplittable());
					assertEquals(((DemandProbaDist) r.getAttribute("demand")
							.get(1)).getType(), 0);
					assertEquals(((DemandProbaDist) r.getAttribute("demand")
							.get(1)).getName(), "normal");
					assertEquals(((DemandProbaDist) r.getAttribute("demand")
							.get(1)).getMoments().get(0).getValue(), 3.141, 0);
					assertEquals(((DemandProbaDist) r.getAttribute("demand")
							.get(1)).getMoments().get(0).getName(), "String");
					assertEquals(((DemandProbaDist) r.getAttribute("demand")
							.get(1)).getMoments().get(1).getValue(), 3.1, 0);
					assertEquals(((DemandProbaDist) r.getAttribute("demand")
							.get(1)).getMoments().get(1).getName(), "String");

					assertEquals(
							((DoubleValue) r.getAttribute("prize").get(0))
									.getValue(),
							0, 0);
					assertEquals(
							((DoubleValue) r.getAttribute("cost").get(0))
									.getValue(),
							3.141592, 0);
					assertEquals(((DoubleValue) r.getAttribute("releaseDate")
							.get(0)).getValue(), 3.141, 0);

					assertEquals(
							((RequestProbaDist) r.getAttribute("serviceTime")
									.get(0)).getName(), "poisson");
					assertEquals(
							((RequestProbaDist) r.getAttribute("serviceTime")
									.get(0)).getMoments().get(0).getValue(),
							3.1415, 0);
					assertEquals(
							((RequestProbaDist) r.getAttribute("serviceTime")
									.get(0)).getMoments().get(0).getName(),
							"String");
					assertEquals(
							((RequestProbaDist) r.getAttribute("serviceTime")
									.get(0)).getMoments().get(1).getValue(),
							3.14, 0);
					assertEquals(
							((RequestProbaDist) r.getAttribute("serviceTime")
									.get(0)).getMoments().get(1).getName(),
							"String");
					assertEquals(
							((IntValue) r.getAttribute("predecessor").get(0))
									.getValue(),
							0);
					/*
					 * assertEquals( ((IntValue)
					 * r.getAttribute("predecessor").get(1)) .getValue(), 1);
					 */
					assertEquals(
							((IntValue) r.getAttribute("successor").get(0))
									.getValue(),
							1);
					/*
					 * assertEquals( ((IntValue)
					 * r.getAttribute("successor").get(1)) .getValue(), 1);
					 */

					assertEquals(
							((SkillAndTool) r.getAttribute("skill").get(0))
									.getId(),
							0);
					assertEquals(
							((SkillAndTool) r.getAttribute("skill").get(0))
									.getValue(),
							3);
					assertEquals(
							((SkillAndTool) r.getAttribute("skill").get(1))
									.getId(),
							1);
					assertEquals(
							((SkillAndTool) r.getAttribute("skill").get(1))
									.getValue(),
							4);
					//
					assertEquals(
							((SkillAndTool) r.getAttribute("tool").get(1))
									.getId(),
							3);
					assertEquals(
							((SkillAndTool) r.getAttribute("tool").get(1))
									.getValue(),
							2);
					assertEquals(
							((SkillAndTool) r.getAttribute("tool").get(0))
									.getId(),
							4);
					assertEquals(
							((SkillAndTool) r.getAttribute("tool").get(0))
									.getValue(),
							1);
				}
			} catch (MissingAttributeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
