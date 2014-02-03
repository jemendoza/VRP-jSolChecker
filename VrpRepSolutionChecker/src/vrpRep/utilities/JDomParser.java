package vrpRep.utilities;

import java.io.IOException;
import org.jdom.*;
import org.jdom.input.*;

/**
 * This class implements a JDom parser
 * @author Jorge E. Mendoza
 */
public class JDomParser {
	
	/**
	 * Parses an xml document
	 * @param fileName the name of the xml file
	 * @return a JDom document
	 */
	public static synchronized Document parseDocument(String fileName) throws JDOMException, IOException{
		SAXBuilder parser = new SAXBuilder();
		Document doc=null;
		try {
			doc = parser.build(fileName);
		} catch (JDOMException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		}
		return doc;
	}
	
}

