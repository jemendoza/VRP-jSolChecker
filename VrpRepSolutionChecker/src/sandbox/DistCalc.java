package sandbox;

public abstract class DistCalc {

	protected static DistCalc	myDC;

	static double calcDist(int tail, int head) {
		return myDC.calc(tail, head);
	}

	public abstract double calc(int tail, int head);

	public static void setDistCalc(DistCalc dC) {
		myDC = dC;
	}
}
