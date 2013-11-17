/**
 * 
 */
package vrpRep.solutionChecker.instanceReader;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBException;

/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 *
 */
public interface IInstanceReader {
	
	/**
	 * Extracts XML file content into jaxb structured collection
	 * @param xmlFile xml file to unmarshall
	 * @throws JAXBException
	 * @throws IOException
	 */
	public void unmarshallDocument(File xmlFile) throws JAXBException, IOException;

}
