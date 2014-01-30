/**
 * 
 */
package vrpRep.structure.instance;

/**
 * Stores information related to a skill or a tool for a vehicle of request
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class SkillAndTool implements VrpAtt {
	/**
	 * Id of skill or tool
	 */
	private int	id;
	/**
	 * Value of skill or tool
	 */
	private int	value;

	/**
	 * Default constructor
	 */
	public SkillAndTool() {
		super();
	}

	/**
	 * 
	 * @return value of skill or tool
	 */
	public int getValue() {
		return value;
	}

	/**
	 * 
	 * @param value new value of skill or tool
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * 
	 * @return id of skill or tool
	 */
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @param id new id of skill or tool
	 */
	public void setId(int id) {
		this.id = id;
	}

}
