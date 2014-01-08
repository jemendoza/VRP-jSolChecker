/**
 * 
 */
package sandbox;

import java.io.File;

import vrpRep.fileReaders.InstanceReader;

/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class TestFileReader {
	public static void main(String[] args) {
		InstanceReader instR = new InstanceReader(new File(
				"./schemaFiles/testXmlFile.xml"));
		System.out.println();
	}
}
