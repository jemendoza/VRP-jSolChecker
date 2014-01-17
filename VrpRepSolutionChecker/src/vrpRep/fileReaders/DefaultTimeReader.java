package vrpRep.fileReaders;

import vrpRep.structure.instance.DoubleValue;
import vrpRep.structure.instance.Instance;

/**
 * 
 */

/**
 * 
 * Reads a single value time parameter.
 * 
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class DefaultTimeReader implements ITimeReader {

	/**
	 * @return result[0] = time
	 * @see vrpRep.fileReaders.ITimeReader#getLinkTime(vrpRep.structure.instance.Instance,
	 *      int, int)
	 */
	@Override
	public double[] getLinkTime(Instance instance, int head, int tail) {
		double[] result = new double[1];
		result[0] = ((DoubleValue) instance
				.getLinkAttribute(head, tail, "time").get(0)).getValue();
		return result;
	}

	/**
	 * @return result[0] = time
	 * @see vrpRep.fileReaders.ITimeReader#getRequestTime(vrpRep.structure.instance.Instance,
	 *      int)
	 */
	@Override
	public double[] getRequestTime(Instance instance, int id) {
		double[] result = new double[1];
		result[0] = ((DoubleValue) instance.getRequestAttribute(id,
				"serviceTime").get(0)).getValue();
		return result;
	}

}
