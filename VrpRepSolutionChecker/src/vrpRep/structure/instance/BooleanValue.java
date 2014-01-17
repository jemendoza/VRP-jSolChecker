/**
 * 
 */
package vrpRep.structure.instance;

/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class BooleanValue implements VrpAtt {

	private boolean	value;

	/**
	 * @param isFlex
	 */
	public BooleanValue(boolean value) {
		super();
		this.value = value;
	}

	public boolean getValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}

}