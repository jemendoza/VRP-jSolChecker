package vrpRep.structure.instance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Stores all node information and attributes
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class Node {
	/**
	 * List of node attributes
	 */
	private HashMap<String, List<VrpAtt>>	atts;
	/**
	 * Id of node
	 */
	private int								id;

	/**
	 * Custom constructor
	 * @param id id of node
	 */
	public Node(int id) {
		super();
		this.id = id;
		atts = new HashMap<String, List<VrpAtt>>();
	}

	/**
	 * Adds a VrpAtt attribute to list of attributes
	 * @param name name of attribute
	 * @param att attribute to add
	 */
	private void addAttr(String name, VrpAtt att) {
		if (!atts.containsKey(name)) {
			List<VrpAtt> listAtt = new ArrayList<VrpAtt>();
			listAtt.add(att);
			atts.put(name, listAtt);
		} else {
			atts.get(name).add(att);
		}
	}

	/**
	 * Adds a Location attribute to list of attributes
	 * @param name name of attribute
	 * @param att attribute to add
	 */
	public void addAttribute(String name, Location att) {
		addAttr(name, att);
	}
	
	/**
	 * Adds a IntValue attribute to list of attributes
	 * @param name name of attribute
	 * @param att attribute to add
	 */
	public void addAttribute(String name, IntValue att) {
		addAttr(name, att);
	}

	/**
	 * Adds a DoubleValue attribute to list of attributes
	 * @param name name of attribute
	 * @param att attribute to add
	 */
	public void addAttribute(String name, DoubleValue att) {
		addAttr(name, att);
	}

	/**
	 * Adds a BooleanValue attribute to list of attributes
	 * @param name name of attribute
	 * @param att attribute to add
	 */
	public void addAttribute(String name, BooleanValue att) {
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
	 * @return list of attributed
	 */
	public HashMap<String, List<VrpAtt>> getAtts() {
		return atts;
	}

	/**
	 * @return id of the attribute
	 */
	public int getId() {
		return id;
	}

	
}
