/**
 * 
 */
package vrpRep.fileReaders;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;

import javax.xml.bind.JAXBException;

import vrpRep.instance.v2.BooleanValue;
import vrpRep.instance.v2.DemandProbaDist;
import vrpRep.instance.v2.DemandValue;
import vrpRep.instance.v2.DoubleValue;
import vrpRep.instance.v2.Euclidian;
import vrpRep.instance.v2.GPS;
import vrpRep.instance.v2.Instance;
import vrpRep.instance.v2.IntValue;
import vrpRep.instance.v2.Link;
import vrpRep.instance.v2.LinkProbaDist;
import vrpRep.instance.v2.Network;
import vrpRep.instance.v2.Node;
import vrpRep.instance.v2.Request;
import vrpRep.instance.v2.RequestProbaDist;
import vrpRep.instance.v2.RequestTimeWindow;
import vrpRep.instance.v2.SpeedInt;
import vrpRep.instance.v2.SpeedIntTimeWindow;
import vrpRep.instance.v2.Vehicle;
import vrpRep.schema.instance.ProbabilityDistribution;
import vrpRep.utilities.XmlReader;

/**
 * Class used to store XML instance data.
 * 
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class InstanceReader {

	/**
	 * Master node containing all xml file info
	 */
	private vrpRep.schema.instance.Instance	schemaInstance;
	private Instance						instance;

	/**
	 * Constructor that creates xml tree on class instantiation
	 * 
	 * @param xmlFile
	 *            xml file to extract
	 */
	public InstanceReader(File xmlFile) {
		try {
			XmlReader<vrpRep.schema.instance.Instance> iR = new XmlReader<vrpRep.schema.instance.Instance>();
			this.schemaInstance = iR.unmarshallDocument(xmlFile,
					vrpRep.schema.instance.Instance.class.getName());
			this.instance = new Instance();
		} catch (ClassNotFoundException | JAXBException | IOException e) {
			e.printStackTrace();
		}
	}

	private void translateInstance() {
		networkTransformation();
		nodeTransformation();
		linkTransformation();
		vehicleTransformation();
		requestTransformation();
	}

	private void requestTransformation() {
		for (vrpRep.schema.instance.Instance.Requests.Request r : schemaInstance
				.getRequests().getRequest()) {
			Request temp = new Request(r.getId().intValue());
			// Attributes
			if (r.getType() != null)
				temp.add("type", new IntValue(r.getType().intValue()));
			if (r.getNode() != null)
				temp.add("node", new IntValue(r.getNode().intValue()));
			if (r.getLink() != null)
				temp.add("link", new IntValue(r.getLink().intValue()));
			// Elements
			if (r.getTw() != null) {
				for (vrpRep.schema.instance.Tw tw : r.getTw()) {
					RequestTimeWindow rtw = new RequestTimeWindow();
					if (tw.getPeriod() != null)
						rtw.setPeriod(tw.getPeriod().intValue());
					if (tw.getStart() != null)
						rtw.setBegin(Double.valueOf(tw.getStart().getContent()));
					if (tw.getEnd() != null)
						rtw.setEnd(Double.valueOf(tw.getEnd().getContent()));
					rtw.setHardStart(tw.getStart().isIsHard());
					rtw.setHardEnd(tw.getEnd().isIsHard());
					temp.add("tw", rtw);
				}
			}
			if (r.getDemand() != null) {
				for (vrpRep.schema.instance.Demand d : r.getDemand()) {
					if (d.getContent().size() == 1)
						temp.add(
								"demand",
								new DemandValue(d.getType().intValue(), d
										.isIsSplitable(),
										Double.valueOf((String) d.getContent()
												.get(0))));
					if (d.getContent().size() == 3) {
						DemandProbaDist dpd = new DemandProbaDist();
						ProbabilityDistribution pd = (ProbabilityDistribution) d
								.getContent().get(1);
						dpd.setName(pd.getName());
						for (vrpRep.schema.instance.ProbabilityDistribution.Moment m : pd
								.getMoment()) {
							dpd.addMoment(m.getName(), m.getValue());
						}
						temp.add("demand", dpd);
					}
				}
			}
			if (r.getPrize() != null)
				temp.add("price", new DoubleValue(r.getPrize().doubleValue()));
			if (r.getCost() != null)
				temp.add("cost", new DoubleValue(r.getCost().doubleValue()));
			if (r.getReleaseDate() != null)
				temp.add("releaseDate", new DoubleValue(r.getReleaseDate()
						.doubleValue()));
			if (r.getServiceTime() != null
					&& r.getServiceTime().getContent().size() == 1)
				temp.add(
						"serviceTime",
						new DoubleValue(Double.valueOf((String) r
								.getServiceTime().getContent().get(0))));
			if (r.getServiceTime() != null
					&& r.getServiceTime().getContent().size() == 3) {
				RequestProbaDist rpd = new RequestProbaDist();
				ProbabilityDistribution pd = (ProbabilityDistribution) r
						.getServiceTime().getContent().get(1);
				rpd.setName(pd.getName());
				for (vrpRep.schema.instance.ProbabilityDistribution.Moment m : pd
						.getMoment()) {
					rpd.addMoment(m.getName(), m.getValue());
				}
				temp.add("probabilityDistribution", rpd);
			}
			if (r.getPredecessors() != null) {
				for (BigInteger prec : r.getPredecessors().getRequest()) {
					temp.add("predecessor", new IntValue(prec.intValue()));
				}
			}
			if (r.getSuccessors() != null) {
				for (BigInteger prec : r.getSuccessors().getRequest()) {
					temp.add("successor", new IntValue(prec.intValue()));
				}
			}
			// TODO : Skill & Tool
		}
	}

	private void vehicleTransformation() {
		int i = 0;
		for (vrpRep.schema.instance.Instance.Fleet.Vehicle v : schemaInstance
				.getFleet().getVehicle()) {
			Vehicle temp = new Vehicle(i);
			temp.add("type", new IntValue(v.getType().intValue()));
			if (v.getFixedCost() != null) {
				for (double d : v.getFixedCost())
					temp.add("fixedCost", new DoubleValue(d));
			}
			if (v.getVariableCost() != null) {
				for (double d : v.getVariableCost())
					temp.add("variableCost", new DoubleValue(d));
			}
			if (v.getNumber() != null)
				temp.add("number", new IntValue(v.getNumber().intValue()));

			if (v.getNodeTypesCompatible() != null) {
				for (BigInteger compatible : v.getNodeTypesCompatible()) {
					temp.add("nodeTypesCompatible",
							new IntValue(compatible.intValue()));
				}
			}
			if (v.getSpeedProfile() != null) {
				if (v.getSpeedProfile().getAvg() != null)
					temp.add("speedProfile", new DoubleValue(v
							.getSpeedProfile().getAvg()));
				else {
					SpeedInt speed;
					SpeedIntTimeWindow time;
					for (vrpRep.schema.instance.SpeedProfile.SpeedInterval s : v
							.getSpeedProfile().getSpeedInterval()) {
						speed = new SpeedInt(s.getSpeed());
						for (vrpRep.schema.instance.Tw tw : s.getTw()) {
							time = new SpeedIntTimeWindow(Double.valueOf(tw
									.getStart().getContent()),
									Double.valueOf(tw.getEnd().getContent()),
									tw.getPeriod().intValue(), tw.getStart()
											.isIsHard(), tw.getEnd().isIsHard());
							speed.addTw(time);
						}
					}
				}
			}
			if (v.getMaxTravelDistance() != null) {
				temp.add(
						"maxTravelDistance",
						new DoubleValue(Double.valueOf(v.getMaxTravelDistance()
								.getContent())));
				temp.add("maxTravelDistanceIsFlexible", new BooleanValue(v
						.getMaxTravelDistance().isIsFlexible()));
			}
			if (v.getMaxRequests() != null) {
				temp.add(
						"maxRequests",
						new DoubleValue(Double.valueOf(v.getMaxRequests()
								.getContent())));
				temp.add("maxRequestsIsFlexible", new BooleanValue(v
						.getMaxRequests().isIsFlexible()));
			}
			if (v.getCapacity() != null) {
				for (Double d : v.getCapacity()) {
					temp.add("capacity", new DoubleValue(d));
				}
			}
			if (v.getCompartment() != null) {
				for (BigInteger compatible : v.getNodeTypesCompatible()) {
					temp.add("nodeTypesCompatible",
							new IntValue(compatible.intValue()));
				}
			}
			i++;
		}
		// TODO From WorkLoadProfile to the end

	}

	private void linkTransformation() {
		for (vrpRep.schema.instance.Instance.Network.Links.Link l : schemaInstance
				.getNetwork().getLinks().getLink()) {
			Link temp = new Link(l.getTail().intValue(), l.getHead().intValue());
			// Attributes
			if (l.getId() != null)
				temp.addAttribute("id", new IntValue(l.getId().intValue()));
			temp.addAttribute("directed", new BooleanValue(l.isDirected()));
			if (l.getType() != null)
				temp.addAttribute("type", new IntValue(l.getType().intValue()));
			// Elements
			if (l.getCost() != null)
				temp.addAttribute("cost", new DoubleValue(l.getCost()));
			if (l.getLength() != null)
				temp.addAttribute("length", new DoubleValue(l.getLength()));
			if (l.getTime() != null && l.getTime().getContent().size() == 1)
				temp.addAttribute(
						"time",
						new DoubleValue(Double.valueOf((String) l.getTime()
								.getContent().get(0))));
			if (l.getTime() != null && l.getTime().getContent().size() == 3) {
				LinkProbaDist lpd = new LinkProbaDist();
				ProbabilityDistribution pd = (ProbabilityDistribution) l
						.getTime().getContent().get(1);
				lpd.setName(pd.getName());
				for (vrpRep.schema.instance.ProbabilityDistribution.Moment m : pd
						.getMoment()) {
					lpd.addMoment(m.getName(), m.getValue());
				}
				temp.addAttribute("probabilityDistribution", lpd);
			}
			this.instance.addLink(temp);
		}
	}

	private void nodeTransformation() {
		for (vrpRep.schema.instance.Instance.Network.Nodes.Node n : schemaInstance
				.getNetwork().getNodes().getNode()) {
			Node temp = new Node(n.getId().intValue());
			if (n.getType() != null)
				temp.addAttribute("type", new IntValue(n.getType().intValue()));
			if (n.getLocation() != null) {
				if (n.getLocation().getEuclidean() != null) {
					Euclidian euclidian = new Euclidian(n.getLocation()
							.getEuclidean().getCx(), n.getLocation()
							.getEuclidean().getCy(), n.getLocation()
							.getEuclidean().getCz());
					temp.addAttribute("location", euclidian);
				}
				if (n.getLocation().getGPSCoordinates() != null) {
					GPS gps = new GPS(n.getLocation().getGPSCoordinates()
							.getLat(), n.getLocation().getGPSCoordinates()
							.getLon());
					temp.addAttribute("location", gps);
				}
			}
			instance.addNode(temp);
		}
	}

	private void networkTransformation() {
		Network n = instance.getNetwork();
		if (schemaInstance.getNetwork().getDescriptor().isIsComplete() != null)
			n.setComplete(schemaInstance.getNetwork().getDescriptor()
					.isIsComplete());
		if (schemaInstance.getNetwork().getDescriptor().getDistanceType() != null)
			n.setDistanceType(schemaInstance.getNetwork().getDescriptor()
					.getDistanceType());
		if (schemaInstance.getNetwork().getDescriptor().getRoundingRule() != null)
			n.setRoundingRule(schemaInstance.getNetwork().getDescriptor()
					.getRoundingRule());
	}

}