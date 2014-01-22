package vrpRep.utilities;

import vrpRep.structure.instance.Node;

/**
 * 
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public interface IDistanceCalculator {

	/**
	 * 
	 * @param head
	 * @param tail
	 * @return
	 */
	public double calculDistance(Node headNode, Node tailNode);
}
