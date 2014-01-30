/**
 * 
 */
package vrpRep.structure.instance;

/**
 * Stores all information related to a Moment for a probability distribution
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class Moment {
	/**
	 * Name of moment
	 */
	private String	name;
	/**
	 * Value of moment
	 */
	private double	value;

	/**
	 * Default constructor
	 */
	public Moment() {
	}

	/**
	 * Custom constructor
	 * @param name name of moment
	 * @param value value of moment
	 */
	public Moment(String name, double value) {
		super();
		this.name = name;
		this.value = value;
	}

	/**
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
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
