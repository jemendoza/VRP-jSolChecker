/**
 * 
 */
package vrpRep.structure.instance;

/**
 * Stores a boolean value as a VrpAtt object
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class DoubleValue implements VrpAtt {
	/**
	 * Value of element
	 */
	private double	value;

	/**
	 * Custom constructor
	 * @param value value of element
	 */
	public DoubleValue(double value) {
		super();
		this.value = value;
	}

	/**
	 * 
	 * @return the value
	 */
	public double getValue() {
		return value;
	}

	/**
	 * 
	 * @param value new value
	 */
	public void setValue(double value) {
		this.value = value;
	}

}