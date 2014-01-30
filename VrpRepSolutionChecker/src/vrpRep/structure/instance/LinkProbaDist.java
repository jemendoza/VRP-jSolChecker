/**
 * 
 */
package vrpRep.structure.instance;

import java.util.ArrayList;
import java.util.List;

/**
 * Stores information related to link travel time that follows a probability distribution
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class LinkProbaDist implements LinkAttTime {
	/**
	 * List of moments within distribution
	 */
	private List<Moment>	moments;
	/**
	 * Name of distribution
	 */
	private String			name;

	/**
	 * Default constructor
	 */
	public LinkProbaDist() {
		moments = new ArrayList<Moment>();
	}
	
	/**
	 * Custom constructor
	 * @param moments list of moments
	 */
	public LinkProbaDist(List<Moment> moments) {
		super();
		this.moments = moments;
	}

	/**
	 * Add a moment to the distribution
	 * @param name name of moment
	 * @param value value of moment
	 * @see vrpRep.structure.instance.Moment
	 */
	public void addMoment(String name, double value) {
		this.moments.add(new Moment(name, value));
	}
	
	/**
	 * 
	 * @return name of distribution
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name new name of distribution
	 */
	public void setName(String name) {
		this.name = name;
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
