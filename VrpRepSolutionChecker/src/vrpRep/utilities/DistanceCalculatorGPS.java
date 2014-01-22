/**
 * 
 */
package vrpRep.utilities;

import vrpRep.exceptions.MissingAttributeException;
import vrpRep.factory.DynamicFactory;
import vrpRep.structure.instance.GPS;

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

		try {
			h = (GPS) DynamicFactory.getFactory().getInstance().getNode(head)
					.getAttribute("location").get(0);
			t = (GPS) DynamicFactory.getFactory().getInstance().getNode(tail)
					.getAttribute("location").get(0);

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
		} catch (MissingAttributeException e) {
			e.printStackTrace();
		} catch (Exception e) {
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
