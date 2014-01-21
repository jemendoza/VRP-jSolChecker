/**
 * 
 */
package vrpRep.fileReaders;

import java.util.List;

import vrpRep.structure.instance.Instance;
import vrpRep.structure.instance.SpeedInt;

/**
 * Interface to encapsulate of speed profile reader
 * 
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public interface ISpeedProfileReader {

	/**
	 * Retrieves average vehicle speed. <b>To be used when average speed is
	 * used</b>
	 * 
	 * @param instance
	 *            link to instance object
	 * @param id
	 *            id of vehicle
	 * @return Average vehicle speed
	 */
	public double getAverageSpeed(Instance instance, int id);

	/**
	 * Retrieves speed intervals of a vehicle. <b>To be used when speed
	 * intervals are used</b>
	 * 
	 * @param instance
	 *            link to instance object
	 * @param id
	 *            id of vehicle
	 * @return List of vehicle's speed intervals
	 */
	public List<SpeedInt> getSpeedIntervals(Instance instance, int id);

}
