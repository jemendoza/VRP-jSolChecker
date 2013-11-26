/**
 * 
 */
package vrpRep.solutionChecker.instance;

import static org.junit.Assert.*;

import java.io.File;
import java.math.BigInteger;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import vrpRep.schema.instance.Instance;
import vrpRep.schema.instance.Instance.Network.Nodes.Node;

/**
 * Test the valididy of the instance reader
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 *
 */
public class DefaultInstanceTest {
	
	/**
	 * Class being tested
	 */
	private Instance d;
	

	/**
	 * First 10 node id values base on XML instance : A-n32-k5.xml.zip
	 */
	private int[] ids;
	/**
	 * First 10 node type values base on XML instance : A-n32-k5.xml.zip
	 */
	private int[] types;
	/**
	 * First 10 node x coordinate values base on XML instance : A-n32-k5.xml.zip
	 */
	private double[] xs;
	/**
	 * First 10 node y coordinate values base on XML instance : A-n32-k5.xml.zip
	 */
	private double[] ys;
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before	
	public void setUp() throws Exception {
		d = (Instance) new StandardInstance(new File("./schemaFiles/A-n32-k5.xml.zip")).instance;
		ids = new int[]{1,2,3,4,5,6,7,8,9,10};
		types = new int[]{0,1,1,1,1,1,1,1,1,1};
		xs = new double[]{82.0,96.0,50.0,49.0,13.0,29.0,58.0,84.0,14.0,2.0};
		ys = new double[]{76.0,44.0,5.0,8.0,7.0,89.0,30.0,39.0,24.0,39.0};

	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	
	/**
	 * Test the first 10 id values of xml file A-n32-k5.xml.zip
	 */
	@Test
	public void testIds() {
		List<Node> nodes = d.getNetwork().getNodes().getNode();
		for(int i = 0; i < 10; i++){
			assertEquals(nodes.get(i).getId(), BigInteger.valueOf(ids[i]));
		}
	}
	
	
	/**
	 * Test the first 10 type values of xml file A-n32-k5.xml.zip
	 */
	@Test
	public void testTypes() {
		List<Node> nodes = d.getNetwork().getNodes().getNode();
		for(int i = 0; i < 10; i++){
			assertEquals(nodes.get(i).getType(), BigInteger.valueOf(types[i]));
		}
	}
	
	
	/**
	 * Test the first 10 x coordinate values of xml file A-n32-k5.xml.zip
	 */
	@Test
	public void testXCoordinates() {
		List<Node> nodes = d.getNetwork().getNodes().getNode();
		for(int i = 0; i < 10; i++){
			assertEquals(nodes.get(i).getLocation().getEuclidean().getCx(), xs[i], 0);
		}
	}

	
	/**
	 * Test the first 10 y coordinate values of xml file A-n32-k5.xml.zip
	 */
	@Test
	public void testYCoordinates() {
		List<Node> nodes = d.getNetwork().getNodes().getNode();
		for(int i = 0; i < 10; i++){
			assertEquals(nodes.get(i).getLocation().getEuclidean().getCy(), ys[i], 0);
		}
	}

}
