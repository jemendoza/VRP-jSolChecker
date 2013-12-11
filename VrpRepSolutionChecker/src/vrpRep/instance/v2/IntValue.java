/**
 * 
 */
package vrpRep.instance.v2;

/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 *
 */
public class IntValue implements VrpAtt {
	boolean isFlex;

	/**
	 * @param isFlex
	 */
	public IntValue(boolean isFlex) {
		super();
		this.isFlex = isFlex;
	}

	/**
	 * @return the isFlex
	 */
	public boolean isFlex() {
		return isFlex;
	}

	/**
	 * @param isFlex the isFlex to set
	 */
	public void setFlex(boolean isFlex) {
		this.isFlex = isFlex;
	}
	
	
}
