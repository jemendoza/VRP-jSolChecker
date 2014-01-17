/**
 * 
 */
package vrpRep.fileReaders;

import java.util.ArrayList;
import java.util.List;

import vrpRep.structure.instance.DemandValue;
import vrpRep.structure.instance.Instance;
import vrpRep.structure.instance.VrpAtt;

/**
 * Reads a list of demand values.
 * 
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class DefaultDemandReader implements IDemandReader {

	/**
	 * Retrieves demand for each product
	 * 
	 * @param instance
	 *            link to instance object
	 * @param id
	 *            id of request
	 * @return List of demands
	 */
	public List<DemandValue> getDemand(Instance instance, int id) {
		List<DemandValue> result = new ArrayList<DemandValue>();
		for (VrpAtt d : instance.getRequestAttribute(id, "demand")) {
			result.add((DemandValue) d);
		}
		return result;
	}

}
