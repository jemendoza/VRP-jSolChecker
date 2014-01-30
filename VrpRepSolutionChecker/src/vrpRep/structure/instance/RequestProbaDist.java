/**
 * 
 */
package vrpRep.structure.instance;

import java.util.ArrayList;
import java.util.List;

/**
 * Stores information related to a service time for a request following a probability distribution
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class RequestProbaDist implements RequestAttTime {
	/**
	 * List of moments
	 */
	private List<Moment>	moments;
	/**
	 * Name of distribution
	 */
	private String			name;

	
	/**
	 * Default constructor
	 */
	public RequestProbaDist() {
		moments = new ArrayList<Moment>();
	}
	
	/**
	 * Adds a moment to the distribution
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
	 * @return list of moments
	 */
	public List<Moment> getMoments() {
		return moments;
	}

	/**
	 * @param moments new list of moments
	 */
	public void setMoments(List<Moment> moments) {
		this.moments = moments;
	}

}
