/**
 * 
 */
package vrpRep.fileReaders;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBException;

import vrpRep.schema.instance.Instance;
import vrpRep.utilities.XmlReader;

/**
 * Class used to store XML instance data.
 * 
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class InstanceReader {

	/**
	 * Master node containing all xml file info
	 */
	protected Instance	instance;

	/**
	 * Constructor that creates xml tree on class instantiation
	 * 
	 * @param xmlFile
	 *            xml file to extract
	 */
	public InstanceReader(File xmlFile) {
		try {
			XmlReader<Instance> iR = new XmlReader<Instance>();
			this.instance = iR.unmarshallDocument(xmlFile,
					Instance.class.getName());
		} catch (ClassNotFoundException | JAXBException | IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @return instance
	 */
	public Object getInstance() {
		return this.instance;
	}
}
