/**
 * 
 */
package vrpRep.utilities;

import vrpRep.exceptions.MissingAttributeException;
import vrpRep.structure.instance.GPS;
import vrpRep.structure.instance.Node;

/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class DistanceCalculatorGPS implements IDistanceCalculator {

	/**
	 * Calculate distance between two sets of latitude and longitude points
	 * 
	 * @param head
	 *            GPS coordinates of head node
	 * @param tail
	 *            GPS coordinates of tail node
	 * @return Distance between the nodes
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * vrpRep.utilities.IDistanceCalculator#calculDistance(vrpRep.structure.
	 * instance.Node, vrpRep.structure.instance.Node)
	 */
	@Override
	public double calculDistance(Node headNode, Node tailNode) {
		GPS head, tail;

		try {
			head = (GPS) headNode.getAttribute("location").get(0);
			tail = (GPS) tailNode.getAttribute("location").get(0);

			double lon1 = degreeToRadian(head.getLon());
			double lon2 = degreeToRadian(tail.getLon());
			double lat1 = degreeToRadian(head.getLat());
			double lat2 = degreeToRadian(tail.getLat());
			double dlon = lon2 - lon1;
			double dlat = lat2 - lat1;
			double a = Math.pow(Math.sin(dlat / 2), 2)
					+ (Math.cos(lat1) * Math.cos(lat2) * Math.pow(
							Math.sin(dlon / 2), 2));
			double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
			return 6373 * c;
		} catch (MissingAttributeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO test and compare results with :
		// http://andrew.hedges.name/experiments/haversine/ (may have to change
		// earth raduis from km to m
		return 0;
	}

	/**
	 * 
	 * @param degree
	 *            Degree value of GPS Coordinate
	 * @return Radian value of GPS Coordinate
	 */
	private double degreeToRadian(double degree) {
		return degree * Math.PI / 180;
	}

}
