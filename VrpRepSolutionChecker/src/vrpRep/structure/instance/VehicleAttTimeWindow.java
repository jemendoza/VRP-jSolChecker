package vrpRep.structure.instance;

public class VehicleAttTimeWindow implements VehicleAtt {

	private double	begin;
	private double	end;
	private int		period;
	private boolean	isFlexBegin, isFlexEnd;

	public VehicleAttTimeWindow() {

	}

	/**
	 * @param begin
	 * @param end
	 * @param period
	 */
	public VehicleAttTimeWindow(double begin, double end, int period,
			boolean isFlexBegin, boolean isFlexEnd) {
		super();
		this.begin = begin;
		this.end = end;
		this.period = period;
		this.isFlexBegin = isFlexBegin;
		this.isFlexEnd = isFlexEnd;
	}

	public boolean isFlexBegin() {
		return isFlexBegin;
	}

	public boolean isFlexEnd() {
		return isFlexEnd;
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

}
