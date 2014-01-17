/**
 * 
 */
package vrpRep.fileReaders;

import vrpRep.structure.instance.Instance;
import vrpRep.structure.instance.LinkProbaDist;

/**
 * 
 * Reads a normal distribution time value
 * 
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class TimeNormalDistReader implements ITimeReader {

	/**
	 * @return result[0] = mean, result[1] = variance
	 * @see vrpRep.fileReaders.ITimeReader#getLinkTime(vrpRep.structure.instance.Instance,
	 *      int, int)
	 */
	@Override
	public double[] getLinkTime(Instance instance, int head, int tail) {
		double[] result = new double[1];
		result[0] = ((LinkProbaDist) instance.getLinkAttribute(head, tail,
				"time").get(0)).getMoments().get(0).getValue();
		result[1] = ((LinkProbaDist) instance.getLinkAttribute(head, tail,
				"time").get(0)).getMoments().get(1).getValue();
		return result;
	}

	/**
	 * @return result[0] = mean, result[1] = variance
	 * @see vrpRep.fileReaders.ITimeReader#getRequestTime(vrpRep.structure.instance.Instance,
	 *      int)
	 */
	@Override
	public double[] getRequestTime(Instance instance, int id) {
		double[] result = new double[1];
		result[0] = ((LinkProbaDist) instance.getRequestAttribute(id,
				"serviceTime").get(0)).getMoments().get(0).getValue();
		result[1] = ((LinkProbaDist) instance.getRequestAttribute(id,
				"serviceTime").get(0)).getMoments().get(1).getValue();
		return result;
	}

}
