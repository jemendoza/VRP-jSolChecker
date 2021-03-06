package vrpRep.structure.instance;

/**
 * Stores structure of a time windows
 * 
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class TimeWindow implements VrpAtt {

	/**
	 * start of time window
	 */
	private double	begin;
	/**
	 * end of time window
	 */
	private double	end;
	/**
	 * periodicity of time window
	 */
	private int		period;
	/**
	 * is the start of time window hard
	 */
	private boolean	isHardStart;
	/**
	 * is the end of time window hard
	 */
	private boolean	isHardEnd;

	/**
	 * Default constructor. Creates an empty TimeWindow object.
	 */
	public TimeWindow() {
	}

	/**
	 * Custom constructor. Initializes constructor with all possible parameters
	 * 
	 * @param begin
	 *            start of time window
	 * @param end
	 *            end of time window
	 * @param period
	 *            periodicity of time window
	 * @param isHardStart
	 *            is the start of time window hard
	 * @param isHardEnd
	 *            is the end of time window hard
	 */
	public TimeWindow(double begin, double end, int period,
			boolean isHardStart, boolean isHardEnd) {
		super();
		this.begin = begin;
		this.end = end;
		this.period = period;
		this.isHardStart = isHardStart;
		this.isHardEnd = isHardEnd;
	}

	/**
	 * @return true is start if hard, false otherwise
	 */
	public boolean isFlexStart() {
		return isHardStart;
	}

	/**
	 * @return true is end if hard, false otherwise
	 */
	public boolean isFlexEnd() {
		return isHardEnd;
	}

	/**
	 * @return the begin
	 */
	public double getBegin() {
		return begin;
	}

	/**
	 * @param begin
	 *            the begin to set
	 */
	public void setBegin(double begin) {
		this.begin = begin;
	}

	/**
	 * @return the end
	 */
	public double getEnd() {
		return end;
	}

	/**
	 * @param end
	 *            the end to set
	 */
	public void setEnd(double end) {
		this.end = end;
	}

	/**
	 * @return the period
	 */
	public int getPeriod() {
		return period;
	}

	/**
	 * @param period
	 *            the period to set
	 */
	public void setPeriod(int period) {
		this.period = period;
	}

	/**
	 * 
	 * @return true if start of time window is hard, false otherwise
	 */
	public boolean isHardStart() {
		return isHardStart;
	}

	/**
	 * 
	 * @param isHardStart new hardness of start of time window
	 */
	public void setHardStart(boolean isHardStart) {
		this.isHardStart = isHardStart;
	}

	/**
	 * 
	 * @return true if end of time window is hard, false otherwise
	 */
	public boolean isHardEnd() {
		return isHardEnd;
	}

	/**
	 * 
	 * @param isHardEnd new hardness of end of time window
	 */
	public void setHardEnd(boolean isHardEnd) {
		this.isHardEnd = isHardEnd;
	}

}
