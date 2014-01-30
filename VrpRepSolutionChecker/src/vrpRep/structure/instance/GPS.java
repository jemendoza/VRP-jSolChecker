/**
 * 
 */
package vrpRep.structure.instance;

/**
 * Stores euclidean element information for a node location
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class GPS implements Location {
	/**
	 * Latitude
	 */
	private double	lat;
	/**
	 * Longitude
	 */
	private double	lon;

	/**
	 * Default constructor
	 */
	public GPS() {

	}

	/**
	 * Custom constructor
	 * @param lat latitude
	 * @param lon longitude
	 */
	public GPS(double lat, double lon) {
		super();
		this.lat = lat;
		this.lon = lon;
	}

	/**
	 * @return the latitude
	 */
	public double getLat() {
		return lat;
	}

	/**
	 * @param lat
	 *            the latitude to set
	 */
	public void setLat(double lat) {
		this.lat = lat;
	}

	/**
	 * @return the longitude
	 */
	public double getLon() {
		return lon;
	}

	/**
	 * @param lon
	 *            the longitude to set
	 */
	public void setLon(double lon) {
		this.lon = lon;
	}

}
