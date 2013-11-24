package vrpRep.utilities;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import vrpRep.exceptions.MissingCustomElementException;
import vrpRep.schema.instance.Custom;
import vrpRep.schema.instance.Instance;
import vrpRep.schema.instance.Instance.Network.Links;
import vrpRep.schema.instance.Instance.Network.Links.Link;
import vrpRep.schema.instance.Instance.Network.Nodes.Node;
import vrpRep.schema.instance.Location;
import vrpRep.schema.instance.Location.Euclidean;
import vrpRep.schema.instance.Location.GPSCoordinates;
import vrpRep.schema.instance.ObjectFactory;
import vrpRep.schema.instance.Time;


/**
 * Test class to test various distance calculations. <br />
 * Necessary tests : GetEuclideanDist(2D and 3D with Euclidean, Manhattan, Geodesic and UnknownDistanceType)<br />
 * GetGPSDist<br />
 * GetLink<br />
 * NodeLocation (Euclidean, GPS, Custom and NullPointer)<br />
 * Link (Length, Time, TimeNormal, TimePoisson, TimeCustom, LinkNullPointer)<br />
 * 
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 *
 */
public class DistanceCalculatorTest {

	private ObjectFactory oFac;

	private Instance inst;

	private List<Link> links;



	@Before
	public void setUp() throws Exception {
		this.oFac = ObjectFactory.class.newInstance();	
	}

	public void buildInstance(){
		buildLinks();
		this.inst = oFac.createInstance();
		this.inst.setNetwork(oFac.createInstanceNetwork());
		this.inst.getNetwork().setDescriptor(oFac.createInstanceNetworkDescriptor());
		this.inst.getNetwork().getDescriptor().setDistanceType("euclidean");
		Links l = oFac.createInstanceNetworkLinks();
		l.getLink().add(this.links.get(0));
		l.getLink().add(this.links.get(1));
		this.inst.getNetwork().setLinks(l);
	}

	public void buildLinks(){
		this.links = new ArrayList<Link>();
		Link link = oFac.createInstanceNetworkLinksLink();
		link.setId(BigInteger.valueOf(0));
		link.setHead(BigInteger.valueOf(0));
		link.setTail(BigInteger.valueOf(2));
		this.links.add(link);
		link = oFac.createInstanceNetworkLinksLink();
		link.setId(BigInteger.valueOf(1));
		link.setHead(BigInteger.valueOf(0));
		link.setTail(BigInteger.valueOf(1));
		this.links.add(link);
	}


	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void testEuclideanEuclidean2DDist() {
		try {
			Node head = oFac.createInstanceNetworkNodesNode();
			Node tail = oFac.createInstanceNetworkNodesNode();
			Euclidean euc = oFac.createLocationEuclidean();
			Location loc = oFac.createLocation();
			euc.setCx(1.0);
			euc.setCy(3.0);
			loc.setEuclidean(euc);
			head.setLocation(loc);

			euc = oFac.createLocationEuclidean();
			loc = oFac.createLocation();
			euc.setCx(4.0);
			euc.setCy(6.0);
			loc.setEuclidean(euc);
			tail = oFac.createInstanceNetworkNodesNode();
			tail.setLocation(loc);
			double result = DistanceCalculator.getEuclideanDist(head.getLocation().getEuclidean(), tail.getLocation().getEuclidean(), "euclidean");
			assertEquals(4.242640687, result, 0.1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Test
	public void testEuclideanEuclidean3DDist() {
		try {
			Node head = oFac.createInstanceNetworkNodesNode();
			Node tail = oFac.createInstanceNetworkNodesNode();
			Euclidean euc = oFac.createLocationEuclidean();
			Location loc = oFac.createLocation();
			euc.setCx(1.0);
			euc.setCy(3.0);
			euc.setCz(9.0);
			loc.setEuclidean(euc);
			head.setLocation(loc);

			euc = oFac.createLocationEuclidean();
			loc = oFac.createLocation();
			euc.setCx(4.0);
			euc.setCy(6.0);
			euc.setCz(3.0);
			loc.setEuclidean(euc);
			tail = oFac.createInstanceNetworkNodesNode();
			tail.setLocation(loc);
			double result = DistanceCalculator.getEuclideanDist(head.getLocation().getEuclidean(), tail.getLocation().getEuclidean(), "euclidean");
			assertEquals(7.348469228, result, 0.1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	@Test
	public void testEuclideanManhattan2DDist() {
		try {
			Node head = oFac.createInstanceNetworkNodesNode();
			Node tail = oFac.createInstanceNetworkNodesNode();
			Euclidean euc = oFac.createLocationEuclidean();
			Location loc = oFac.createLocation();
			euc.setCx(1.0);
			euc.setCy(3.0);
			loc.setEuclidean(euc);
			head.setLocation(loc);

			euc = oFac.createLocationEuclidean();
			loc = oFac.createLocation();
			euc.setCx(4.0);
			euc.setCy(6.0);
			loc.setEuclidean(euc);
			tail = oFac.createInstanceNetworkNodesNode();
			tail.setLocation(loc);
			double result = DistanceCalculator.getEuclideanDist(head.getLocation().getEuclidean(), tail.getLocation().getEuclidean(), "manhattan");
			assertEquals(6, result, 0.1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Test
	public void testEuclideanManhattan3DDist() {
		try {
			Node head = oFac.createInstanceNetworkNodesNode();
			Node tail = oFac.createInstanceNetworkNodesNode();
			Euclidean euc = oFac.createLocationEuclidean();
			Location loc = oFac.createLocation();
			euc.setCx(1.0);
			euc.setCy(3.0);
			euc.setCz(9.0);
			loc.setEuclidean(euc);
			head.setLocation(loc);

			euc = oFac.createLocationEuclidean();
			loc = oFac.createLocation();
			euc.setCx(4.0);
			euc.setCy(6.0);
			euc.setCz(3.0);
			loc.setEuclidean(euc);
			tail = oFac.createInstanceNetworkNodesNode();
			tail.setLocation(loc);
			double result = DistanceCalculator.getEuclideanDist(head.getLocation().getEuclidean(), tail.getLocation().getEuclidean(), "manhattan");
			assertEquals(12, result, 0.1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	//@Test TODO
	public void testEuclideanGeodesicDist() {
		fail("Not yet implemented");
	}


	//@Test
	public void testEuclideanUnknownDTypeDist() {
		try{
			double result = DistanceCalculator.getEuclideanDist(oFac.createLocationEuclidean(), oFac.createLocationEuclidean(), "whatever");
			assert false;
		} catch (Exception e){
			assert true;
			e.printStackTrace();
		}
	}


	@Test
	public void testGpsDist() {
		try {
			Node head = oFac.createInstanceNetworkNodesNode();
			Node tail = oFac.createInstanceNetworkNodesNode();
			Location loc = oFac.createLocation();
			GPSCoordinates gps = oFac.createLocationGPSCoordinates();
			gps.setLat(38.898556);
			gps.setLon(-77.037852);
			loc.setGPSCoordinates(gps);
			head.setLocation(loc);

			gps = oFac.createLocationGPSCoordinates();
			loc = oFac.createLocation();
			gps.setLat(38.897147);
			gps.setLon(-77.043934);
			loc.setGPSCoordinates(gps);
			tail = oFac.createInstanceNetworkNodesNode();
			tail.setLocation(loc);
			double result = DistanceCalculator.getGPSDist(head.getLocation().getGPSCoordinates(), tail.getLocation().getGPSCoordinates());
			assertEquals(0.549, result, 0.1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Test
	public void testGetLinkSucceed() {
		buildLinks();
		Link result = DistanceCalculator.getLink(this.links, BigInteger.valueOf(0), BigInteger.valueOf(1));
		assertEquals(BigInteger.valueOf(1), result.getId());
	}

	@Test
	public void testGetLinkFail() {	
		buildLinks();
		Link result = DistanceCalculator.getLink(this.links, BigInteger.valueOf(1), BigInteger.valueOf(1));
		assertEquals(null, result);
	}


	@Test
	public void testNodeLocationEuclidean() {
		try {
			buildInstance();
			Node head = oFac.createInstanceNetworkNodesNode();
			Node tail = oFac.createInstanceNetworkNodesNode();
			Euclidean euc = oFac.createLocationEuclidean();
			Location loc = oFac.createLocation();
			euc.setCx(1.0);
			euc.setCy(3.0);
			loc.setEuclidean(euc);
			head.setLocation(loc);

			euc = oFac.createLocationEuclidean();
			loc = oFac.createLocation();
			euc.setCx(4.0);
			euc.setCy(6.0);
			loc.setEuclidean(euc);
			tail = oFac.createInstanceNetworkNodesNode();
			tail.setLocation(loc);
			double result = DistanceCalculator.getDistance(this.inst, head, tail);
			assertEquals(4.242640687, result, 0.1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Test
	public void testNodeLocationGPS() {
		try {
			buildInstance();
			Node head = oFac.createInstanceNetworkNodesNode();
			Node tail = oFac.createInstanceNetworkNodesNode();
			Location loc = oFac.createLocation();
			GPSCoordinates gps = oFac.createLocationGPSCoordinates();
			gps.setLat(38.898556);
			gps.setLon(-77.037852);
			loc.setGPSCoordinates(gps);
			head.setLocation(loc);

			gps = oFac.createLocationGPSCoordinates();
			loc = oFac.createLocation();
			gps.setLat(38.897147);
			gps.setLon(-77.043934);
			loc.setGPSCoordinates(gps);
			tail = oFac.createInstanceNetworkNodesNode();
			tail.setLocation(loc);
			double result = DistanceCalculator.getDistance(this.inst, head, tail);
			assertEquals(0.549, result, 0.1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Test
	public void testNodeLocationCustom() {
		Throwable ex = null;
		try {
			buildInstance();
			Document document = null;
			try {
				document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			}
			Custom cus = oFac.createCustom();
			Element el = document.createElement("whatever");
			el.setTextContent(String.valueOf("aValue"));
			cus.getAny().add(el);


			Node head = oFac.createInstanceNetworkNodesNode();
			Node tail = oFac.createInstanceNetworkNodesNode();
			Location loc = oFac.createLocation();
			loc.setCustom(cus);
			head.setLocation(loc);

			loc = oFac.createLocation();
			loc.setCustom(cus);
			tail = oFac.createInstanceNetworkNodesNode();
			tail.setLocation(loc);
			double result = DistanceCalculator.getDistance(this.inst, head, tail);
			assert false;
		} catch (Exception e) {
			ex = e;
		}
		assertTrue(ex instanceof MissingCustomElementException);
	}


	@Test
	public void testNodeLocationNullPointer() {
		try {			
			buildInstance();
			Node head = oFac.createInstanceNetworkNodesNode();
			Node tail = oFac.createInstanceNetworkNodesNode();
			double result = DistanceCalculator.getDistance(this.inst, head, tail);
			assert false;
		} catch (Exception e) {
			assert true;
		}
	}


	@Test
	public void testLinkLength() {
		try {
			buildInstance();
			Node head = oFac.createInstanceNetworkNodesNode();
			Node tail = oFac.createInstanceNetworkNodesNode();
			head.setId(BigInteger.valueOf(0));
			tail.setId(BigInteger.valueOf(1));
			this.inst.getNetwork().getLinks().getLink().get(1).setLength(15.0);
			double result = DistanceCalculator.getDistance(this.inst, head, tail);		
			assertEquals(15.0, result, 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	//@Test TODO
	public void testLinkTime() {
		fail("Not yet implemented");
	}


	//@Test TODO
	public void testLinkTimeNormal() {
		fail("Not yet implemented");
	}


	//@Test TODO
	public void testLinkTimePoisson() {
		fail("Not yet implemented");
	}


	//@Test TODO
	public void testLinkTimeCustom() {
		fail("Not yet implemented");
	}


	@Test
	public void testLinkNullPointer() {
		Throwable ex = null;
		try {
			buildInstance();
			Node head = oFac.createInstanceNetworkNodesNode();
			Node tail = oFac.createInstanceNetworkNodesNode();
			head.setId(BigInteger.valueOf(0));
			tail.setId(BigInteger.valueOf(1));
			double result = DistanceCalculator.getDistance(this.inst, head, tail);		
			assert false;
		} catch (Exception e) {
			ex = e;
		}	
		assertTrue(ex instanceof NullPointerException);
	}

}
