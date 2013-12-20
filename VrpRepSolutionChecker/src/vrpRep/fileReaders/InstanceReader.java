/**
 * 
 */
package vrpRep.fileReaders;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBException;

import vrpRep.instance.v2.BooleanValue;
import vrpRep.instance.v2.DoubleValue;
import vrpRep.instance.v2.Euclidian;
import vrpRep.instance.v2.GPS;
import vrpRep.instance.v2.Instance;
import vrpRep.instance.v2.IntValue;
import vrpRep.instance.v2.Link;
import vrpRep.instance.v2.LinkProbaDist;
import vrpRep.instance.v2.Network;
import vrpRep.instance.v2.Node;
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
		// TODO Auto-generated method stub

	}

	private void vehicleTransformation() {
		// TODO Auto-generated method stub

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

			}
		}
	}

	private void nodeTransformation() {
		for (vrpRep.schema.instance.Instance.Network.Nodes.Node n : schemaInstance
				.getNetwork().getNodes().getNode()) {
			Node temp = new Node(n.getId().intValue());
			if (n.getType() != null)
				temp.addAttribute("Type", new IntValue(n.getType().intValue()));
			if (n.getLocation() != null) {
				if (n.getLocation().getEuclidean() != null) {
					Euclidian euclidian = new Euclidian(n.getLocation()
							.getEuclidean().getCx(), n.getLocation()
							.getEuclidean().getCy(), n.getLocation()
							.getEuclidean().getCz());
					temp.addAttribute("Location", euclidian);
				}
				if (n.getLocation().getGPSCoordinates() != null) {
					GPS gps = new GPS(n.getLocation().getGPSCoordinates()
							.getLat(), n.getLocation().getGPSCoordinates()
							.getLon());
					temp.addAttribute("Location", gps);
				}
			}
			instance.getNodes().add(temp);
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