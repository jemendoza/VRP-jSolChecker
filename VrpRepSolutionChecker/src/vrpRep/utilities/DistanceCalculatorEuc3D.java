/**
 * 
 */
package vrpRep.utilities;

import vrpRep.exceptions.MissingAttributeException;
import vrpRep.factory.DynamicFactory;
import vrpRep.structure.instance.Euclidian;
import vrpRep.structure.instance.Node;

/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class DistanceCalculatorEuc3D implements IDistanceCalculator {

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
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * vrpRep.utilities.IDistanceCalculator#calculDistance(vrpRep.structure.
	 * instance.Node, vrpRep.structure.instance.Node)
	 */
	@Override
	public double calculDistance(Node headNode, Node tailNode) {
		String distanceType = DynamicFactory.getFactory().getInstance()
				.getNetwork().getDistanceType();
		Euclidian head, tail;

		try {
			head = (Euclidian) headNode.getAttribute("location").get(0);
			tail = (Euclidian) tailNode.getAttribute("location").get(0);
			if (distanceType.equals("") || distanceType.contains("euclidean")) {
				return Math.sqrt(Math.pow(head.getCx() - tail.getCx(), 2)
						+ Math.pow(head.getCy() - tail.getCy(), 2)
						+ Math.pow(head.getCz() - tail.getCz(), 2));
			} else if (!distanceType.equals("")
					&& distanceType.contains("manhattan")) {
				return Math.abs(head.getCx() - tail.getCx())
						+ Math.abs(head.getCy() - tail.getCy())
						+ Math.abs(head.getCz() - tail.getCz());
			} else if (!distanceType.equals("")
					&& distanceType.contains("geodesic")) {
				return 0.0;
			} else {
				throw new Exception("Unknown distance type");
			}
		} catch (MissingAttributeException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
