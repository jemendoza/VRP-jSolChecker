/**
 * 
 */
package vrpRep.fileReaders;

import vrpRep.structure.instance.Instance;

/**
 * Interface to help implementation of a time reader.
 * 
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public interface ITimeReader {

	/**
	 * Retrieve time from a link
	 * 
	 * @param instance
	 *            link to instance object
	 * @param head
	 *            head of link
	 * @param tail
	 *            tail of link
	 * @return a table containing the various location parameters depending on
	 *         location type.
	 */
	public double[] getLinkTime(Instance instance, int head, int tail);

	/**
	 * Retrieves service time from a request
	 * 
	 * @param instance
	 *            link to instance object
	 * @param id
	 *            id of element to retrieve time
	 * @return a table containing the various location parameters depending on
	 *         location type.
	 */
	public double[] getRequestTime(Instance instance, int id);

}
