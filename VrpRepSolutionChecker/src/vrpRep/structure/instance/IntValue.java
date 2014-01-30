/**
 * 
 */
package vrpRep.structure.instance;

/**
 * Stores a integer value as a VrpAtt object
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class IntValue implements VrpAtt {

	/**
	 * Value of element
	 */
	private int	value;

	/**
	 * Custom constructor
	 * @param value value of element
	 */
	public IntValue(int value) {
		super();
		this.value = value;
	}

	/**
	 * 
	 * @return value the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * 
	 * @param value the new value
	 */
	public void setValue(int value) {
		this.value = value;
	}

}