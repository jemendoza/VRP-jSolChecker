/**
 * 
 */
package vrpRep.utilities;

import java.util.List;

import vrpRep.exceptions.MissingAttributeException;
import vrpRep.exceptions.MissingElementException;
import vrpRep.factory.DynamicFactory;
import vrpRep.structure.instance.DoubleValue;
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
		try {
			Node headNode = DynamicFactory.getFactory().getInstance()
					.getNode(head);
			Node tailNode = DynamicFactory.getFactory().getInstance()
					.getNode(tail);
			Link link = getLink(DynamicFactory.getFactory().getInstance()
					.getLinks(), headNode.getId(), tailNode.getId());
			if (link.getAttribute("length").get(0) != null) {
				return ((DoubleValue) link.getAttribute("lenght").get(0))
						.getValue();
			} else {
				throw new MissingElementException("length");
			}
		} catch (MissingElementException e1) {
			e1.printStackTrace();
		} catch (MissingAttributeException e) {
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
