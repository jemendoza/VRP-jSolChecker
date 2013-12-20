package vrpRep.instance.v2;

import java.util.HashMap;
import java.util.List;

import vrpRep.exceptions.MissingAttributeException;

/**
 * 
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 *
 */
public class Node {
	private HashMap<String, List<VrpAtt>> atts;
	private int id;
	
	
	
	/**
	 * @param atts
	 * @param id
	 */
	public Node(HashMap<String, List<VrpAtt>> atts, int id) {
		super();
		this.atts = atts;
		this.id = id;
	}

	
	/**
	 * Retrieve node attribute from hashmap
	 * @param name name of attribute
	 * @return Attribute value
	 * @throws MissingAttributeException Thrown if attribute not found
	 */
	public List<VrpAtt> getAttribute(String name) throws MissingAttributeException{
		if(!this.atts.containsKey(name))
			throw new MissingAttributeException(name);
		else
			return this.atts.get(name);
	}
	
	
	/**
	 * 
	 * @param name
	 * @param att
	 */
	public void put(String name, NodeAtt att){
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
