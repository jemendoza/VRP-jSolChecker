package vrpRep.solChecker;

import java.util.ArrayList;


/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class ConstraintEvaluation {

	/**
	 * 
	 */
	private boolean	feasible;
	/**
	 * 
	 */
	private ArrayList<String> messages = null;


	/**
	 * 
	 */
	public ConstraintEvaluation() {
		this.feasible = true;
	}


	public boolean isFeasible() {
		return feasible;
	}

	public void setFeasible(boolean feasible) {
		this.feasible = feasible;
	}
	
	public void addMessage(String message){
		if(this.messages == null){
			this.messages = new ArrayList<String>();
			this.feasible = false;
		}
		this.messages.add(message);
	}
	
	public ArrayList<String> getMessages(){
		return this.messages;
	}

}