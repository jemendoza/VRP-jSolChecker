/**
 * 
 */
package vrpRep.fileReaders;

import vrpRep.structure.instance.DoubleValue;
import vrpRep.structure.instance.Instance;

/**
 * Reads average speed of vehicle
 * 
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class SpeedAverageReader implements ISpeedProfileReader {

	/**
	 * Retrieves average vehicle speed
	 * 
	 * @param instance
	 *            link to instance object
	 * @param id
	 *            id of vehicle
	 * @return Average vehicle speed
	 */
	public double getSpeed(Instance instance, int id) {
		return ((DoubleValue) instance.getVehicleAttribute(id, "speedProfile")
				.get(0)).getValue();
	}
}
