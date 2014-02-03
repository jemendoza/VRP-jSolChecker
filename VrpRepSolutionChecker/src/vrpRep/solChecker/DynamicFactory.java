/**
 * 
 */
package vrpRep.solChecker;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import vrpRep.utilities.DistanceCalculator;

/**
 * Dynamic factory to build the parameterized solution checker
 * 
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class DynamicFactory {

	/**
	 * Properties containing dynamic initialization parameters
	 */
	private Properties	properties;

	/**
	 * Constructor
	 * 
	 * @param propertiesFilePath
	 *            path to properties XML File
	 * @throws IOException
	 * @throws InvalidPropertiesFormatException
	 */
	public DynamicFactory(String propertiesFilePath) {
		try {
			FileInputStream file = new FileInputStream(propertiesFilePath);
			this.properties = new Properties();
			this.properties.loadFromXML(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public void loadConstraints(VrpRepSolutionChecker solC){
		// TODO
	}
	
	/**
	 * Retrieves distance calculator. If exception thrown, ensure xml
	 * configuration file contains class path to demand reader under key
	 * "distanceCalculator".
	 * 
	 */
	public void buildDistanceCalculator() {
		try {
			if (this.properties.getProperty("distanceCalculator") != null) {
				Class<?> tClass;
				tClass = Class.forName(this.properties
						.getProperty("distanceCalculator"));
				DistanceCalculator
						.setDistanceCalculator((DistanceCalculator) tClass
								.newInstance());
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

}
