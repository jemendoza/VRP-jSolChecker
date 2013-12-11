package vrpRep.instance.v2;

import java.util.HashMap;
import java.util.List;

/**
 * 
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 *
 */
public class Link {
	private HashMap<String, List<VrpAtt>> atts;
	private int tail;
	private int head;

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
	 * 
	 * @param name
	 * @param att
	 */
	public void put(String name, LinkAtt att){
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
	 * @return the tail
	 */
	public int getTail() {
		return tail;
	}



	/**
	 * @param tail the tail to set
	 */
	public void setTail(int tail) {
		this.tail = tail;
	}



	/**
	 * @return the head
	 */
	public int getHead() {
		return head;
	}



	/**
	 * @param head the head to set
	 */
	public void setHead(int head) {
		this.head = head;
	}

	
}
