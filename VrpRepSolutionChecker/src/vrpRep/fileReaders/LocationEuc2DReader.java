/**
 * 
 */
package vrpRep.fileReaders;

import vrpRep.schema.instance.Location.Euclidean;
import vrpRep.structure.instance.Instance;

/**
 * Reads a euclidean 2D location
 * 
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class LocationEuc2DReader implements ILocationReader {

	/**
	 * @return result[0] = xCoord, result[1] = yCoord
	 * @see vrpRep.fileReaders.ILocationReader#getLocation(Instance, int)
	 */
	@Override
	public double[] getLocation(Instance instance, int nodeId) {
		double[] result = new double[2];
		Euclidean e = (Euclidean) instance.getNodeAttribute(nodeId, "location")
				.get(0);
		result[0] = e.getCx();
		result[1] = e.getCy();
		return result;
	}
}
