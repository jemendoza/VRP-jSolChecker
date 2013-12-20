/**
 * 
 */
package vrpRep.instance.v2;

/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class BooleanValue implements VrpAtt {
	boolean	isFlex;
	boolean	value;

	/**
	 * @param isFlex
	 */
	public BooleanValue(boolean value, boolean isFlex) {
		super();
		this.value = value;
		this.isFlex = isFlex;
	}

	public boolean isValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}

	/**
	 * @return the isFlex
	 */
	public boolean isFlex() {
		return isFlex;
	}

	/**
	 * @param isFlex
	 *            the isFlex to set
	 */
	public void setFlex(boolean isFlex) {
		this.isFlex = isFlex;
	}

}
