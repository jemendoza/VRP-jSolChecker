/**
 * 
 */
package vrpRep.fileReaders;

import vrpRep.structure.instance.Instance;

/**
 * Interface to help implementation of a location reader.
 * 
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public interface ILocationReader {

	/**
	 * @param instance
	 *            link to instance object
	 * @param nodeId
	 *            id of node location requested
	 * @return a table containing the various location parameters depending on
	 *         location type.
	 */
	public double[] getLocation(Instance instance, int nodeId);
}
