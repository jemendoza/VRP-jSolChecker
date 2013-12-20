/**
 * 
 */
package vrpRep.instance.v2;

import java.util.List;

/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class SpeedProfile implements VehicleAtt {

	private List<SpeedInt>	ints;

	public SpeedProfile() {

	}

	/**
	 * @param ints
	 */
	public SpeedProfile(List<SpeedInt> ints) {
		super();
		this.ints = ints;
	}

	/**
	 * @return the ints
	 */
	public List<SpeedInt> getInts() {
		return ints;
	}

	/**
	 * @param ints
	 *            the ints to set
	 */
	public void setInts(List<SpeedInt> ints) {
		this.ints = ints;
	}

}
