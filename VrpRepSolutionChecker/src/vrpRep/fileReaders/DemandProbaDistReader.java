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
 * Retrieves demand based on normal distribution
 * 
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class DemandProbaDistReader implements IDemandReader {

	@Override
	public List<DemandValue> getDemandValues(Instance instance, int id) {
		return null;
	}

	@Override
	public List<DemandProbaDist> getDemandDistributions(Instance instance,
			int id) {
		List<DemandProbaDist> result = new ArrayList<DemandProbaDist>();
		for (VrpAtt d : instance.getRequestAttribute(id, "demand")) {
			result.add((DemandProbaDist) d);
		}
		return result;
	}
}
