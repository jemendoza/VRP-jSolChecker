package vrpRep.structure.instance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Stores all link information and attributes.
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
	 * Custom constructor
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
	 * Adds a LinkAtt attribute to list of attributes
	 * @param name name of attribute
	 * @param att attribute to add
	 */
	public void addAttribute(String name, LinkAtt att) {
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
	 * Retrieves an attribute from list of attributes.<br />
	 * By default, the following attribute names are provide : 
	 * <ul>
	 * 	<li>id : id of type of request. Stored in {@link vrpRep.structure.instance.IntValue}</li>
	 * 	<li>tail : id of tail node. Stored in {@link vrpRep.structure.instance.IntValue}</li>
	 *  <li>head : id of tail node. Stored in {@link vrpRep.structure.instance.IntValue}</li>
	 *  <li>directed : true if graph is directed. Stored in {@link vrpRep.structure.instance.BooleanValue}</li>
	 *  <li>type : type of link. Stored in {@link vrpRep.structure.instance.IntValue}</li>
	 *  <li>cost : cost of link. Stored in {@link vrpRep.structure.instance.DoubleValue}</li>
	 *  <li>length : length of link. Stored in {@link vrpRep.structure.instance.DoubleValue}</li>
	 *  <li>time : time of link. Stored in {@link vrpRep.structure.instance.DoubleValue} for deterministic time
	 *  or {@link vrpRep.structure.instance.LinkProbaDist for stochastic time}</li>
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

	/**
	 * @return the tail id
	 */
	public int getTail() {
		return tail;
	}

	/**
	 * @return the head id
	 */
	public int getHead() {
		return head;
	}
}
