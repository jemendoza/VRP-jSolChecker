/**
 * 
 */
package sandbox;

import java.io.File;

import vrpRep.schema.instance.Instance;
import vrpRep.solutionChecker.instance.StandardInstance;

/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 *
 */
public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StandardInstance inst = new StandardInstance(new File("./schemaFiles/A-n32-k5.xml.zip"));
		
		Instance.Network.Descriptor des = ((Instance)inst.getInstance()).getNetwork().getDescriptor();
		System.out.println(des.getCustom().getAny().get(0).getTextContent());
		
	}

}
