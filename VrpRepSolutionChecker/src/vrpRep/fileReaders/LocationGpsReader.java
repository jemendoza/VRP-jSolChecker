/**
 * 
 */
package vrpRep.fileReaders;

import vrpRep.structure.instance.Instance;

/**
 * Reads a GPS location
 * 
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class LocationGpsReader implements ILocationReader {

	/**
	 * @return result[0] = latitude, result[1] = longitude
	 * @see vrpRep.fileReaders.ILocationReader#getLocation(Instance, int)
	 */
	@Override
	public double[] getLocation(Instance instance, int nodeId) {
		double[] result = new double[2];
		vrpRep.structure.instance.GPS g = (vrpRep.structure.instance.GPS) instance
				.getNodeAttribute(nodeId, "location").get(0);
		result[0] = g.getLat();
		result[1] = g.getLon();
		return result;
	}
}
