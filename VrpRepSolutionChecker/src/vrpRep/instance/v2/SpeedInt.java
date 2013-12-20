package vrpRep.instance.v2;

public class SpeedInt {
	private double				speed;
	private SpeedIntTimeWindow	tw;

	public SpeedInt() {

	}

	/**
	 * @param speed
	 * @param tw
	 */
	public SpeedInt(double speed, SpeedIntTimeWindow tw) {
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
	public SpeedIntTimeWindow getTw() {
		return tw;
	}

	/**
	 * @param tw
	 *            the tw to set
	 */
	public void setTw(SpeedIntTimeWindow tw) {
		this.tw = tw;
	}

}
