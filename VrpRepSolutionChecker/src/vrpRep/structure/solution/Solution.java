/**
 * 
 */
package vrpRep.structure.solution;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 * Main class of default solution structure. Class should be used to add and
 * retrieve elements from the structure.
 * All elements are accessed statically. i.e. Solution.XXX where XXX is either a variable or method name
 * 
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class Solution {

	/**
	 * Path to solution
	 */
	private static Solution		myS;

	/**
	 * Objective function value
	 */
	private double				of;
	/**
	 * List of routes
	 */
	private ArrayList<Route>	routes	= null;

	/**
	 * 
	 */
	public Solution() {
	}

	/**
	 * Sets the solution
	 */
	public static void setSolution() {
		myS = new Solution();
	}

	public static Solution getSolution() {
		return myS;
	}

	/**
	 * @return the of
	 */
	public static double getOf() {
		return myS.of;
	}

	/**
	 * @param of
	 *            the of to set
	 */
	public static void setOf(double of) {
		myS.of = of;
	}

	/**
	 * @return the routes
	 */
	public static ArrayList<Route> getRoutes() {
		return myS.routes;
	}

	/**
	 * Adds route to list of routes
	 * 
	 * @param r
	 *            new route
	 */
	public static void addRoute(Route r) {
		if (myS.routes == null)
			myS.routes = new ArrayList<Route>();
		myS.routes.add(r);
	}

	/**
	 * 
	 * @return iterator of routes
	 */
	public static Iterator<Route> getIterator() {
		return myS.routes.iterator();
	}
}
