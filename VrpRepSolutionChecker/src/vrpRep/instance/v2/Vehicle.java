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
public class Vehicle {
	private HashMap<String, List<VrpAtt>>	atts;
	private int								id;

	/**
	 * @param atts
	 * @param id
	 */
	public Vehicle(int id) {
		super();
		atts = new HashMap<String, List<VrpAtt>>();
		this.id = id;
	}

	/**
	 * 
	 * @param name
	 * @param att
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
	 * 
	 * @param name
	 * @param att
	 */
	public void add(String name, VehicleAtt att) {
		addAttr(name, att);
	}

	/**
	 * 
	 * @param name
	 * @param att
	 */
	public void add(String name, IntValue att) {
		addAttr(name, att);
	}

	/**
	 * 
	 * @param name
	 * @param att
	 */
	public void add(String name, DoubleValue att) {
		addAttr(name, att);
	}

	/**
	 * 
	 * @param name
	 * @param att
	 */
	public void add(String name, BooleanValue att) {
		addAttr(name, att);
	}

	/**
	 * 
	 * @param name
	 * @return
	 * @throws MissingAttributeException
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
	 * @return the id
	 */
	public int getId() {
		return id;
	}
}
