/**
 * 
 */
package vrpRep.fileReaders;

import vrpRep.schema.instance.Location.Euclidean;
import vrpRep.structure.instance.Instance;

/**
 * Reads a euclidean 3D location
 * 
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class LocationEuc3DReader implements ILocationReader {

	/**
	 * @return result[0] = xCoord, result[1] = yCoord, result[3] = zCoord
	 * @see vrpRep.fileReaders.ILocationReader#getLocation(Instance, int)
	 */
	@Override
	public double[] getLocation(Instance instance, int nodeId) {
		double[] result = new double[3];
		Euclidean e = (Euclidean) instance.getNodeAttribute(nodeId, "location")
				.get(0);
		result[0] = e.getCx();
		result[1] = e.getCy();
		result[2] = e.getCz();
		return result;
	}

}
