/**
 * 
 */
package vrpRep.solutionChecker.solution;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.JAXBException;

import vrpRep.schema.solution.Solution;
import vrpRep.schema.solution.Solution.Routes.Route.Node;
import vrpRep.solutionChecker.instanceReader.InstanceReader;

/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 *
 */
public class DefaultSolution {

	/**
	 * Master node containing all xml file info
	 */
	protected Solution solution;
	/**
	 * Solution objective function value
	 */
	protected double of;
	/**
	 * List of routes of type Route
	 * @see Route
	 */
	protected LinkedList<Route> routes;
	
	

	
	
	/**
	 * Constructor that creates xml tree on class instantiation 
	 * @param xmlFile xml file to extract
	 */
	public DefaultSolution(File xmlFile){	
		try {
			InstanceReader<Solution> iR = new InstanceReader<Solution>();
			this.solution = iR.unmarshallDocument(xmlFile, Solution.class.getName());
			extractResults();
		} catch (ClassNotFoundException | JAXBException | IOException e) {
			e.printStackTrace();
		}		
	}
	
	
	/**
	 * 
	 */
	private void extractResults(){
		
	}
	
	
	
	/**
	 * 
	 * @return solution
	 */
	public Solution getSolution(){
		return this.solution;
	}
	
	public void printRoutesOne(){
		List<Node> route = this.solution.getRoutes().getRoute().get(0).getNode();
		for(Node n : route){
			System.out.println(n.getContent());
		}		
	}
}
