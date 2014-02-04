/**
 * 
 */
package sandbox;

import java.io.File;

import vrpRep.fileReaders.SolutionTranslator;

/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class TestFileReader {
	public static void main(String[] args) {
		// InstanceTranslator instT = new InstanceTranslator(new
		// File("./schemaFiles/testXmlFile.xml"));

		@SuppressWarnings("unused")
		SolutionTranslator solT = new SolutionTranslator(new File(
				"./schemaFiles/sampleSolution.xml"));
		System.out.println();
	}
}
