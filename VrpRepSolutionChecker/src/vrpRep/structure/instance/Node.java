package vrpRep.structure.instance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class Node {
	private HashMap<String, List<VrpAtt>>	atts;
	private int								id;

	/**
	 * @param atts
	 * @param id
	 */
	public Node(int id) {
		super();
		this.id = id;
		atts = new HashMap<String, List<VrpAtt>>();
	}

	/**
	 * Add attribute in hashmap
	 * 
	 * @param name
	 *            Name of attribute
	 * @param att
	 *            Attribute value
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
	 * Add attribute in hashmap
	 * 
	 * @param name
	 *            Name of attribute
	 * @param att
	 *            Attribute value
	 */
	public void addAttribute(String name, VrpAtt att) {
		addAttr(name, att);
	}

	/**
	 * Add attribute in hashmap
	 * 
	 * @param name
	 *            Name of attribute
	 * @param att
	 *            Attribute value
	 */
	public void addAttribute(String name, IntValue att) {
		addAttr(name, att);
	}

	/**
	 * Add attribute in hashmap
	 * 
	 * @param name
	 *            Name of attribute
	 * @param att
	 *            Attribute value
	 */
	public void addAttribute(String name, DoubleValue att) {
		addAttr(name, att);
	}

	/**
	 * Add attribute in hashmap
	 * 
	 * @param name
	 *            Name of attribute
	 * @param att
	 *            Attribute value
	 */
	public void addAttribute(String name, BooleanValue att) {
		addAttr(name, att);
	}

	/**
	 * Retrieve node attribute from hashmap
	 * 
	 * @param name
	 *            name of attribute
	 * @return Attribute value
	 */
	public List<VrpAtt> getAttribute(String name) {
		if (!this.atts.containsKey(name))
			return null;
		else
			return this.atts.get(name);
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
