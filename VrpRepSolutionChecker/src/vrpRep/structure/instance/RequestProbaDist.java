/**
 * 
 */
package vrpRep.structure.instance;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class RequestProbaDist implements RequestAttTime {
	private List<Moment>	moments;
	private String			name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public RequestProbaDist() {
		moments = new ArrayList<Moment>();
	}

	public void addMoment(String name, double value) {
		this.moments.add(new Moment(name, value));
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
