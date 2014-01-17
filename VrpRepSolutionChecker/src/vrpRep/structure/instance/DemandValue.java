/**
 * 
 */
package vrpRep.structure.instance;

/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class DemandValue extends Demand {
	private double	value;

	public DemandValue() {
		super();
	}

	/**
	 * @param type
	 * @param isSplittable
	 */
	public DemandValue(int type, boolean isSplittable, double value) {
		super(type, isSplittable);
		this.value = value;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

}
