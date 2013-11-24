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
public class MissingCustomElementException extends Exception {

	/**
	 * Main constructor
	 * @param message name of section missing custom element. e.g. node location
	 */
	public MissingCustomElementException(String message){
		super("A custom xml node in the '"+message+"' section has been found and is not processable");
	}
}
