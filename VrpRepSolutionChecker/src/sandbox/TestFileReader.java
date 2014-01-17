/**
 * 
 */
package sandbox;

import java.io.File;

import vrpRep.fileReaders.InstanceTranslator;

/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class TestFileReader {
	public static void main(String[] args) {
		InstanceTranslator instR = new InstanceTranslator(new File(
				"./schemaFiles/testXmlFile.xml"));
		System.out.println();
	}
}
