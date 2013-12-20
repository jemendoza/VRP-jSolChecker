/**
 * 
 */
package vrpRep.exceptions;

/**
 * Custom exception designed to inform user that a custom node is used is the 
 * xml file and specific classes must be added to framework to function properly
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 *
 */
@SuppressWarnings("serial")
public class MissingElementException extends Exception {

	/**
	 * Main constructor
	 * @param message name of missing element (e.g. node)
	 */
	public MissingElementException(String message){
		super("The '"+message+"' being searched for does not exist");
	}
}
