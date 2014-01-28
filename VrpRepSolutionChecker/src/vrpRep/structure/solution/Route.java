/**
 * 
 */
package vrpRep.structure.solution;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Represents a route of the solution
 * 
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class Route {

	/**
	 * Id of route
	 */
	private int					id;
	/**
	 * Type of route (vehicle used for example)
	 */
	private int					type;
	/**
	 * Boolean value to declare if route has a type
	 */
	private boolean				hasType;
	/**
	 * List of requests
	 */
	private ArrayList<Request>	requests;

	/**
	 * 
	 * @param id
	 *            id of route
	 * @param type
	 *            type of route (vehicle used for example)
	 */
	public Route(int id, int type) {
		this.id = id;
		this.type = type;
		this.hasType = true;
		this.requests = new ArrayList<Request>();
	}

	/**
	 * 
	 * @param id
	 *            id of route
	 */
	public Route(int id) {
		this.id = id;
		this.hasType = false;
		this.requests = new ArrayList<Request>();
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the type
	 */
	public int getType() {
		if (!hasType) {
			return -1;
		} else {
			return type;
		}
	}

	/**
	 * 
	 * @return hasType
	 */
	public boolean isHasType() {
		return hasType;
	}

	/**
	 * @return the requests
	 */
	public ArrayList<Request> getRequests() {
		return requests;
	}

	/**
	 * Adds a request
	 * 
	 * @param r
	 *            new request
	 */
	public void addRequest(Request r) {
		this.requests.add(r);
	}

	/**
	 * 
	 * @return iterator of requests
	 */
	public Iterator<Request> getIterator() {
		return requests.iterator();
	}

}
