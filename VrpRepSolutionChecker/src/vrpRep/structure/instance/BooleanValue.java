/**
 * 
 */
package vrpRep.structure.instance;

/**
 * Stores a boolean value as a VrpAtt object
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class BooleanValue implements VrpAtt {

	/**
	 * Value of element
	 */
	private boolean	value;

	/**
	 * Custom constructor
	 * @param value value of element
	 */
	public BooleanValue(boolean value) {
		super();
		this.value = value;
	}

	/**
	 * 
	 * @return value the value
	 */
	public boolean getValue() {
		return value;
	}

	/**
	 * 
	 * @param value the new value
	 */
	public void setValue(boolean value) {
		this.value = value;
	}

}