/**
 * 
 */
package vrpRep.instance.v2;

/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class BooleanValue implements VrpAtt {
	boolean	value;

	/**
	 * @param isFlex
	 */
	public BooleanValue(boolean value) {
		super();
		this.value = value;
	}

	public boolean isValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}

}