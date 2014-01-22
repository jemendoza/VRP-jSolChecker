/**
 * 
 */
package vrpRep.utilities;

import java.util.List;

import vrpRep.factory.DynamicFactory;
import vrpRep.fileReaders.ILocationReader;
import vrpRep.fileReaders.LocationEuc2DReader;
import vrpRep.fileReaders.LocationEuc3DReader;
import vrpRep.fileReaders.LocationGpsReader;
import vrpRep.structure.instance.DoubleValue;
import vrpRep.structure.instance.Euclidian;
import vrpRep.structure.instance.GPS;
import vrpRep.structure.instance.Instance;
import vrpRep.structure.instance.Link;
import vrpRep.structure.instance.Node;

/**
 * Class contains static methods used to calculate distances between nodes
 * 
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class DistanceCalculator {

	/**
	 * Calculates the distance between two nodes taking <b>node id's as
	 * parameters</b>.
	 * 
	 * @param inst
	 *            Contains all the xml file
	 * @param head
	 *            Head node
	 * @param tail
	 *            Tail node
	 * @return Distance between the nodes
	 * @throws Exception
	 *             Throws exception if custom elements are found of if
	 *             information is missing
	 */
	public static double getDistance(Instance inst, int head, int tail)
			throws Exception {
		return getDistance(inst, getNode(inst, head), getNode(inst, tail));
	}

	/**
	 * Calculates the distance between two nodes taking <b>Node objects as
	 * parameters</b>.
	 * 
	 * @param inst
	 *            Contains an instance
	 * @param head
	 *            Head node
	 * @param tail
	 *            Tail node
	 * @return Distance between the nodes
	 * @throws Exception
	 *             Throws exception if custom elements are found of if
	 *             information is missing
	 */
	public static double getDistance(Instance inst, Node head, Node tail)
			throws Exception {
		// check if instance file contains node locations
		if (head.getAttribute("location") != null
				&& tail.getAttribute("location") != null) {
			ILocationReader lr = DynamicFactory.getFactory()
					.getLocationReader();
			if (lr instanceof LocationEuc2DReader) {
				getEuclideanDist(
						(Euclidian) head.getAttribute("location").get(0),
						(Euclidian) tail.getAttribute("location").get(0), inst
								.getNetwork().getDistanceType(), 2);
			} else if (lr instanceof LocationEuc3DReader) {
				getEuclideanDist(
						(Euclidian) head.getAttribute("location").get(0),
						(Euclidian) tail.getAttribute("location").get(0), inst
								.getNetwork().getDistanceType(), 3);
			} else if (lr instanceof LocationGpsReader) {
				getGPSDist((GPS) head.getAttribute("location").get(0),
						(GPS) tail.getAttribute("location").get(0));
			}
			// check whether the distance is euclidean or gps or custom
		}
		// else use link measurement
		else {
			// check whether the link length is length or time
			Link link = getLink(inst.getLinks(), head.getId(), tail.getId());
			if (link.getAttribute("lenght").get(0) != null) {
				return ((DoubleValue) link.getAttribute("lenght").get(0))
						.getValue();
			} else if (link.getAttribute("probabilityDistribution").get(0) != null) {
				// TODO probability distribution
				return 0;
			} else if (link.getAttribute("time").get(0) != null) {
				return ((DoubleValue) link.getAttribute("time").get(0))
						.getValue();
			}
		}
		return 0;
	}

	/**
	 * Calculate distance between two sets of euclidean points (2D or 3D). <br />
	 * Distance measurements usable are : Euclidean, Manhattan/Taxi cab and
	 * Geodesic
	 * 
	 * @param head
	 *            Euclidean coordinates of head node
	 * @param tail
	 *            Euclidean coordinates of tail node
	 * @param distanceType
	 *            String element defining distance measurement
	 * @return Distance between two nodes
	 * @throws Exception
	 *             Throws exception if distance type is unknown
	 */
	public static double getEuclideanDist(Euclidian head, Euclidian tail,
			String distanceType, int d2d3) throws Exception {

		if (distanceType.equals("") || distanceType.contains("euclidean")) {
			if (d2d3 == 3) {
				return Math.sqrt(Math.pow(head.getCx() - tail.getCx(), 2)
						+ Math.pow(head.getCy() - tail.getCy(), 2)
						+ Math.pow(head.getCz() - tail.getCz(), 2));
			} else {
				return Math.sqrt(Math.pow(head.getCx() - tail.getCx(), 2)
						+ Math.pow(head.getCy() - tail.getCy(), 2));
			}
		} else if (!distanceType.equals("")
				&& distanceType.contains("manhattan")) {
			if (d2d3 == 3) {
				return Math.abs(head.getCx() - tail.getCx())
						+ Math.abs(head.getCy() - tail.getCy())
						+ Math.abs(head.getCz() - tail.getCz());
			} else {
				return Math.abs(head.getCx() - tail.getCx())
						+ Math.abs(head.getCy() - tail.getCy());
			}
		} else if (!distanceType.equals("")
				&& distanceType.contains("geodesic")) {
			if (d2d3 == 3) {// TODO Geodesic distance
				return 0.0;
			} else {
				return 0.0;
			}
		} else {
			throw new Exception("Unknown distance type");
		}
	}

	/**
	 * Calculate distance between two sets of latitude and longitude points
	 * 
	 * @param head
	 *            GPS coordinates of head node
	 * @param tail
	 *            GPS coordinates of tail node
	 * @return Distance between the nodes
	 */
	public static double getGPSDist(GPS head, GPS tail) {
		double lon1 = degreeToRadian(head.getLon());
		double lon2 = degreeToRadian(tail.getLon());
		double lat1 = degreeToRadian(head.getLat());
		double lat2 = degreeToRadian(tail.getLat());
		double dlon = lon2 - lon1;
		double dlat = lat2 - lat1;
		double a = Math.pow(Math.sin(dlat / 2), 2)
				+ (Math.cos(lat1) * Math.cos(lat2) * Math.pow(
						Math.sin(dlon / 2), 2));
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		return 6373 * c;
		// TODO test and compare results with :
		// http://andrew.hedges.name/experiments/haversine/ (may have to change
		// earth raduis from km to m
	}

	/**
	 * 
	 * @param degree
	 *            Degree value of GPS Coordinate
	 * @return Radian value of GPS Coordinate
	 */
	public static double degreeToRadian(double degree) {
		return degree * Math.PI / 180;
	}

	/**
	 * Retrieve link from link list that corresponds to input nodes
	 * 
	 * @param Links
	 *            list of links
	 * @param headId
	 *            Head node id
	 * @param tailId
	 *            Tail node id
	 * @return Link if found, null otherwise
	 */
	public static Link getLink(List<Link> links, int headId, int tailId) {
		Link temp = null;
		int i = 0;
		while (i < links.size()) {
			temp = links.get(i);
			if (temp.getHead() == headId && temp.getTail() == tailId)
				return temp;
			i++;
		}
		return null;
	}

	/**
	 * Retrieve node in instance file based on node id
	 * 
	 * @param instance
	 *            Contains all the xml file
	 * @param nodeId
	 *            Id of node
	 * @return Node object in instance file of id nodeId
	 */
	public static Node getNode(Instance instance, int nodeId) {
		List<Node> nodes = instance.getNodes();
		int i = 0;

		while (i < nodes.size() && nodes.get(i).getId() != nodeId) {
			i++;
		}

		if (i < nodes.size())
			return nodes.get(i);
		else
			return null;
	}

}
