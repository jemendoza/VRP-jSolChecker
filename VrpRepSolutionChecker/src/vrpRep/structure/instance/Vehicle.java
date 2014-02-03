package vrpRep.structure.instance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Stores all inforation and attributes of a vehicle.
 * 
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
	 * Retrieves an attribute from list of attributes.<br />
	 * 
	 * By default, the following attribute names are provide : 
	 * <ul>
	 * 	<li>type : id of type of vehicle. Stored in {@link vrpRep.structure.instance.IntValue}</li>
	 * 	<li>fixedCost : fixed cost of vehicle. Stored in {@link vrpRep.structure.instance.DoubleValue}</li>
	 *  <li>variableCost : fixed cost of vehicle. Stored in {@link vrpRep.structure.instance.DoubleValue}</li>
	 *  <li>number : Number of available vehicles. Stored in {@link vrpRep.structure.instance.IntValue}</li>
	 *  <li>nodeTypesCompatible : list of compatible nodes. Stored in {@link vrpRep.structure.instance.IntValue}</li>
	 *  <li>speedProfile : allowed speed of vehicle. Stored in {@link vrpRep.structure.instance.DoubleValue} for global average
	 *  or in {@link vrpRep.structure.instance.SpeedInt} for a series of speed intervals</li>
	 *  <li>maxTravelDistance : maximum travel distance. Stored in {@link vrpRep.structure.instance.DoubleValue}</li>
	 *  <li>maxTravelDistanceIsFlexible : true if maximum travel distance is flexible false otherwise. Stored in {@link vrpRep.structure.instance.BooleanValue}</li>
	 *  <li>maxRequests : maximum number of requests. Stored in {@link vrpRep.structure.instance.IntValue}</li>
	 *  <li>maxRequestsIsFlexible : true if number of requests is flexible false otherwise. Stored in {@link vrpRep.structure.instance.BooleanValue}</li>
	 *  <li>wLPMaxWorkTime : maximum work time. Stored in {@link vrpRep.structure.instance.DoubleValue}</li>
	 *  <li>wLPMaxWorkTimeIsFlexible : true if maximum work time is flexible false otherwise. Stored in {@link vrpRep.structure.instance.BooleanValue}</li>
	 *  <li>wLPtw : time windows of possible work periods. Stored in {@link vrpRep.structure.instance.TimeWindow}</li>
	 *  <li>capacity: total capacity of vehicle. Stored in {@link vrpRep.structure.instance.DoubleValue}</li>
	 *  <li>compartment : capacities of compartments. Stored in {@link vrpRep.structure.instance.Compartment}</li>
	 *  <li>departureNode : id of departure node. Stored in {@link vrpRep.structure.instance.IntValue}</li>
	 *  <li>arrivalNode : id of arrival node. Stored in {@link vrpRep.structure.instance.IntValue}</li>
	 *  <li>skill : list of skills. Stored in {@link vrpRep.structure.instance.SkillAndTool}</li>
	 *  <li>tool: list of tools. Stored in {@link vrpRep.structure.instance.SkillAndTool}</li>
	 * </ul>
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
