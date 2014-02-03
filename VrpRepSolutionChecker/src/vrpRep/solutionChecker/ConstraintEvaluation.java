package vrpRep.solutionChecker;

import java.util.ArrayList;


/**
 * Strores the evaluation of a constraint. Whether it is feasible or not and the error messages if any
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class ConstraintEvaluation {

	/**
	 * True if feasible, false otherwise
	 */
	private boolean	feasible;
	/**
	 * List of error messages
	 */
	private ArrayList<String> messages = null;


	/**
	 * Constructor
	 */
	public ConstraintEvaluation() {
		this.feasible = true;
	}

	/**
	 * 
	 * @return if is feasible
	 */
	public boolean isFeasible() {
		return feasible;
	}

	/**
	 * 
	 * @param feasible feasibility
	 */
	public void setFeasible(boolean feasible) {
		this.feasible = feasible;
	}
	
	/**
	 * Add error message to list of errors
	 * @param message new message
	 */
	public void addMessage(String message){
		if(this.messages == null){
			this.messages = new ArrayList<String>();
			this.feasible = false;
		}
		this.messages.add(message);
	}
	
	/**
	 * 
	 * @return list of error messages
	 */
	public ArrayList<String> getMessages(){
		return this.messages;
	}

}