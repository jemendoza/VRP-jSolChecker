/**
 * 
 */
package vrpRep.fileReaders;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;

import javax.xml.bind.JAXBException;

import vrpRep.schema.instance.ProbabilityDistribution;
import vrpRep.schema.instance.Skill;
import vrpRep.schema.instance.Tool;
import vrpRep.structure.instance.BooleanValue;
import vrpRep.structure.instance.Compartment;
import vrpRep.structure.instance.DemandProbaDist;
import vrpRep.structure.instance.DemandValue;
import vrpRep.structure.instance.DoubleValue;
import vrpRep.structure.instance.Euclidian;
import vrpRep.structure.instance.GPS;
import vrpRep.structure.instance.Instance;
import vrpRep.structure.instance.IntValue;
import vrpRep.structure.instance.Link;
import vrpRep.structure.instance.LinkProbaDist;
import vrpRep.structure.instance.Network;
import vrpRep.structure.instance.Node;
import vrpRep.structure.instance.Request;
import vrpRep.structure.instance.RequestProbaDist;
import vrpRep.structure.instance.SkillAndTool;
import vrpRep.structure.instance.SpeedInt;
import vrpRep.structure.instance.TimeWindow;
import vrpRep.structure.instance.Vehicle;

/**
 * Class used to translate an instance from the VRPREP schema structure to the
 * universal SolutionReader structure.
 * 
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class InstanceTranslator {

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
	public InstanceTranslator(File xmlFile) {
		try {
			XmlSchemaReader<vrpRep.schema.instance.Instance> iR = new XmlSchemaReader<vrpRep.schema.instance.Instance>();
			this.schemaInstance = iR.unmarshallDocument(xmlFile,
					vrpRep.schema.instance.Instance.class.getName());
			this.instance = new Instance();
			this.translateInstance();
		} catch (ClassNotFoundException | JAXBException | IOException e) {
			e.printStackTrace();
		}
	}

	public Instance getInstance() {
		return instance;
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
					TimeWindow rtw = new TimeWindow();
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
					if (d.getContent().size() == 1) {
						DemandValue dv = new DemandValue();
						dv.setSplittable(d.isIsSplitable());
						if (d.getType() != null)
							dv.setType(d.getType().intValue());
						dv.setValue(Double.valueOf((String) d.getContent().get(
								0)));
						temp.add("demand", dv);
					}

					if (d.getContent().size() == 3) {
						DemandProbaDist dpd = new DemandProbaDist();
						dpd.setSplittable(d.isIsSplitable());
						if (d.getType() != null)
							dpd.setType(d.getType().intValue());
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
				temp.add("prize", new DoubleValue(r.getPrize().doubleValue()));
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
				temp.add("serviceTime", rpd);
			}
			if (r.getPredecessors() != null) {
				for (BigInteger prec : r.getPredecessors().getRequest()) {
					temp.add("predecessor", new IntValue(prec.intValue()));
				}
			}
			if (r.getSuccessors() != null) {
				for (BigInteger succ : r.getSuccessors().getRequest()) {
					temp.add("successor", new IntValue(succ.intValue()));
				}
			}
			if (r.getSkill() != null) {
				for (Skill s : r.getSkill()) {
					SkillAndTool sat = new SkillAndTool();
					sat.setId(s.getId().intValue());
					sat.setValue(Integer.valueOf(s.getContent()));
					temp.add("skill", sat);
				}
			}
			if (r.getTool() != null) {
				for (Tool t : r.getTool()) {
					SkillAndTool sat = new SkillAndTool();
					sat.setId(t.getId().intValue());
					sat.setValue(Integer.valueOf(t.getContent()));
					temp.add("tool", sat);
				}
			}
			this.instance.addRequest(temp);
		}
	}

	private void vehicleTransformation() {
		for (vrpRep.schema.instance.Instance.Fleet.Vehicle v : schemaInstance
				.getFleet().getVehicle()) {
			Vehicle temp = new Vehicle();
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
					TimeWindow time;
					for (vrpRep.schema.instance.SpeedProfile.SpeedInterval s : v
							.getSpeedProfile().getSpeedInterval()) {
						speed = new SpeedInt(s.getSpeed());
						for (vrpRep.schema.instance.Tw tw : s.getTw()) {
							time = new TimeWindow(Double.valueOf(tw.getStart()
									.getContent()), Double.valueOf(tw.getEnd()
									.getContent()), tw.getPeriod().intValue(),
									tw.getStart().isIsHard(), tw.getEnd()
											.isIsHard());
							speed.addTw(time);
						}
						temp.add("speedProfile", speed);
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
			if (v.getWorkloadProfile() != null) {
				if (v.getWorkloadProfile().getMaxWorkTime() != null) {
					temp.add(
							"wLPMaxWorkTime",
							new DoubleValue(Double.valueOf(v
									.getWorkloadProfile().getMaxWorkTime()
									.getContent())));
					temp.add("wLPMaxWorkTimeIsFlexible", new BooleanValue(v
							.getWorkloadProfile().getMaxWorkTime()
							.isIsFlexible()));
				}
				if (v.getWorkloadProfile().getTw() != null) {
					TimeWindow tw;
					for (vrpRep.schema.instance.Tw timew : v
							.getWorkloadProfile().getTw()) {
						tw = new TimeWindow(Double.valueOf(timew.getStart()
								.getContent()), Double.valueOf(timew.getEnd()
								.getContent()), timew.getPeriod().intValue(),
								timew.getStart().isIsHard(), timew.getEnd()
										.isIsHard());
						temp.add("vLPtw", tw);
					}
				}
			}
			if (v.getCapacity() != null) {
				for (Double d : v.getCapacity()) {
					temp.add("capacity", new DoubleValue(d));
				}
			}
			if (v.getCompartment() != null) {
				for (vrpRep.schema.instance.Compartment compartment : v
						.getCompartment()) {
					if (compartment.getFixed() != null)
						temp.add("compartment", new Compartment(compartment
								.getType().intValue(), compartment.getFixed(),
								compartment.getFixed()));
					else
						temp.add(
								"compartment",
								new Compartment(compartment.getType()
										.intValue(), compartment
										.getMinCapacity(), compartment
										.getMaxCapacity()));

				}
			}
			if (v.getDepartureNode() != null) {
				temp.add("departureNode", new IntValue(v.getDepartureNode()
						.intValue()));
			}
			if (v.getArrivalNode() != null) {
				temp.add("arrivalNode", new IntValue(v.getArrivalNode()
						.intValue()));
			}
			if (v.getSkill() != null) {
				for (Skill s : v.getSkill()) {
					SkillAndTool sat = new SkillAndTool();
					sat.setId(s.getId().intValue());
					sat.setValue(Integer.valueOf(s.getContent()));
					temp.add("skill", sat);
				}
			}
			if (v.getTool() != null) {
				for (Tool t : v.getTool()) {
					SkillAndTool sat = new SkillAndTool();
					sat.setId(t.getId().intValue());
					sat.setValue(Integer.valueOf(t.getContent()));
					temp.add("tool", sat);
				}
			}
			this.instance.addFleet(temp);
		}
	}

	private void linkTransformation() {
		for (vrpRep.schema.instance.Instance.Network.Links.Link l : schemaInstance
				.getNetwork().getLinks().getLink()) {
			Link temp = new Link(l.getTail().intValue(), l.getHead().intValue());
			// Attributes
			if (l.getId() != null)
				temp.addAttribute("id", new IntValue(l.getId().intValue()));
			temp.addAttribute("tail", new IntValue(l.getTail().intValue()));
			temp.addAttribute("head", new IntValue(l.getHead().intValue()));
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