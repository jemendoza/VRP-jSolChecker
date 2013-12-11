package vrpRep.instance.v2;

import java.util.List;

/**
 * 
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 *
 */
public class Instance {

	private List<Node> nodes;
	private List<Link> links;
	private List<Vehicle> fleet;
	private List<Request> requests;
	private Network network;
	
	protected Object instance;
	
	
	
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
	 * 
	 * @param name
	 * @return
	 */
	public Object getInstance(String name){
		//TODO
		return name;
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



	public Object getInstance() {
		return instance;
	}



	public void setInstance(Object instance) {
		this.instance = instance;
	}
}
