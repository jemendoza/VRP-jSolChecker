/**
 * 
 */
package sandbox;

import java.io.File;

import org.apache.commons.math3.distribution.TDistribution;

import vrpRep.fileReaders.InstanceTranslator;

/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InstanceTranslator inst = new InstanceTranslator(new File(
				"./schemaFiles/A-n32-k5.xml.zip"));

		// Instance.Network.Descriptor des =
		// ((Instance)inst.getInstance()).getNetwork().getDescriptor();
		// System.out.println(des.getCustom().getAny().get(0).getTextContent());
		
		
		TDistribution t = new TDistribution(2);

	}

}
