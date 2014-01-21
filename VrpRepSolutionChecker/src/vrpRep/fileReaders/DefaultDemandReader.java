/**
 * 
 */
package vrpRep.fileReaders;

import java.util.ArrayList;
import java.util.List;

import vrpRep.structure.instance.DemandProbaDist;
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

	@Override
	public List<DemandValue> getDemandValues(Instance instance, int id) {
		List<DemandValue> result = new ArrayList<DemandValue>();
		for (VrpAtt d : instance.getRequestAttribute(id, "demand")) {
			result.add((DemandValue) d);
		}
		return result;
	}

	@Override
	public List<DemandProbaDist> getDemandDistributions(Instance instance,
			int id) {
		return null;
	}

}
