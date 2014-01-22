/**
 * 
 */
package vrpRep.utilities;

import java.util.List;

import vrpRep.exceptions.MissingAttributeException;
import vrpRep.factory.DynamicFactory;
import vrpRep.structure.instance.DoubleValue;
import vrpRep.structure.instance.Link;
import vrpRep.structure.instance.Node;

/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class DistanceCalculatorLink implements IDistanceCalculator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * vrpRep.utilities.IDistanceCalculator#calculDistance(vrpRep.structure.
	 * instance.Node, vrpRep.structure.instance.Node)
	 */
	@Override
	public double calculDistance(Node headNode, Node tailNode) {
		Link link = getLink(DynamicFactory.getFactory().getInstance()
				.getLinks(), headNode.getId(), tailNode.getId());
		try {
			if (link.getAttribute("length").get(0) != null) {
				return ((DoubleValue) link.getAttribute("lenght").get(0))
						.getValue();
			} else if (link.getAttribute("probabilityDistribution").get(0) != null) {
				// TODO probability distribution
				return 0;
			} else if (link.getAttribute("time").get(0) != null) {
				return ((DoubleValue) link.getAttribute("time").get(0))
						.getValue();
			}
		} catch (MissingAttributeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
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
}
