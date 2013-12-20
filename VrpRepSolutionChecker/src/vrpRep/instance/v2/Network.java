/**
 * 
 */
package vrpRep.instance.v2;

/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 *
 */
public class Network {

	private boolean isComplete;
	private int distanceType;
	private String roundingRule;
	
	
	
	
	public Network(){
		
	}
	
	
	/**
	 * @return the isComplete
	 */
	public boolean isComplete() {
		return isComplete;
	}
	/**
	 * @param isComplete the isComplete to set
	 */
	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}
	/**
	 * @return the distanceType
	 */
	public int getDistanceType() {
		return distanceType;
	}
	/**
	 * @param distanceType the distanceType to set
	 */
	public void setDistanceType(int distanceType) {
		this.distanceType = distanceType;
	}
	/**
	 * @return the roundingRule
	 */
	public String getRoundingRule() {
		return roundingRule;
	}
	/**
	 * @param roundingRule the roundingRule to set
	 */
	public void setRoundingRule(String roundingRule) {
		this.roundingRule = roundingRule;
	}
	
	
}
