/**
 * 
 */
package vrpRep.solutionChecker.solution;

import java.util.LinkedList;

/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 *
 */
public class Route {
	
	/**
	 * Id of route
	 */
	private int id;
	
	
	/**
	 * Type of vehicle used on route
	 */
	private int type;
	
	/**
	 * List of nodes visited on route
	 */
	private LinkedList<Integer> route;

	/**
	 * Constructor
	 * @param id Id of route
	 * @param type Type of vehicle used on route
	 */
	public Route(int id, int type) {
		this.id = id;
		this.type = type;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * @return the route
	 */
	public LinkedList<Integer> getRoute() {
		return route;
	}

	/**
	 * @param route the route to set
	 */
	public void setRoute(LinkedList<Integer> route) {
		this.route = route;
	}
	
	
	
	
	
	
	
	

}
