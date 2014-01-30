package vrpRep.structure.instance;

import java.util.ArrayList;
import java.util.List;

/**
 * Stores information related to the speed interval of a vehicle.
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 *
 */
public class SpeedInt implements VehicleAtt {
	/**
	 * Average speed during interval
	 */
	private double				speed;
	/**
	 * List of time windows where interval speed should be respected
	 */
	private List<TimeWindow>	tw;

	/**
	 * Default constructor
	 */
	public SpeedInt() {

	}

	/**
	 * Custom constructor
	 * @param speed average speed
	 */
	public SpeedInt(double speed) {
		super();
		this.speed = speed;
		this.tw = new ArrayList<TimeWindow>();
	}

	/**
	 * Custom constructor
	 * @param speed average speed
	 * @param tw list of time windows
	 */
	public SpeedInt(double speed, List<TimeWindow> tw) {
		super();
		this.speed = speed;
		this.tw = tw;
	}

	/**
	 * @return average speed
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
	 * @return list of time windows
	 */
	public List<TimeWindow> getTw() {
		return tw;
	}

	/**
	 * @param tw
	 *            new list of time windows
	 */
	public void addTw(TimeWindow tw) {
		this.tw.add(tw);
	}

}
