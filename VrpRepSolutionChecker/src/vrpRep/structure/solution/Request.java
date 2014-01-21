/**
 * 
 */
package vrpRep.structure.solution;

import java.util.ArrayList;
import java.util.Iterator;

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
	private ArrayList<Demand>	demands;
	/**
	 * 
	 */
	private String				request;

	/**
	 * 
	 * @param id
	 *            id of request
	 */
	public Request(int id) {
		this.id = id;
		this.demands = new ArrayList<Demand>();
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
		return demands;
	}

	/**
	 * Adds a demand to the request
	 * 
	 * @param d
	 *            new demand
	 */
	public void addDemand(Demand d) {
		this.demands.add(d);
	}

	/**
	 * 
	 * @return
	 */
	public String getRequest() {
		return request;
	}

	/**
	 * 
	 * @param request
	 */
	public void setRequest(String request) {
		this.request = request;
	}

	/**
	 * 
	 * @return iterator of demand
	 */
	public Iterator<Demand> getIterator() {
		return demands.iterator();
	}

}