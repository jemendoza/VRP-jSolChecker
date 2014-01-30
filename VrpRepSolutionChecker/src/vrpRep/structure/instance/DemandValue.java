/**
 * 
 */
package vrpRep.structure.instance;

/**
 * Stores information related to a demand based on a desterministic value
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class DemandValue extends Demand {
	/**
	 * Value of demand
	 */
	private double	value;

	/**
	 * Default constructor
	 */
	public DemandValue() {
		super();
	}

	/**
	 * Custom constructor
	 * @param type Id/Type of demand
	 * @param isSplittable true if demand can be split between routes, false otherwise
	 */
	public DemandValue(int type, boolean isSplittable, double value) {
		super(type, isSplittable);
		this.value = value;
	}

	/**
	 * 
	 * @return the value
	 */
	public double getValue() {
		return value;
	}

	/**
	 * 
	 * @param value the new value
	 */
	public void setValue(double value) {
		this.value = value;
	}

}
