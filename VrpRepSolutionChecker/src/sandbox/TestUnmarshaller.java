/**
 * 
 */
package sandbox;

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
import vrpRep.schema.Instance.Network.Nodes.Node;

/**
 * Class used to test the unmarshalling of an XML document using JAXB
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 *
 */
public class TestUnmarshaller {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			
			unmarshallFile(new File("./schemaFiles/A-n32-k5.xml.zip"));
			printNodeInfo();
			
		} catch (JAXBException | IOException e) {
			e.printStackTrace();
		}
		
	}

	
	/**
	 * Master node containing all xml file info
	 */
	private static Instance instance;
	
	/**
	 * Extracts XML file content into a file structure
	 * @param file xml file to unmarshall
	 * @throws JAXBException
	 * @throws IOException
	 */
	public static void unmarshallFile(File file) throws JAXBException, IOException{
		JAXBContext context = JAXBContext.newInstance(Instance.class.getPackage().getName());

        Unmarshaller unmarshaller = context.createUnmarshaller();

        InputStream is;
        ZipInputStream zis = null;
        if (file.getName().endsWith(".zip")) {
            zis = new ZipInputStream(new FileInputStream(file));
            zis.getNextEntry();
            is = zis;
        } else {
            is = new FileInputStream(file);
        }

        instance = (Instance) unmarshaller.unmarshal(is);
        
        if(zis != null)
        	zis.close();
        is.close();
	}
	
	
	/**
	 * Prints node information
	 */
	public static void printNodeInfo(){
		Instance.Network.Nodes nodes = instance.getNetwork().getNodes();
		List<Node> nodeList = nodes.getNode();
		
		System.out.println("Id\tType\txCoord\tyCoord");
		for(Node node : nodeList){
			System.out.println(node.getId()+"\t"+
						node.getType()+"\t"+
						node.getLocation().getEuclidean().getCx()+"\t"+
						node.getLocation().getEuclidean().getCy());
		}
	}
}
