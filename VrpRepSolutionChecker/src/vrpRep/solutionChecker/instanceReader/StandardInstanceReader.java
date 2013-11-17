/**
 * 
 */
package vrpRep.solutionChecker.instanceReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipInputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import vrpRep.schema.Instance;
import vrpRep.schema.Instance.Fleet.Vehicle;
import vrpRep.schema.Instance.Network.Links.Link;
import vrpRep.schema.Instance.Network.Nodes;
import vrpRep.schema.Instance.Network.Nodes.Node;
import vrpRep.schema.Instance.Requests.Request;

/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * @param <T>
 *
 */
public class StandardInstanceReader implements IInstanceReader {

	@Override
	public void unmarshallDocument(File xmlFile) throws JAXBException,
			IOException {
		// TODO Auto-generated method stub
		
	}


}
