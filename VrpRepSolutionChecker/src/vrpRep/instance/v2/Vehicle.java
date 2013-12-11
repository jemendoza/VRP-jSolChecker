package vrpRep.instance.v2;

import java.util.HashMap;
import java.util.List;

/**
 * 
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 *
 */
public class Vehicle {
	private	HashMap<String, List<VrpAtt>> atts;
	private int id;
	
	
	/**
	 * @param atts
	 * @param id
	 */
	public Vehicle(HashMap<String, List<VrpAtt>> atts, int id) {
		super();
		this.atts = atts;
		this.id = id;
	}
	
	/**
	 * 
	 * @param name
	 * @param att
	 */
	public void put(String name, VehicleAtt att){
		//TODO
	}
	
	/**
	 * 
	 * @param name
	 * @param att
	 */
	public void put(String name, IntValue att){
		//TODO
	}
	
	/**
	 * 
	 * @param name
	 * @param att
	 */
	public void put(String name, DoubleValue att){
		//TODO
	}
	
	/**
	 * 
	 * @param name
	 * @param att
	 */
	public void put(String name, BooleanValue att){
		//TODO
	}

	/**
	 * @return the atts
	 */
	public HashMap<String, List<VrpAtt>> getAtts() {
		return atts;
	}

	/**
	 * @param atts the atts to set
	 */
	public void setAtts(HashMap<String, List<VrpAtt>> atts) {
		this.atts = atts;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
}
