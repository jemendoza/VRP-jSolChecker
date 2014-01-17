package vrpRep.structure.instance;

import java.util.ArrayList;
import java.util.List;

public class SpeedInt implements VehicleAtt {
	private double						speed;
	private List<SpeedIntTimeWindow>	tw;

	public SpeedInt() {

	}

	/**
	 * @param speed
	 */
	public SpeedInt(double speed) {
		super();
		this.speed = speed;
		this.tw = new ArrayList<SpeedIntTimeWindow>();
	}

	/**
	 * @param speed
	 * @param tw
	 */
	public SpeedInt(double speed, List<SpeedIntTimeWindow> tw) {
		super();
		this.speed = speed;
		this.tw = tw;
	}

	/**
	 * @return the speed
	 */
	public double getSpeed() {
		return speed;
	}

	/**
	 * @param speed
	 *            the speed to set
	 */
	public void setSpeed(double speed) {
		this.speed = speed;
	}

	/**
	 * @return the tw
	 */
	public List<SpeedIntTimeWindow> getTw() {
		return tw;
	}

	/**
	 * @param tw
	 *            the tw to set
	 */
	public void addTw(SpeedIntTimeWindow tw) {
		this.tw.add(tw);
	}

}
