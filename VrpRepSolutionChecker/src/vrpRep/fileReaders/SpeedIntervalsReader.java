/**
 * 
 */
package vrpRep.fileReaders;

import java.util.ArrayList;
import java.util.List;

import vrpRep.structure.instance.Instance;
import vrpRep.structure.instance.SpeedInt;
import vrpRep.structure.instance.VrpAtt;

/**
 * Reads the speed intervals of a vehicle
 * 
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class SpeedIntervalsReader implements ISpeedProfileReader {

	/**
	 * Retrieves speed intervals of a vehicle
	 * 
	 * @param instance
	 *            link to instance object
	 * @param id
	 *            id of vehicle
	 * @return List of vehicle's speed intervals
	 */
	public List<SpeedInt> getSpeed(Instance instance, int id) {
		List<SpeedInt> result = new ArrayList<SpeedInt>();
		for (VrpAtt sP : instance.getVehicleAttribute(id, "speedProfile")) {
			result.add((SpeedInt) sP);
		}
		return result;
	}
}
