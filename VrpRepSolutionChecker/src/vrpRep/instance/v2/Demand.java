/**
 * 
 */
package vrpRep.instance.v2;

/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 *
 */
public class Demand implements RequestAtt {
	private int type;
	private boolean isSplittable;
	/**
	 * @param type
	 * @param isSplittable
	 */
	public Demand(int type, boolean isSplittable) {
		super();
		this.type = type;
		this.isSplittable = isSplittable;
	}
	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}
	/**
	 * @return the isSplittable
	 */
	public boolean isSplittable() {
		return isSplittable;
	}
	/**
	 * @param isSplittable the isSplittable to set
	 */
	public void setSplittable(boolean isSplittable) {
		this.isSplittable = isSplittable;
	}
	
	
}
