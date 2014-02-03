/**
 * 
 */
package vrpRep.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipInputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


/**
 * Generic class used to read any xml file and store the data in a jaxb class structure (similar to DOM)<br />
 * The generic type T must point to jaxb class that represents head node of xml file
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 *
 */
public class XmlSchemaReader<T> {

	/**
	 * Default constructor
	 */
	public XmlSchemaReader(){
	}
	
	
	/**
	 * Unmarshalls/extract xml file 
	 * @param xmlFile Xml file to unmarshall. Remark : The file can be zipped.
	 * @param jaxBHeadFile String path towards generic class T defined at class instantiation
	 * @return Data stored in jaxb tree with is an object of type T
	 * @throws JAXBException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("unchecked")
	public T unmarshallDocument(File xmlFile, String jaxBHeadFile) throws JAXBException, IOException, ClassNotFoundException{	
		JAXBContext context = JAXBContext.newInstance(Class.forName(jaxBHeadFile).getPackage().getName());

        Unmarshaller unmarshaller = context.createUnmarshaller();

        InputStream is;
        ZipInputStream zis = null;
        if (xmlFile.getName().endsWith(".zip")) {
            zis = new ZipInputStream(new FileInputStream(xmlFile));
            zis.getNextEntry();
            is = zis;
        } else {
            is = new FileInputStream(xmlFile);
        }

        T instance = (T) unmarshaller.unmarshal(is);
        
        if(zis != null)
        	zis.close();
        is.close();	
        
        return instance; 
	}
}
