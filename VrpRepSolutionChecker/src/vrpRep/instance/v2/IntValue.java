/**
 * 
 */
package vrpRep.instance.v2;

/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class IntValue implements VrpAtt {
	boolean	isFlex;
	int		value;

	/**
	 * @param isFlex
	 */
	public IntValue(int value, boolean isFlex) {
		super();
		this.value = value;
		this.isFlex = isFlex;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
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
