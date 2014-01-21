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

	@Override
	public double getAverageSpeed(Instance instance, int id) {
		return 0;
	}

	@Override
	public List<SpeedInt> getSpeedIntervals(Instance instance, int id) {
		List<SpeedInt> result = new ArrayList<SpeedInt>();
		for (VrpAtt sP : instance.getVehicleAttribute(id, "speedProfile")) {
			result.add((SpeedInt) sP);
		}
		return result;
	}
}
