/**
 * 
 */
package vrpRep.solutionChecker.solution;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.JAXBException;

import vrpRep.schema.solution.Solution;
import vrpRep.schema.solution.Solution.Routes.Route.Node;
import vrpRep.utilities.XmlReader;

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
			XmlReader<Solution> iR = new XmlReader<Solution>();
			this.solution = iR.unmarshallDocument(xmlFile, Solution.class.getName());
			this.routes = new LinkedList<Route>();
			extractResults();
		} catch (ClassNotFoundException | JAXBException | IOException e) {
			e.printStackTrace();
		}		
	}


	public LinkedList<Route> getRoutes() {
		return routes;
	}


	public void setRoutes(LinkedList<Route> routes) {
		this.routes = routes;
	}


	/**
	 * 
	 */
	private void extractResults(){
		List<vrpRep.schema.solution.Solution.Routes.Route> routeList = this.solution.getRoutes().getRoute();
		LinkedList<Integer>result;
		Route route = null;

		for (vrpRep.schema.solution.Solution.Routes.Route currentRoute : routeList){
			result = new LinkedList<Integer>();
			int id = 0,type = 0;
			
			BigInteger temp = currentRoute.getId();
			if(temp != null)
				id = temp.intValue();
			temp = currentRoute.getType();
			if(temp != null)
				type = temp.intValue();
			route = new Route(id, type);
			
			for(int i=0;i<currentRoute.getNode().size();i++){
				result.add(0);
			}
			
			for(Node n : currentRoute.getNode()){
				result.set(n.getVisit().intValue(),Integer.parseInt(n.getContent()));
			}
			route.setRoute((LinkedList<Integer>)result);
			routes.add(route);
		}
	}



	/**
	 * 
	 * @return solution
	 */
	public Solution getSolution(){
		return this.solution;
	}

	public void printRoutesOne(){
		for(Route route : routes){
			for(Integer n : route.getRoute()){
				System.out.println(n);
			}		
		}	
	}
}
