/**
 * 
 */
package vrpRep.utilities;

import vrpRep.structure.instance.GPS;
import vrpRep.structure.instance.Instance;

/**
 * Calculate distance between two sets of latitude and longitude points
 * 
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class DistanceCalculatorGPS extends DistanceCalculator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see vrpRep.utilities.DistanceCalculator#calculate(int, int)
	 */
	@Override
	public double calculate(int tail, int head) {
		GPS h, t;

		h = (GPS) Instance.getNode(head).getAttribute("location").get(0);
		t = (GPS) Instance.getNode(tail).getAttribute("location").get(0);

		double lon1 = degreeToRadian(h.getLon());
		double lon2 = degreeToRadian(t.getLon());
		double lat1 = degreeToRadian(h.getLat());
		double lat2 = degreeToRadian(t.getLat());
		double dlon = lon2 - lon1;
		double dlat = lat2 - lat1;
		double a = Math.pow(Math.sin(dlat / 2), 2)
				+ (Math.cos(lat1) * Math.cos(lat2) * Math.pow(
						Math.sin(dlon / 2), 2));
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		return 6373 * c;
		// TODO test and compare results with :
		// http://andrew.hedges.name/experiments/haversine/ (may have to change
		// earth raduis from km to m
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
