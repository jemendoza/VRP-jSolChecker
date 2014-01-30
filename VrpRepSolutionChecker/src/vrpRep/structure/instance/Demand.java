/**
 * 
 */
package vrpRep.structure.instance;

/**
 * Stores default information related to a requests demand
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class Demand implements RequestAtt {
	/**
	 * Id/Type of demand
	 */
	private int		type;
	/**
	 * True if demand can be split between routes, false otherwise
	 */
	private boolean	isSplittable;

	
	/**
	 * Default constructor
	 */
	public Demand() {

	}

	/**
	 * Custom constructor
	 * @param type Id/Type of demand
	 * @param isSplittable True if demand can be split between routes, false otherwise
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
	 * @param type
	 *            the type to set
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
	 * @param isSplittable
	 *            the isSplittable to set
	 */
	public void setSplittable(boolean isSplittable) {
		this.isSplittable = isSplittable;
	}

}
