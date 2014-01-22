package vrpRep.utilities;

/**
 * Class used to implement and access distance calculator
 * 
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public abstract class DistanceCalculator {

	/**
	 * Object of current instance
	 */
	protected static DistanceCalculator	myDC;

	/**
	 * Calculate distance between two nodes
	 * 
	 * @param tail
	 *            id of tail node
	 * @param head
	 *            id of head node
	 * @return distance between two nodes
	 */
	static double calculateDistance(int tail, int head) {
		return myDC.calculate(tail, head);
	}

	/**
	 * Calculate distance between two nodes
	 * 
	 * @param tail
	 *            id of tail node
	 * @param head
	 *            id of head node
	 * @return distance between two nodes
	 */
	public abstract double calculate(int tail, int head);

	/**
	 * Set new distance calculator
	 * 
	 * @param dC
	 *            new distance calculator
	 */
	public static void setDistanceCalculator(DistanceCalculator dC) {
		myDC = dC;
	}
}
