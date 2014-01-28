/**
 * 
 */
package sandbox;

import vrpRep.factory.DynamicFactory;

/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class SolutionChecker {

	private DynamicFactory	factory;

	public SolutionChecker(String configFileName) {
		this.factory = new DynamicFactory(configFileName);
	}

}
