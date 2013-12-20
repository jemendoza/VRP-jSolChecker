/**
 * 
 */
package vrpRep.solution.v2;

/**
 * Represents the demand of a request in a solution
 * 
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class Demand {

	/**
	 * Id of product
	 */
	private int		id;
	/**
	 * Value of demand
	 */
	private double	demand;

	/**
	 * 
	 * @param productId
	 *            id of product
	 */
	public Demand(int id) {
		this.id = id;
	}

	/**
	 * 
	 * @param id
	 *            id of product
	 * @param demand
	 *            demand
	 */
	public Demand(int id, double demand) {
		this.id = id;
		this.demand = demand;
	}

	/**
	 * @return the productId
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the demand
	 */
	public double getDemand() {
		return demand;
	}

	/**
	 * @param demand
	 *            the demand to set
	 */
	public void setDemand(double demand) {
		this.demand = demand;
	}

}
