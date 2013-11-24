/**
 * 
 */
package vrpRep.utilities;

import java.math.BigInteger;
import java.util.List;


import vrpRep.exceptions.MissingCustomElementException;
import vrpRep.schema.instance.Instance;
import vrpRep.schema.instance.Instance.Network.Links.Link;
import vrpRep.schema.instance.Instance.Network.Nodes.Node;
import vrpRep.schema.instance.Location.Euclidean;
import vrpRep.schema.instance.Location.GPSCoordinates;
import vrpRep.schema.instance.SpeedProfile;



/**
 * Class contains static methods used to calculate distances between nodes
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 *
 */
public class DistanceCalculator {


	/**
	 * Calculates the distance between two nodes
	 * @param inst Contains all the xml file
	 * @param head Head node
	 * @param tail Tail node
	 * @return Distance between the nodes
	 * @throws Exception Throws exception if custom elements are found of if information is missing
	 */
	public static double getDistance(Instance inst, Node head, Node tail) throws Exception{
		// check if instance file contains node locations
		if(head.getLocation() != null && tail.getLocation() != null){
			// check whether the distance is euclidean of gps or custom
			if(head.getLocation().getEuclidean() != null && tail.getLocation().getEuclidean() != null)
				return getEuclideanDist(head.getLocation().getEuclidean(), tail.getLocation().getEuclidean(), inst.getNetwork().getDescriptor().getDistanceType());
			else if(head.getLocation().getGPSCoordinates() != null && tail.getLocation().getGPSCoordinates() != null)
				return getGPSDist(head.getLocation().getGPSCoordinates(), tail.getLocation().getGPSCoordinates());
			else if(head.getLocation().getCustom() != null || tail.getLocation().getCustom() != null)
				throw new MissingCustomElementException("node location");
			else
				throw new NullPointerException("Node location element missing");
		}
		// else use link measurement
		else{
			// check whether the link length is length or time
			Link link = getLink(inst.getNetwork().getLinks().getLink(), head.getId(), tail.getId());
			if(link.getLength() != null){
				return link.getLength();
			}
			else if(link.getTime() != null){
				List<Object> timeContent = link.getTime().getContent();
				if(timeContent.get(0) != null) // NormalVariable
					return 0.0; // TODO link time NormalVariable
				else if(timeContent.get(0) != null) // PoissonVariable
					return 0.0; // TODO link time PoissonVariable
				else if(timeContent.get(0) != null) // Custom
					throw new MissingCustomElementException("link time");
				else // Standard value
					return Double.valueOf(timeContent.get(0).toString());
			}
			else if(link.getCustom() != null){
				throw new MissingCustomElementException("link");
			}
			else{
				throw new NullPointerException("Link element missing");
			}
		}

	}
	
	
	
	/**
	 * Calculates the distance between two nodes taking into account the speed profile of a vehicle
	 * @param inst Contains all the xml file
	 * @param head Head node
	 * @param tail Tail node
	 * @param sProfile Speed profile of vehicle 
	 * @return Distance between the nodes
	 * @throws Exception Throws exception if custom elements are found of if information is missing
	 */
	public static double getDistance(Instance inst, Node head, Node tail, SpeedProfile sProfile) throws Exception{
		// TODO GetDistance with speed profile
		return 0.0;
	}


	/**
	 * Calculate distance between two sets of euclidean points (2D or 3D). <br />
	 * Distance measurements usable are : Euclidean, Manhattan/Taxi cab and Geodesic
	 * @param head Euclidean coordinates of head node
	 * @param tail Euclidean coordinates of tail node
	 * @param distanceType String element defining distance measurement
	 * @return Distance between two nodes
	 * @throws Exception Throws exception if distance type is unknown
	 */
	public static double getEuclideanDist(Euclidean head, Euclidean tail, String distanceType) throws Exception{
		// check if 3D distance
		boolean is3D = false;
		if(head.getCz() != null && tail.getCz() != null){
			is3D = true;
		}else{
			is3D = false;
		}
		
		if(distanceType.equals("") || distanceType.contains("euclidean")){
			if(is3D){
				return Math.sqrt(Math.pow(head.getCx()-tail.getCx(), 2)+Math.pow(head.getCy()-tail.getCy(), 2)+Math.pow(head.getCz()-tail.getCz(), 2));
			}else{
				return Math.sqrt(Math.pow(head.getCx()-tail.getCx(), 2)+Math.pow(head.getCy()-tail.getCy(), 2));
			}
		}else if(!distanceType.equals("") && distanceType.contains("manhattan")){
			if(is3D){
				return Math.abs(head.getCx()-tail.getCx())+Math.abs(head.getCy()-tail.getCy())+Math.abs(head.getCz()-tail.getCz());
			}else{
				return Math.abs(head.getCx()-tail.getCx())+Math.abs(head.getCy()-tail.getCy());
			}
		}else if(!distanceType.equals("") && distanceType.contains("geodesic")){
			if(is3D){// TODO Geodesic distance
				return 0.0;
			}else{
				return 0.0;
			}
		}else{
			throw new Exception("Unknown distance type");
		}
	}

	
	/**
	 * Calculate distance between two sets of latitude and longitude points
	 * @param head GPS coordinates of head node
	 * @param tail GPS coordinates of tail node
	 * @return Distance between the nodes
	 */
	public static double getGPSDist(GPSCoordinates head, GPSCoordinates tail){
		double lon1 = degreeToRadian(head.getLon());
		double lon2 = degreeToRadian(tail.getLon());
		double lat1 = degreeToRadian(head.getLat());
		double lat2 = degreeToRadian(tail.getLat());
		double dlon = lon2 - lon1;
		double dlat = lat2 - lat1;
		double a = Math.pow(Math.sin(dlat/2), 2) + (Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlon/2), 2));
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		return 6373 * c;
		// TODO test and compare results with : http://andrew.hedges.name/experiments/haversine/ (may have to change earth raduis from km to m
	}
	
	
	/**
	 * 
	 * @param degree Degree value of GPS Coordinate
	 * @return Radian value of GPS Coordinate
	 */
	public static double degreeToRadian(double degree) {
		return degree * Math.PI/180;
	}
	

	/**
	 * Retrieve link from link list that corresponds to input nodes
	 * @param Links list of links
	 * @param headId Head node id
	 * @param tailId Tail node id
	 * @return Link if found, null otherwise
	 */
	public static Link getLink(List<Link> links, BigInteger headId, BigInteger tailId){
		Link temp = null;
		int i = 0;
		while(i < links.size()){
			temp = links.get(i++);
			if(temp.getHead() == headId && temp.getTail() == tailId)
				return temp;
		}
		return null;
	}



}
