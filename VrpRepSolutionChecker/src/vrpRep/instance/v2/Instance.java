package vrpRep.instance.v2;

import java.util.ArrayList;
import java.util.List;

import vrpRep.exceptions.MissingAttributeException;
import vrpRep.exceptions.MissingElementException;

/**
 * 
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 *
 */
public class Instance {

	private List<Node> nodes = null;
	private List<Link> links = null;
	private List<Vehicle> fleet = null;
	private List<Request> requests = null;
	private Network network = null;

	
	
	public Instance(){
	}
	
	/**
	 * 
	 * @param nodes
	 * @param links
	 * @param fleet
	 * @param requests
	 * @param network
	 */
	public Instance(List<Node> nodes, List<Link> links, List<Vehicle> fleet,
			List<Request> requests, Network network) {
		super();
		this.nodes = nodes;
		this.links = links;
		this.fleet = fleet;
		this.requests = requests;
		this.network = network;
	}
	
	
	/**
	 * Adds node to list of nodes. Creates node list if it does not exist.
	 * @param n Node to add to list
	 */
	public void addNode(Node n){
		if(this.nodes == null){
			this.nodes = new ArrayList<Node>();
			this.nodes.add(n);
		}else{
			this.nodes.add(n);
		}
	}
	
	/**
	 * Adds link to list of links. Creates link list if it does not exist.
	 * @param l link to add to list
	 */
	public void addLink(Link l){
		if(this.links == null){
			this.links = new ArrayList<Link>();
			this.links.add(l);
		}else{
			this.links.add(l);
		}
	}
	
	/**
	 * Adds vehicle to fleet. Creates fleet list if it does not exist.
	 * @param v vehicle to add to list
	 */
	public void addFleet(Vehicle v){
		if(this.fleet == null){
			this.fleet = new ArrayList<Vehicle>();
			this.fleet.add(v);
		}else{
			this.fleet.add(v);
		}
	}
	
	/**
	 * Adds request to list of requests. Creates request list if it does not exist.
	 * @param r Request to add to list
	 */
	public void addRequest(Request r){
		if(this.requests == null){
			this.requests = new ArrayList<Request>();
			this.requests.add(r);
		}else{
			this.requests.add(r);
		}
	}

	
	/**
	 * Retrieves node from list based on node id
	 * @param id id of node
	 * @return Node if found
	 * @throws MissingElementException Thrown if Node not found
	 */
	public Node getNode(int id) throws MissingElementException{
		int i = 0;
		while(i < this.nodes.size() && this.nodes.get(i).getId() != id)
			i++;
		
		if(i >= this.nodes.size())
			throw new MissingElementException("node");
		else
			return this.nodes.get(i);
	}
	
	/**
	 * Retrieves link from list based on link id
	 * @param head head id of link
	 * @param tail tail id of link
	 * @return link if found
	 * @throws MissingElementException Thrown if link not found
	 */
	public Link getlink(int head, int tail) throws MissingElementException{
		int i = 0;
		while(i < this.links.size() && (this.links.get(i).getHead() != head || this.links.get(i).getTail() != tail))
			i++;
		
		if(i >= this.links.size())
			throw new MissingElementException("link");
		else
			return this.links.get(i);
	}
	
	
	/**
	 * Retrieves request from list based on request id
	 * @param id id of request
	 * @return request if found
	 * @throws MissingElementException Thrown if request not found
	 */
	public Request getRequest(int id) throws MissingElementException{
		int i = 0;
		while(i < this.requests.size() && this.requests.get(i).getId() != id)
			i++;
		
		if(i >= this.requests.size())
			throw new MissingElementException("request");
		else
			return this.requests.get(i);
	}
	
	
	
	/**
	 * Retrieves vehicle from list based on vehicle id
	 * @param id id of vehicle
	 * @return vehicle if found
	 * @throws MissingElementException Thrown if vehicle not found
	 */
	public Vehicle getVehicle(int id) throws MissingElementException{
		int i = 0;
		while(i < this.fleet.size() && this.fleet.get(i).getId() != id)
			i++;
		
		if(i >= this.fleet.size())
			throw new MissingElementException("vehicle");
		else
			return this.fleet.get(i);
	}
	
	
	/**
	 * 
	 * @param id
	 * @param attName
	 * @return
	 * @throws MissingElementException
	 * @throws MissingAttributeException 
	 */
	public List<VrpAtt> getNodeAttribute(int id, String attName) throws MissingElementException, MissingAttributeException{
		Node n = getNode(id);
		return n.getAttribute(attName);
	}
	
	
	

	
	public List<Node> getNodes() {
		return nodes;
	}



	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}



	public List<Link> getLinks() {
		return links;
	}



	public void setLinks(List<Link> links) {
		this.links = links;
	}



	public List<Vehicle> getFleet() {
		return fleet;
	}



	public void setFleet(List<Vehicle> fleet) {
		this.fleet = fleet;
	}



	public List<Request> getRequests() {
		return requests;
	}



	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}



	public Network getNetwork() {
		return network;
	}



	public void setNetwork(Network network) {
		this.network = network;
	}
}
