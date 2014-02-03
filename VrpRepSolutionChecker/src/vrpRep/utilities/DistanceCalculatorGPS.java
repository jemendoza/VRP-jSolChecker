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

		double lat1 = h.getLat(), lat2 = t.getLat();
;		double dlat = degreeToRadian(lat2-lat1);
		double dlon =  degreeToRadian(t.getLon()-h.getLon());
		lat1 = degreeToRadian(lat1);
		lat2 = degreeToRadian(lat2);
		
		double a = (Math.sin(dlat/2)*Math.sin(dlat/2))
				+ Math.sin(dlon/2)*Math.sin(dlon/2)* Math.cos(lat1)* Math.cos(lat2);
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
