/**
 * 
 */
package vrpRep.structure.instance;

import java.util.ArrayList;
import java.util.List;

/**
 * Stores information related to a demand based on a probability distribution
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class DemandProbaDist extends Demand {

	/**
	 * List of moments
	 */
	private List<Moment>	moments;
	/**
	 * Name of probability distribution
	 */
	private String			name;

	
	/**
	 * Custom constructor
	 * @param type 
	 * @param isSplittable
	 */
	public DemandProbaDist(int type, boolean isSplittable) {
		super(type, isSplittable);
		this.moments = new ArrayList<Moment>();
	}
	
	/**
	 * Adds a moment to the distribution
	 * @param name name of the moment
	 * @param value value of the moment
	 * @see vrpRep.structure.instance.Moment
	 */
	public void addMoment(String name, double value) {
		this.moments.add(new Moment(name, value));
	}


	/**
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name new name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * List of moments
	 */
	public DemandProbaDist() {
		this.moments = new ArrayList<Moment>();
	}

	/**
	 * @return the moments
	 */
	public List<Moment> getMoments() {
		return moments;
	}

	/**
	 * @param moments
	 *            the moments to set
	 */
	public void setMoments(List<Moment> moments) {
		this.moments = moments;
	}

}
