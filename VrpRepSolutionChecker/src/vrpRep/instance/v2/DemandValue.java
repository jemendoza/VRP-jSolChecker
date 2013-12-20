/**
 * 
 */
package vrpRep.instance.v2;

/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class DemandValue extends Demand {
	private double	value;

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
