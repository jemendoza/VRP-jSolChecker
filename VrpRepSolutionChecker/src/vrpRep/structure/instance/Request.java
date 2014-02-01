package vrpRep.structure.instance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Stores all request information and attributes. <br />
 * By default, the following attribute names are provide : 
 * <ul>
 * 	<li>type : id of type of request. Stored in {@link vrpRep.structure.instance.IntValue}</li>
 * 	<li>node : id of linked node. Stored in {@link vrpRep.structure.instance.IntValue}</li>
 *  <li>link : id of linked link. Stored in {@link vrpRep.structure.instance.IntValue}</li>
 *  <li>tw : time windows of request. Stored in {@link vrpRep.structure.instance.TimeWindow}</li>
 *  <li>demand : demands of request : Stored in {@link vrpRep.structure.instance.DemandValue} for deterministic demands
 *  or {@link vrpRep.structure.instance.DemandProbaDist for stochastic demands}</li>
 *  <li>prize : prize of request. Stored in {@link vrpRep.structure.instance.DoubleValue}</li>
 *  <li>cost : cost of request. Stored in {@link vrpRep.structure.instance.DoubleValue}</li>
 *  <li>releaseDate : release date of request. Stored in {@link vrpRep.structure.instance.DoubleValue}</li>
 *  <li>serviceTime : service time of a request. Stored in {@link vrpRep.structure.instance.IntValue} for deterministic demands
 *  or {@link vrpRep.structure.instance.RequestProbaDist} for stochastic demands}</li>
 *  <li>predecessor : list of preceeding requets. Stored in {@link vrpRep.structure.instance.IntValue}</li>
 *  <li>successor : list of succeeding requests. Stored in {@link vrpRep.structure.instance.IntValue}</li>
 *  <li>skill : list of skills. Stored in {@link vrpRep.structure.instance.IntValue}</li>
 *  <li>tool: list of tools. Stored in {@link vrpRep.structure.instance.IntValue}</li>
 * </ul>
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class Request {
	/**
	 * List of request attributes
	 */
	private HashMap<String, List<VrpAtt>>	atts;
	/**
	 * Id of request
	 */
	private int								id;

	/**
	 * Default constructor
	 * @param id id of request
	 */
	public Request(int id) {
		super();
		this.atts = new HashMap<String, List<VrpAtt>>();
		this.id = id;
	}

	/**
	 * Custom constructor
	 * @param atts list of attributes
	 * @param id id of request
	 */
	public Request(HashMap<String, List<VrpAtt>> atts, int id) {
		super();
		this.atts = atts;
		this.id = id;
	}

	/**
	 * Adds a VrpAtt attribute to list of attributes
	 * @param name name of attribute
	 * @param att attribute to add
	 */
	private void addAttr(String name, VrpAtt att) {
		if (atts.containsKey(name)) {
			atts.get(name).add(att);
		} else {
			List<VrpAtt> value = new ArrayList<VrpAtt>();
			value.add(att);
			atts.put(name, value);
		}
	}

	/**
	 * Adds a RequestAtt attribute to list of attributes
	 * @param name name of attribute
	 * @param att attribute to add
	 */
	public void add(String name, RequestAtt att) {
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

	/**
	 * @return the id of request
	 */
	public int getId() {
		return id;
	}
}
