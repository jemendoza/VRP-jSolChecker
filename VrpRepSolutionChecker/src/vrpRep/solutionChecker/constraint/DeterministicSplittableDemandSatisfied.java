/**
 * 
 */
package vrpRep.solutionChecker.constraint;

import java.util.ArrayList;
import java.util.HashMap;

import vrpRep.solutionChecker.ConstraintEvaluation;
import vrpRep.solutionChecker.IConstraint;
import vrpRep.structure.instance.DemandValue;
import vrpRep.structure.instance.Instance;
import vrpRep.structure.solution.Demand;
import vrpRep.structure.solution.Request;
import vrpRep.structure.solution.Route;
import vrpRep.structure.solution.Solution;

/**
 * Verifies the demand at each request is satisfied for splittable demands.
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class DeterministicSplittableDemandSatisfied implements IConstraint {

	private ConstraintEvaluation cEval;
	/**
	 * List of demands for each request
	 */
	private RequestCResult[] requestDemands;
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * vrpRep.solutionChecker.constraint.IConstraint#evaluate(vrpRep.solutionChecker
	 * .instance.DefaultInstance,
	 * vrpRep.solutionChecker.solution.DefaultSolution)
	 */
	@Override
	public ConstraintEvaluation checkConstraint() {
		cEval = new ConstraintEvaluation();
		this.requestDemands = new RequestCResult[Instance.getRequests().size()];

		RequestCResult ncr;
		// each route
		for (Route r : Solution.getRoutes()) {
			// sum demands
			for (Request req : r.getRequests()) {
				if(requestDemands[req.getId()] == null)
					requestDemands[req.getId()] = new RequestCResult(req.getId());
				
				ncr = requestDemands[req.getId()];					
				if (req.getDemand().size() != 0) {
					//each demand
					for (Demand d : req.getDemand()) {
						ncr.addDemand(d.getId(), d.getDemand(), ((DemandValue)Instance.getRequest(req.getId()).getAttribute("demand").get(d.getId())).isSplittable());
					}
				}	
			}
		}
		
		checkDemands();
		
		return cEval;
	}
	
	
	/**
	 * Verify all demands are met
	 */
	private void checkDemands() {
		for(RequestCResult ncr : requestDemands){
			for(int pId : ncr.getProductIds()){
				double  demand = ncr.getSumDemands().get(pId);
				double demandReel = ((DemandValue)Instance.getRequest(ncr.getRequestId()).getAttribute("demand").get(pId)).getValue();
				if(demand != demandReel){
					cEval.addMessage("Deterministic splittable demand satisfaction|Request "+ncr.getRequestId()+" , Product "+pId+" - "+ncr.getSumDemands().get(pId)+" not equal to "+((DemandValue)Instance.getRequest(ncr.getRequestId()).getAttribute("demand").get(pId)).getValue());
				}
			}
		}
	}


	/**
	 * Class to store a list of demands for a request
	 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
	 *
	 */
	private class RequestCResult {
		/**
		 * Id of request
		 */
		private int							requestId;
		/**
		 * List of product id's
		 */
		private ArrayList<Integer>			productIds	= new ArrayList<Integer>();
		/**
		 * List of product splitability values
		 */
		private ArrayList<Boolean>			prodsSplitable	= new ArrayList<Boolean>();
		/**
		 * Sum of demands for each product
		 */
		private HashMap<Integer, Double>	sumDemands	= new HashMap<Integer, Double>();
		
		
		/**
		 * Default constructor
		 * @param requestId if of request
		 */
		public RequestCResult(int requestId) {
			this.requestId = requestId;
		}
		
		/**
		 * Add demand to the request
		 * @param productId id of product
		 * @param demand amount of the product
		 * @param prodSplitable true if demand can be split between routes, false otherwise
		 */
		public void addDemand(int productId, double demand, boolean prodSplitable) {
			if (!productIds.contains(productId)) {
				productIds.add(productId);
				prodsSplitable.add(prodSplitable);
				sumDemands.put(productId, demand);
			} else {
				if(prodsSplitable.get(productId))
					sumDemands.put(productId, sumDemands.get(productId) + demand);
			}
		}

		/**
		 * @return the request id
		 */
		public int getRequestId() {
			return requestId;
		}

		/**
		 * @return the productIds
		 */
		public ArrayList<Integer> getProductIds() {
			return productIds;
		}

		/**
		 * @return the sumDemands
		 */
		public HashMap<Integer, Double> getSumDemands() {
			return sumDemands;
		}
		

	}

}
