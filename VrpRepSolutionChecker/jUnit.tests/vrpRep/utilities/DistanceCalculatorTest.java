package vrpRep.utilities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import vrpRep.fileReaders.IInstanceReader;
import vrpRep.fileReaders.InstanceTranslator;
import vrpRep.structure.instance.Instance;


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

	@Before
	public void setUp() throws Exception {	
		// set up test
		IInstanceReader instR = new InstanceTranslator(new File(
				"./xmlTest/testDistanceCalculator.xml"));
	}

	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testEuc2D() {
		try {
			Instance.getNetwork().setDistanceType("euclidean");
			DistanceCalculatorEuc2D d2d= new DistanceCalculatorEuc2D();
			assertEquals(d2d.calculate(2, 3), 270.2536, 0.0001);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testEuc2DManhattan() {
		try {
			Instance.getNetwork().setDistanceType("manhattan");
			DistanceCalculatorEuc2D d2d= new DistanceCalculatorEuc2D();
			assertEquals((int)d2d.calculate(2, 3), 295);		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testEuc2DGeodesic() {
		try {
			Instance.getNetwork().setDistanceType("geodesic");
			assertFalse(true);
			//TODO
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testEuc3D() {
		try {
			Instance.getNetwork().setDistanceType("euclidean");
			DistanceCalculatorEuc3D d3d= new DistanceCalculatorEuc3D();
			assertEquals(d3d.calculate(0, 1), 55.6596, 0.0001);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testEuc3DManhattan() {
		try {
			Instance.getNetwork().setDistanceType("manhattan");
			DistanceCalculatorEuc3D d3d= new DistanceCalculatorEuc3D();
			assertEquals((int)d3d.calculate(0, 1), 86);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testEuc3DGeodesic() {
		try {
			Instance.getNetwork().setDistanceType("geodesic");
			assertFalse(true);
			//TODO
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGPS() {
		try {
			DistanceCalculatorGPS gps= new DistanceCalculatorGPS();
			assertEquals(gps.calculate(4, 5), 265.066, 0.001);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testLink() {
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
