package vrpRep.structure.instance;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Main class of default instance structure. <br />
 * Class should be used access Request, Link, Node, Vehicle and Network information.
 * All elements are accessed statically. i.e. Instance.XXX where XXX is either a variable or method name
 * 
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * @see vrpRep.structure.instance.Request
 * @see vrpRep.structure.instance.Link
 * @see vrpRep.structure.instance.Node
 * @see vrpRep.structure.instance.Vehicle
 * @see vrpRep.structure.instance.Network
 */
public class Instance {

	/**
	 * Path to instance
	 */
	private static Instance	myI;
	/**
	 * List of nodes
	 * 
	 * @see vrpRep.structure.instance.Node
	 */
	private List<Node>		nodes		= null;
	/**
	 * List of links
	 * 
	 * @see vrpRep.structure.instance.Link
	 */
	private List<Link>		links		= null;
	/**
	 * List of vehicles
	 * 
	 * @see vrpRep.structure.instance.Vehicle
	 */
	private List<Vehicle>	fleet		= null;
	/**
	 * List of requests
	 * 
	 * @see vrpRep.structure.instance.Request
	 */
	private List<Request>	requests	= null;
	/**
	 * Details about the network.
	 * 
	 * @see vrpRep.structure.instance.Network
	 */
	private Network			network		= null;

	public Instance() {
	}

	/**
	 * Sets the instance
	 */
	public static void setInstance() {
		myI = new Instance();
	}

	public static Instance getInstance() {
		return myI;
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
		myI.nodes = nodes;
		myI.links = links;
		myI.fleet = fleet;
		myI.requests = requests;
		myI.network = network;
	}

	/**
	 * Adds node to list of nodes. Creates node list if it does not exist.
	 * 
	 * @param n
	 *            Node to add to list
	 */
	public static void addNode(Node n) {
		if (myI.nodes == null) {
			myI.nodes = new ArrayList<Node>();
			myI.nodes.add(n);
		} else {
			myI.nodes.add(n);
		}
	}

	/**
	 * Adds link to list of links. Creates link list if it does not exist.
	 * 
	 * @param l
	 *            link to add to list
	 */
	public static void addLink(Link l) {
		if (myI.links == null) {
			myI.links = new ArrayList<Link>();
			myI.links.add(l);
		} else {
			myI.links.add(l);
		}
	}

	/**
	 * Adds vehicle to fleet. Creates fleet list if it does not exist.
	 * 
	 * @param v
	 *            vehicle to add to list
	 */
	public static void addFleet(Vehicle v) {
		if (myI.fleet == null) {
			myI.fleet = new ArrayList<Vehicle>();
			myI.fleet.add(v);
		} else {
			myI.fleet.add(v);
		}
	}

	/**
	 * Adds request to list of requests. Creates request list if it does not
	 * exist.
	 * 
	 * @param r
	 *            Request to add to list
	 */
	public static void addRequest(Request r) {
		if (myI.requests == null) {
			myI.requests = new ArrayList<Request>();
			myI.requests.add(r);
		} else {
			myI.requests.add(r);
		}
	}

	/**
	 * Retrieves node from list based on node id
	 * 
	 * @param id
	 *            id of node
	 * @return Node if found
	 * @throws MissingElementException
	 *             Thrown if Node not found
	 */
	public static Node getNode(int id) {
		int i = 0;
		while (i < myI.nodes.size() && myI.nodes.get(i).getId() != id)
			i++;

		if (i > myI.nodes.size())
			throw new IndexOutOfBoundsException("Node");
		else
			return myI.nodes.get(i);
	}

	/**
	 * Retrieves link from list based on link id
	 * 
	 * @param head
	 *            head id of link
	 * @param tail
	 *            tail id of link
	 * @return link if found
	 * @throws MissingElementException
	 *             Thrown if link not found
	 */
	public static Link getLink(int head, int tail) {
		int i = 0;
		while (i < myI.links.size()
				&& (myI.links.get(i).getHead() != head || myI.links.get(i)
						.getTail() != tail))
			i++;

		if (i > myI.links.size())
			throw new IndexOutOfBoundsException("Link");
		else
			return myI.links.get(i);
	}

	/**
	 * Retrieves request from list based on request id
	 * 
	 * @param id
	 *            id of request
	 * @return request if found
	 * @throws MissingElementException
	 *             Thrown if request not found
	 */
	public static Request getRequest(int id) {
		int i = 0;
		while (i < myI.requests.size() && myI.requests.get(i).getId() != id)
			i++;

		if (i > myI.requests.size())
			throw new IndexOutOfBoundsException("Request");
		else
			return myI.requests.get(i);
	}

	/**
	 * Retrieves vehicle from list based on vehicle id
	 * 
	 * @param type
	 *            id of vehicle
	 * @return vehicle if found
	 */
	public static Vehicle getVehicle(int type) {
		int i = 0;
		boolean result = false;
		while (i < myI.fleet.size() && !result) {

			if (myI.fleet.get(i).getAttribute("type") != null) {
				if (((IntValue) (myI.fleet.get(i).getAttribute("type").get(0)))
						.getValue() == type)
					result = true;
			}
			i++;
		}

		if (i > myI.fleet.size())
			throw new IndexOutOfBoundsException("Vehicle");
		else
			return myI.fleet.get(--i);
	}

	/**
	 * Retrieves vehicle from list based when only one vehicle type exists
	 * 
	 * @return vehicle if found
	 */
	public static Vehicle getVehicle() {
		return myI.fleet.get(0);
	}



	/**
	 * 
	 * @return List of nodes
	 */
	public static List<Node> getNodes() {
		return myI.nodes;
	}

	/**
	 * 
	 * @return List of links
	 */
	public static List<Link> getLinks() {
		return myI.links;
	}

	/**
	 * 
	 * @return List of fleet
	 */
	public static List<Vehicle> getFleet() {
		return myI.fleet;
	}

	/**
	 * 
	 * @return List of requests
	 */
	public static List<Request> getRequests() {
		return myI.requests;
	}

	/**
	 * 
	 * @return network object
	 */
	public static Network getNetwork() {
		if (myI.network == null)
			myI.network = new Network();

		return myI.network;
	}
}
