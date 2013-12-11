/**
 * 
 */
package vrpRep.instance.v2;

import java.util.List;

/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 *
 */
public class RequestProbaDist implements RequestAttTime {
	private List<Double> moments;

	/**
	 * @param moments
	 */
	public RequestProbaDist(List<Double> moments) {
		super();
		this.moments = moments;
	}

	/**
	 * @return the moments
	 */
	public List<Double> getMoments() {
		return moments;
	}

	/**
	 * @param moments the moments to set
	 */
	public void setMoments(List<Double> moments) {
		this.moments = moments;
	}
	
	
	
}
