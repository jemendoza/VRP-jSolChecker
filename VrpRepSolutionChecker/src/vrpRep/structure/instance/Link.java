package vrpRep.structure.instance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Stores all link information and attributes
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class Link {
	/**
	 * List of link attributes
	 */
	private HashMap<String, List<VrpAtt>>	atts;
	/**
	 * Id of tail node
	 */
	private int								tail;
	/**
	 * Id of head node
	 */
	private int								head;

	/**
	 * @param atts List of link attributes
	 * @param tail Id of tail node
	 * @param head Id of head node
	 */
	public Link(int tail, int head) {
		super();
		atts = new HashMap<String, List<VrpAtt>>();
		this.tail = tail;
		this.head = head;
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
	public void addAttribute(String name, LinkAtt att) {
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
	 * Retrieve link attribute from hashmap
	 * 
	 * @param name
	 *            name of attribute
	 * @return Attribute value
	 * @throws MissingAttributeException
	 *             Thrown if attribute not found
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
	 * @return the tail
	 */
	public int getTail() {
		return tail;
	}

	/**
	 * @return the head
	 */
	public int getHead() {
		return head;
	}
}
