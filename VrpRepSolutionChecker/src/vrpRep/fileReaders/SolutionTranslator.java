/**
 * 
 */
package vrpRep.fileReaders;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBException;

import vrpRep.structure.solution.Demand;
import vrpRep.structure.solution.Request;
import vrpRep.structure.solution.Route;
import vrpRep.structure.solution.Solution;
import vrpRep.utilities.XmlSchemaReader;

/**
 * Class used to translate a solution from the VRPREP schema structure to the
 * universal SolutionReader structure.
 * 
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class SolutionTranslator implements ISolutionReader {

	/**
	 * Master node containing all xml file info
	 */
	private vrpRep.schema.solution.Solution	schemaSolution;

	/**
	 * Constructor that creates xml tree on class instantiation
	 * 
	 * @param xmlFile
	 *            xml file to extract
	 */
	public SolutionTranslator(File xmlFile) {
		try {
			XmlSchemaReader<vrpRep.schema.solution.Solution> iR = new XmlSchemaReader<vrpRep.schema.solution.Solution>();
			this.schemaSolution = iR.unmarshallDocument(xmlFile,
					vrpRep.schema.solution.Solution.class.getName());
			this.translateSolution();
		} catch (ClassNotFoundException | JAXBException | IOException e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * Calls all translation methods
	 */
	private void translateSolution() {
		Solution.setSolution();
		getObjectiveFunction();
		getRoutes();
	}

	/**
	 * Retrieves objective function
	 */
	private void getObjectiveFunction() {
		Solution.setOf(this.schemaSolution.getObjectiveFunction().getValue());
	}

	/**
	 * Retrieves routes
	 */
	private void getRoutes() {
		Route tR = null;
		for (vrpRep.schema.solution.Solution.Routes.Route r : this.schemaSolution
				.getRoutes().getRoute()) {
			if (r.getType() != null)
				tR = new Route(r.getId().intValue(), r.getType().intValue());
			else
				tR = new Route(r.getId().intValue());
			tR = getRequests(r, tR);
			Solution.addRoute(tR);
		}
	}

	/**
	 * Retrieves requests for a route
	 * 
	 * @param schemaR
	 *            source object
	 * @param route
	 *            destination object
	 * @return Route containing requests
	 */
	private Route getRequests(
			vrpRep.schema.solution.Solution.Routes.Route schemaR, Route route) {
		Request rT = null;
		for (vrpRep.schema.solution.Solution.Routes.Route.Request r : schemaR
				.getRequest()) {
			rT = new Request(r.getRequestId().intValue());
			if (r.getContent().size() == 1) {
				rT.setRequest((String) r.getContent().get(0));
			} else if (r.getContent().size() >= 3) {
				rT = getDemands(r, rT);
			}
			route.addRequest(rT);
		}
		return route;
	}

	/**
	 * Retrieves demands for a request
	 * 
	 * @param schemaR
	 *            source object
	 * @param request
	 *            destination object
	 * @return Request containing demands
	 */
	private Request getDemands(
			vrpRep.schema.solution.Solution.Routes.Route.Request schemaR,
			Request request) {
		Demand dR = null;
		vrpRep.schema.solution.Solution.Routes.Route.Request.Demand d = null;
		for (int i = 1; i < schemaR.getContent().size() - 1; i += 2) {
			d = (vrpRep.schema.solution.Solution.Routes.Route.Request.Demand) ((javax.xml.bind.JAXBElement) schemaR
					.getContent().get(i)).getValue();
			dR = new Demand(d.getProductId().intValue());
			dR.setDemand(Double.valueOf(d.getContent()));
			request.addDemand(dR);
		}
		return request;
	}
}
