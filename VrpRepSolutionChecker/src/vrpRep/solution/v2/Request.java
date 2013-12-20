/**
 * 
 */
package vrpRep.solution.v2;

import java.util.ArrayList;

/**
 * Represents a request in a solution
 * 
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class Request {

	/**
	 * Id of request
	 */
	private int					id;
	/**
	 * List of demands
	 */
	private ArrayList<Demand>	demand;

	/**
	 * 
	 * @param id
	 *            id of request
	 */
	public Request(int id) {
		this.id = id;
		this.demand = new ArrayList<Demand>();
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the demand
	 */
	public ArrayList<Demand> getDemand() {
		return demand;
	}

	/**
	 * Adds a demand to the request
	 * 
	 * @param d
	 *            new demand
	 */
	public void addDemand(Demand d) {
		this.demand.add(d);
	}

}
