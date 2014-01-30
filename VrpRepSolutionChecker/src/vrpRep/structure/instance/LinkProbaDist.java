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
	private List<Moment>	moments;
	private String			name;

	public LinkProbaDist() {
		moments = new ArrayList<Moment>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param moments
	 */
	public LinkProbaDist(List<Moment> moments) {
		super();
		this.moments = moments;
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

	public void addMoment(String name, double value) {
		this.moments.add(new Moment(name, value));
	}

}
