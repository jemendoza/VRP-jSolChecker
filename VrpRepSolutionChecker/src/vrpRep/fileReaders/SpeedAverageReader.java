/**
 * 
 */
package vrpRep.fileReaders;

import java.util.List;

import vrpRep.structure.instance.DoubleValue;
import vrpRep.structure.instance.Instance;
import vrpRep.structure.instance.SpeedInt;

/**
 * Reads average speed of vehicle
 * 
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class SpeedAverageReader implements ISpeedProfileReader {

	@Override
	public double getAverageSpeed(Instance instance, int id) {
		return ((DoubleValue) instance.getVehicleAttribute(id, "speedProfile")
				.get(0)).getValue();
	}

	@Override
	public List<SpeedInt> getSpeedIntervals(Instance instance, int id) {
		return null;
	}
}
