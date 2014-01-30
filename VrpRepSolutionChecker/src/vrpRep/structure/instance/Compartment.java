/**
 * 
 */
package vrpRep.structure.instance;

/**
 * Stores all information related to a vehicle compartment.
 * 
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * @see vrpRep.structure.instance.
 */
public class Compartment implements VehicleAtt {
	/**
	 * Id/Type of compartment
	 */
	private int		type;
	/**
	 * Minimum compartment size
	 */
	private Double	min;
	/**
	 * Maximum compartment size
	 */
	private Double	max;



	/**
	 * @param type Id/Type of compartment
	 * @param min Minimum compartment size
	 * @param max Maximum compartment size
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
	 * @return the Minimum compartment size
	 */
	public Double getMin() {
		return min;
	}

	/**
	 * @param min
	 *            the minimum compartment size to set
	 */
	public void setMin(Double min) {
		this.min = min;
	}

	/**
	 * @return the Maximum compartment size
	 */
	public Double getMax() {
		return max;
	}

	/**
	 * @param max
	 *            the maximum compartment size to set
	 */
	public void setMax(Double max) {
		this.max = max;
	}

}
