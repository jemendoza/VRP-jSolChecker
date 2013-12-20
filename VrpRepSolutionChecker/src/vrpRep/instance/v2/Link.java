package vrpRep.instance.v2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import vrpRep.exceptions.MissingAttributeException;

/**
 * 
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class Link {
	private HashMap<String, List<VrpAtt>>	atts;
	private int								tail;
	private int								head;

	/**
	 * @param atts
	 * @param tail
	 * @param head
	 */
	public Link(HashMap<String, List<VrpAtt>> atts, int tail, int head) {
		super();
		this.atts = atts;
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
	public List<VrpAtt> getAttribute(String name)
			throws MissingAttributeException {
		if (!this.atts.containsKey(name))
			throw new MissingAttributeException(name);
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
