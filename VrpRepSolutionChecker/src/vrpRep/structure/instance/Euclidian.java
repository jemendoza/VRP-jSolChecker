/**
 * 
 */
package vrpRep.structure.instance;

/**
 * Stores euclidean element information for a node location
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class Euclidian implements Location {
	/**
	 * x coordinate
	 */
	private double	cx;
	/**
	 * y coordinate
	 */
	private double	cy;
	/**
	 * z coordinate
	 */
	private double	cz;

	/**
	 * Default constructor
	 */
	public Euclidian() {

	}

	/**
	 * Two dimensional constructor
	 * @param cx x coordinate
	 * @param cy y coordinate
	 */
	public Euclidian(double cx, double cy) {
		this.cx = cx;
		this.cy = cy;
	}

	/**
	 * Three dimensional constructor
	 * @param cx x coordinate
	 * @param cy y coordinate
	 * @param cz z coordinate
	 */
	public Euclidian(double cx, double cy, double cz) {
		this.cx = cx;
		this.cy = cy;
		this.cz = cz;
	}

	/**
	 * @return the cx
	 */
	public double getCx() {
		return cx;
	}

	/**
	 * @param cx
	 *            the cx to set
	 */
	public void setCx(double cx) {
		this.cx = cx;
	}

	/**
	 * @return the cy
	 */
	public double getCy() {
		return cy;
	}

	/**
	 * @param cy
	 *            the cy to set
	 */
	public void setCy(double cy) {
		this.cy = cy;
	}

	/**
	 * @return the cz
	 */
	public double getCz() {
		return cz;
	}

	/**
	 * @param cz
	 *            the cz to set
	 */
	public void setCz(double cz) {
		this.cz = cz;
	}

}
