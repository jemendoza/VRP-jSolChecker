package vrpRep.structure.instance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Stores all inforation and attributes of a vehicle
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class Vehicle {
	/**
	 * List of vehicle attributes
	 */
	private HashMap<String, List<VrpAtt>>	atts;

	/**
	 * Default constructor
	 */
	public Vehicle() {
		super();
		atts = new HashMap<String, List<VrpAtt>>();
	}

	/**
	 * Adds a VrpAtt attribute to list of attributes
	 * @param name name of attribute
	 * @param att attribute to add
	 */
	private  void addAttr(String name, VrpAtt att) {
		if (atts.containsKey(name)) {
			atts.get(name).add(att);
		} else {
			List<VrpAtt> value = new ArrayList<VrpAtt>();
			value.add(att);
			atts.put(name, value);
		}
	}

	/**
	 * Adds a SpeedInt attribute to list of attributes
	 * @param name name of attribute
	 * @param att attribute to add
	 */
	public void add(String name, Compartment att) {
		addAttr(name, att);		
	}
	
	/**
	 * Adds a SpeedInt attribute to list of attributes
	 * @param name name of attribute
	 * @param att attribute to add
	 */
	public void add(String name, SpeedInt att) {
		addAttr(name, att);
	}
	
	/**
	 * Adds a IntValue attribute to list of attributes
	 * @param name name of attribute
	 * @param att attribute to add
	 */
	public void add(String name, IntValue att) {
		addAttr(name, att);
	}

	/**
	 * Adds a DoubleValue attribute to list of attributes
	 * @param name name of attribute
	 * @param att attribute to add
	 */
	public void add(String name, DoubleValue att) {
		addAttr(name, att);
	}

	/**
	 * Adds a BooleanValue attribute to list of attributes
	 * @param name name of attribute
	 * @param att attribute to add
	 */
	public void add(String name, BooleanValue att) {
		addAttr(name, att);
	}

	/**
	 * Adds a TimeWindow attribute to list of attributes
	 * @param name name of attribute
	 * @param att attribute to add
	 */
	public void add(String name, TimeWindow att) {
		addAttr(name, att);
	}

	/**
	 * Adds a SkillAndTool attribute to list of attributes
	 * @param name name of attribute
	 * @param att attribute to add
	 */
	public void add(String name, SkillAndTool att) {
		addAttr(name, att);
	}

	/**
	 * Retrieves an attribute from list of attributes.
	 * @param name name of attribute
	 * @return attribute. null if not found
	 */
	public List<VrpAtt> getAttribute(String name) {
		if (!this.atts.containsKey(name))
			return null;
		else
			return this.atts.get(name);
	}

	/**
	 * @return list of attributes
	 */
	public HashMap<String, List<VrpAtt>> getAtts() {
		return atts;
	}

	

	
}
