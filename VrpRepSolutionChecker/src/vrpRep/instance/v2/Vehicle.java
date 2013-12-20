package vrpRep.instance.v2;

import java.util.ArrayList;
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
		if(atts.containsKey(name)){
			atts.get(name).add(att);
		}else{
			List<VrpAtt> value = new ArrayList<VrpAtt>();
			value.add(att);
			atts.put(name, value);
		}
	}
	
	/**
	 * 
	 * @param name
	 * @param att
	 */
	public void put(String name, IntValue att){
		if(atts.containsKey(name)){
			atts.get(name).add(att);
		}else{
			List<VrpAtt> value = new ArrayList<VrpAtt>();
			value.add(att);
			atts.put(name, value);
		}
	}
	
	/**
	 * 
	 * @param name
	 * @param att
	 */
	public void put(String name, DoubleValue att){
		if(atts.containsKey(name)){
			atts.get(name).add(att);
		}else{
			List<VrpAtt> value = new ArrayList<VrpAtt>();
			value.add(att);
			atts.put(name, value);
		}
	}
	
	/**
	 * 
	 * @param name
	 * @param att
	 */
	public void put(String name, BooleanValue att){
		if(atts.containsKey(name)){
			atts.get(name).add(att);
		}else{
			List<VrpAtt> value = new ArrayList<VrpAtt>();
			value.add(att);
			atts.put(name, value);
		}
	}

	/**
	 * @return the atts
	 */
	public HashMap<String, List<VrpAtt>> getAtts() {
		return atts;
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
}
