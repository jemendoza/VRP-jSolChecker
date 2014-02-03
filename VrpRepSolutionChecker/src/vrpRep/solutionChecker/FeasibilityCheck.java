package vrpRep.solutionChecker;


import java.util.ArrayList;
import java.util.Iterator;

import org.jdom.Element;


/**
 * Implements a feasibility checker. I.E. a list of constraint evaluations and global feasibility
 * @author Main : Jorge E. Mendoza (jorge.mendoza@uco.fr). Modified : Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 *
 */
public class FeasibilityCheck {
	
	/**
	 * Holds the result of the evaluation of the constraints
	 */
	private ArrayList<ConstraintEvaluation> evaluations=null;
	/**
	 * True if the feasibility is verified, false otherwise
	 */
	private boolean feasible;
	
	/**
	 * Adds the evaluation of a constraint to the list of evaluations
	 * @param eval the evaluation to add
	 */
	public void addEvaluation(ConstraintEvaluation eval){
		if(this.evaluations==null){
			this.evaluations=new ArrayList<ConstraintEvaluation>();
		}
		this.evaluations.add(eval);
	}
	/**
	 * 
	 * @return the list of evaluations
	 */
	public ArrayList<ConstraintEvaluation> getEvaluations(){
		return this.evaluations;
	}

	/**
	 * set unfeasible
	 */
	public void setUnfeasible(){
		this.feasible=false;
	}

	/**
	 * set feasible
	 */
	public void setFeasible(){
		this.feasible=true;
	}

	/**
	 * 
	 * @return feasibility
	 */
	public boolean isFeasible(){
		return this.feasible;
	}

	/**
	 * Return feasibility written in xml form
	 * @return the result of the feasibility check as jDom XML element
	 */
	public Element toXML() {

		Element e=new Element("messages");
		Iterator<ConstraintEvaluation> it=evaluations.iterator();
		while(it.hasNext()){
			ArrayList<String> messages=it.next().getMessages();
			if(messages!=null){
				Iterator<String> it2=messages.iterator();
				while(it2.hasNext()){
					Element e1=new Element("message");
					e1.setText(it2.next());
					e.addContent(e1);
				}
			}
		}
		return e;
	}

}
