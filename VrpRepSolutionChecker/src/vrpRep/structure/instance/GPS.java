/**
 * 
 */
package vrpRep.structure.instance;

/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class GPS implements Location {

	private double	lat;
	private double	lon;

	public GPS() {

	}

	/**
	 * @param lat
	 * @param lon
	 */
	public GPS(double lat, double lon) {
		super();
		this.lat = lat;
		this.lon = lon;
	}

	/**
	 * @return the lat
	 */
	public double getLat() {
		return lat;
	}

	/**
	 * @param lat
	 *            the lat to set
	 */
	public void setLat(double lat) {
		this.lat = lat;
	}

	/**
	 * @return the lon
	 */
	public double getLon() {
		return lon;
	}

	/**
	 * @param lon
	 *            the lon to set
	 */
	public void setLon(double lon) {
		this.lon = lon;
	}

}
