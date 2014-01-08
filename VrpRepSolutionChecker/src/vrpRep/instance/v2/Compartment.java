/**
 * 
 */
package vrpRep.instance.v2;

/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class Compartment implements VehicleAtt {
	private int		type;
	private Double	min;
	private Double	max;

	public Compartment() {

	}

	/**
	 * @param type
	 * @param min
	 * @param max
	 */
	public Compartment(int type, Double min, Double max) {
		super();
		this.type = type;
		this.min = min;
		this.max = max;
	}

	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * @return the min
	 */
	public Double getMin() {
		return min;
	}

	/**
	 * @param min
	 *            the min to set
	 */
	public void setMin(Double min) {
		this.min = min;
	}

	/**
	 * @return the max
	 */
	public Double getMax() {
		return max;
	}

	/**
	 * @param max
	 *            the max to set
	 */
	public void setMax(Double max) {
		this.max = max;
	}

}
