/**
 * 
 */
package vrpRep.structure.instance;

/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class Moment {
	private String	name;
	private double	value;

	public Moment() {
		// TODO : Javadoc
	}

	public Moment(String name, double value) {
		super();
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

}
