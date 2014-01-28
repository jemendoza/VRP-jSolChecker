/**
 * 
 */
package sandbox;

import vrpRep.factory.ConstraintHandler;
import vrpRep.factory.DynamicFactory;

/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class SolutionChecker {

	private DynamicFactory		factory;

	private ConstraintHandler	cHandler;

	public SolutionChecker(String configFileName) {
		this.factory = new DynamicFactory(configFileName);
		this.cHandler = new ConstraintHandler();
	}

	public void loadInstanceAndSolutionData(String instanceXmlPath,
			String solutionXmlPath) {
		this.factory.buildDefaultInstance(instanceXmlPath);
		this.factory.buildDefaultSolution(solutionXmlPath);
	}

	public void buildDistanceCalculator() {
		this.factory.buildDistanceCalculator();
	}

}
