/**
 * 
 */
package vrpRep.structure.instance;

/**
 * Stores all parameters related to the network.
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class Network {

	/**
	 * True if network is considered complete, false otherwise
	 */
	private boolean	isComplete;
	/**
	 * Name of distance type to be used for distance calculations
	 */
	private String	distanceType;
	/**
	 * Rounding rule to be used
	 */
	private String	roundingRule;

	/**
	 * Default constructor
	 */
	public Network() {

	}

	/**
	 * @return if is complete
	 */
	public boolean isComplete() {
		return isComplete;
	}

	/**
	 * @param isComplete
	 *            the new is complete parameter
	 */
	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}

	/**
	 * @return the distanceType
	 */
	public String getDistanceType() {
		return distanceType;
	}

	/**
	 * @param distanceType
	 *            the distanceType to set
	 */
	public void setDistanceType(String distanceType) {
		this.distanceType = distanceType;
	}

	/**
	 * @return the roundingRule
	 */
	public String getRoundingRule() {
		return roundingRule;
	}

	/**
	 * @param roundingRule
	 *            the roundingRule to set
	 */
	public void setRoundingRule(String roundingRule) {
		this.roundingRule = roundingRule;
	}

}
