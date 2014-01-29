package vrpRep.utilities;


/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class ConstraintResult {

	/**
	 * 
	 */
	private boolean	valid;
	/**
	 * 
	 */
	private String	detail;
	/**
	 * 
	 */
	private String	contraintName;

	/**
	 * 
	 */
	public ConstraintResult(boolean valid, String detail, String contraintName) {
		this.valid = valid;
		this.detail = detail;
		this.contraintName = contraintName;
	}

	/**
	 * 
	 */
	public ConstraintResult(boolean valid, String contraintName) {
		this.valid = valid;
		this.detail = null;
		this.contraintName = contraintName;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getContraintName() {
		return contraintName;
	}

	public void setContraintName(String contraintName) {
		this.contraintName = contraintName;
	}

}