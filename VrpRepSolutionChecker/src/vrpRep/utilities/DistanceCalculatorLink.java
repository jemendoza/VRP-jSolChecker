/**
 * 
 */
package vrpRep.utilities;

import java.util.List;

import vrpRep.structure.instance.DoubleValue;
import vrpRep.structure.instance.Instance;
import vrpRep.structure.instance.Link;
import vrpRep.structure.instance.Node;

/**
 * 
 * Returns the length of a link between two nodes
 * 
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class DistanceCalculatorLink extends DistanceCalculator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see vrpRep.utilities.DistanceCalculator#calculate(int, int)
	 */
	@Override
	public double calculate(int tail, int head) {
		Node headNode = Instance.getNode(head);
		Node tailNode = Instance.getNode(tail);
		Link link = getLink(Instance.getLinks(), headNode.getId(),
				tailNode.getId());
		if (link.getAttribute("length").get(0) != null) {
			return ((DoubleValue) link.getAttribute("lenght").get(0))
					.getValue();
		} else {
			return -1;
		}
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
