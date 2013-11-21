/**
 * 
 */
package vrpRep.solutionChecker.solution;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBException;

import vrpRep.schema.solution.Solution;
import vrpRep.solutionChecker.instanceReader.InstanceReader;

/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 *
 */
public class DefaultSolution {

	/**
	 * Master node containing all xml file info
	 */
	protected Solution solution;
	

	
	
	/**
	 * Constructor that creates xml tree on class instantiation 
	 * @param xmlFile xml file to extract
	 */
	public DefaultSolution(File xmlFile){	
		try {
			InstanceReader<Solution> iR = new InstanceReader<Solution>();
			this.solution = iR.unmarshallDocument(xmlFile, Solution.class.getName());
		} catch (ClassNotFoundException | JAXBException | IOException e) {
			e.printStackTrace();
		}		
	}
	
	
	/**
	 * 
	 * @return solution
	 */
	public Solution getSolution(){
		return this.solution;
	}
}
