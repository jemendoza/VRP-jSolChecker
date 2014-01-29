/**
 * 
 */
package vrpRep.factory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import vrpRep.schema.output.Constraint;
import vrpRep.schema.output.ObjectFactory;
import vrpRep.schema.output.Result;
import vrpRep.schema.output.Result.Constraints;
import vrpRep.schema.output.Result.Constraints.NonValid;
import vrpRep.schema.output.Result.Constraints.Valid;
import vrpRep.solutionChecker.constraint.IConstraint;
import vrpRep.utilities.ConstraintResult;
import vrpRep.utilities.VRPRepJAXBUtilities;

/**
 * Stores add evaluates all the constraints.
 * 
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class ConstraintHandler {
	/**
	 * Xml output object creator
	 */
	private ObjectFactory		objF;
	/**
	 * XML schema result object
	 */
	private Result 				xmlResult;
	/**
	 * XML schema constraints object
	 */
	private Constraints 		xmlConstraints;
	/**
	 * XML schema valid constraints object
	 */
	private Valid 				xmlValid;
	/**
	 * XML schema non valid constraints object
	 */
	private NonValid 			xmlNonValid;

	/**
	 * List of constraints
	 */
	private ArrayList<IConstraint>	constraints;

	
	/**
	 * TO BE USED FOR JUNIT TESTS ONLY
	 */
	private ConstraintResult constraintResult;	
	public ConstraintResult getConstraintResult(){
		return constraintResult;
	}
	
	/**
	 * Default constructor. Initializes constraints list
	 */
	public ConstraintHandler() {
		this.constraints = new ArrayList<IConstraint>();
		this.objF = new ObjectFactory();	
		this.xmlResult = objF.createResult();
		this.xmlConstraints = objF.createResultConstraints();
		this.xmlValid = objF.createResultConstraintsValid();
		this.xmlNonValid = objF.createResultConstraintsNonValid();
	}


	/**
	 * Evaluates all constraints and stores the results in a xml file
	 * @param xmlResultFilePath path where to write xml result file
	 * @param zipFile true if result file should be zipped, false otherwise
	 */
	public void evaluateConstraints(String xmlResultFilePath, boolean zipFile) {
		for (IConstraint c : this.constraints) {
			ConstraintResult cResult = c.evaluate();
			/*
			 * TO BE USED FOR JUNIT TESTS ONLY
			 */
			constraintResult = cResult;
			
			
			Constraint tempConstraint = objF.createConstraint();;
			if(cResult.isValid()) {
				tempConstraint.setName(cResult.getContraintName());
				xmlValid.getConstraint().add(tempConstraint);
			}else {
				tempConstraint.setName(cResult.getContraintName());
				tempConstraint.setContent(cResult.getDetail());
				xmlNonValid.getConstraint().add(tempConstraint);
			}

		}
		writeToXML(xmlResultFilePath, zipFile);
	}


	/**
	 * Write solution checker results to xml file 
	 * @param xmlResultFilePath path where to write xml result file
	 * @param zipFile true if result file should be zipped, false otherwise
	 */
	private void writeToXML(String xmlResultFilePath, boolean zipFile){
		xmlConstraints.setValid(xmlValid);
		xmlConstraints.setNonValid(xmlNonValid);
		xmlResult.setConstraints(xmlConstraints);

		try {
			VRPRepJAXBUtilities.writeResult(xmlResult, new File(xmlResultFilePath), zipFile);
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Adds a constraint to the list of constraints to be evaluated
	 * 
	 * @param constraint
	 *            constraint to add
	 */
	public void addConstraint(IConstraint constraint) {
		this.constraints.add(constraint);
	}

	/**
	 * 
	 * @return object factory instance
	 */
	public ObjectFactory getObjectiveFactory() {
		return objF;
	}
	
	
	/**
	 * 
	 * @return List of constraints to evaluate
	 */
	public ArrayList<IConstraint> getConstraints() {
		return constraints;
	}


}
