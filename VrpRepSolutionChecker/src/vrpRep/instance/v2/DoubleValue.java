/**
 * 
 */
package vrpRep.instance.v2;

/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class DoubleValue implements VrpAtt {
	boolean	isFlex;
	double	value;

	/**
	 * @param isFlex
	 */
	public DoubleValue(double value, boolean isFlex) {
		super();
		this.value = value;
		this.isFlex = isFlex;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
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
