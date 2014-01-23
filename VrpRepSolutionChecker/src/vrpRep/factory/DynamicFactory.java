/**
 * 
 */
package vrpRep.factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import vrpRep.fileReaders.IInstanceReader;
import vrpRep.fileReaders.ISolutionReader;
import vrpRep.utilities.DistanceCalculator;

/**
 * Dynamic factory containing links to all dynamic classes of the solution
 * checker such as the element readers
 * 
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class DynamicFactory {

	/**
	 * Singleton instance of factory
	 */
	private static DynamicFactory	factory			= null;
	/**
	 * Properties containing dynamic initialization parameters
	 */
	private Properties				properties;

	/**
	 * Instance reader
	 */
	private IInstanceReader			instanceReader	= null;
	/**
	 * solution reader
	 */
	private ISolutionReader			solutionReader	= null;

	/**
	 * Constructor
	 * 
	 * @param propertiesFilePath
	 *            path to properties XML File
	 * @throws IOException
	 * @throws InvalidPropertiesFormatException
	 */
	private DynamicFactory(String propertiesFilePath)
			throws InvalidPropertiesFormatException, IOException {
		FileInputStream file = new FileInputStream(propertiesFilePath);
		factory.properties = new Properties();
		factory.properties.loadFromXML(file);
	}

	/**
	 * Static access to build factory
	 * 
	 * @param configFileName
	 *            path to properties XML File
	 * @return newly initialized factory
	 * @throws IOException
	 * @throws InvalidPropertiesFormatException
	 */
	public static DynamicFactory buildFactory(String configFileName)
			throws InvalidPropertiesFormatException, IOException {
		if (factory == null) {
			factory = new DynamicFactory(configFileName);
		}
		return factory;
	}

	/**
	 * Static access to factory
	 * 
	 * @return factory
	 */
	public static DynamicFactory getFactory() {
		if (factory == null) {
			try {
				throw new IllegalStateException(
						"DynamicFactory Singleton must be initialized.\n"
								+ "Use method buildFactory(configFileName) to initialize the Singleton");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return factory;
	}

	/**
	 * Loads instance. If exception thrown, ensure xml configuration file
	 * contains class path to instance reader under key "instanceReader".
	 * 
	 * @param instanceXmlPath
	 *            path to instance xml file
	 */
	public void buildInstance(String instanceXmlPath) {
		try {
			if (this.properties.getProperty("instanceReader") != null) {
				Class<?> tClass;
				tClass = Class.forName(this.properties
						.getProperty("instanceReader"));
				factory.instanceReader = (IInstanceReader) tClass
						.getDeclaredConstructor(String.class).newInstance(
								instanceXmlPath);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Loads solution. If exception thrown, ensure xml configuration file
	 * contains class path to solution reader under key "solutionReader".
	 * 
	 * @param instanceXmlPath
	 *            path to solution xml file
	 */
	public void buildSolution(String solutionXmlPath) {
		try {
			if (this.properties.getProperty("solutionReader") != null) {
				Class<?> tClass;
				tClass = Class.forName(this.properties
						.getProperty("solutionReader"));
				factory.solutionReader = (ISolutionReader) tClass
						.getDeclaredConstructor(String.class).newInstance(
								solutionXmlPath);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Retrieves distance calculator. If exception thrown, ensure xml
	 * configuration file contains class path to demand reader under key
	 * "distanceCalculator".
	 * 
	 */
	public void getDistanceCalculator() {
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

	/**
	 * Cloning forbidden
	 */
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException(
				"Singleton pattern implemented on this class");
	}
}
