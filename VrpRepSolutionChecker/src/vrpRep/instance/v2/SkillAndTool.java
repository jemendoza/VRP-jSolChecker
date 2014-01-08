/**
 * 
 */
package vrpRep.instance.v2;

/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class SkillAndTool implements RequestAtt, VehicleAtt {
	/**
	 * 
	 */
	private int	id;
	/**
	 * 
	 */
	private int	value;

	/**
	 * 
	 */
	public SkillAndTool() {
		super();
	}

	/**
	 * 
	 * @return
	 */
	public int getValue() {
		return value;
	}

	/**
	 * 
	 * @param value
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

}
