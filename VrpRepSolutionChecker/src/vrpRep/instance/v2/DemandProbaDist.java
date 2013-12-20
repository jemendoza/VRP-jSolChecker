/**
 * 
 */
package vrpRep.instance.v2;

import java.util.List;

/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 *
 */
public class DemandProbaDist extends Demand {

	private List<Double> moments;
	
	public DemandProbaDist(){
	
	}
	
	public DemandProbaDist(int type, boolean isSplittable, List<Double> moments) {
		super(type, isSplittable);
		this.moments=moments;
		// TODO Auto-generated constructor stub
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
