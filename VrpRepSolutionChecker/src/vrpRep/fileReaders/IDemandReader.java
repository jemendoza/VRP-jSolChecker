/**
 * 
 */
package vrpRep.fileReaders;

import java.util.List;

import vrpRep.structure.instance.DemandProbaDist;
import vrpRep.structure.instance.DemandValue;
import vrpRep.structure.instance.Instance;

/**
 * Interface to encapsulate of demand reader.
 * 
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public interface IDemandReader {

	/**
	 * Retrieves demand for each product. <b>To be used for single value
	 * demand.</b> types.
	 * 
	 * @param instance
	 *            link to instance object
	 * @param id
	 *            id of request
	 * @return List of demands
	 */
	public List<DemandValue> getDemandValues(Instance instance, int id);

	/**
	 * Retrieves demand for each product. <b>To be used for demand probability
	 * distribution values.</b>
	 * 
	 * @param instance
	 *            link to instance object
	 * @param id
	 *            id of request
	 * @return List of demands
	 */
	public List<DemandProbaDist> getDemandDistributions(Instance instance,
			int id);

}
