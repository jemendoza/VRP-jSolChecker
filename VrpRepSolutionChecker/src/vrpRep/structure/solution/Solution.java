/**
 * 
 */
package vrpRep.structure.solution;

import java.util.ArrayList;

/**
 * Represents the default solution
 * 
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class Solution {

	/**
	 * Objective function value
	 */
	private double				of;
	/**
	 * List of routes
	 */
	private ArrayList<Route>	routes;

	/**
	 * 
	 */
	public Solution() {
		this.routes = new ArrayList<Route>();
	}

	/**
	 * @return the of
	 */
	public double getOf() {
		return of;
	}

	/**
	 * @param of
	 *            the of to set
	 */
	public void setOf(double of) {
		this.of = of;
	}

	/**
	 * @return the routes
	 */
	public ArrayList<Route> getRoutes() {
		return routes;
	}

	/**
	 * Adds route to list of routes
	 * 
	 * @param r
	 *            new route
	 */
	public void addRoute(Route r) {
		this.routes.add(r);
	}
}
