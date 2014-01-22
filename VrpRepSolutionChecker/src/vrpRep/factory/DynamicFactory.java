/**
 * 
 */
package vrpRep.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import vrpRep.fileReaders.IDemandReader;
import vrpRep.fileReaders.IInstanceReader;
import vrpRep.fileReaders.ISolutionReader;
import vrpRep.fileReaders.ISpeedProfileReader;
import vrpRep.fileReaders.ITimeReader;
import vrpRep.solutionChecker.constraint.IConstraint;
import vrpRep.structure.instance.Instance;
import vrpRep.structure.solution.Solution;
import vrpRep.utilities.IDistanceCalculator;

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
	private static DynamicFactory	factory				= null;
	/**
	 * Properties containing dynamic initialization parameters
	 */
	private Properties				properties;

	/**
	 * Instance reader
	 */
	private IInstanceReader			instanceReader		= null;
	/**
	 * solution reader
	 */
	private ISolutionReader			solutionReader		= null;

	/**
	 * Demand reader
	 */
	private IDemandReader			demandReader		= null;
	/**
	 * Location reader
	 */
	private IDistanceCalculator		distanceCalculator	= null;
	/**
	 * Speed profile reader
	 */
	private ISpeedProfileReader		speedProfileReader	= null;
	/**
	 * Time reader
	 */
	private ITimeReader				timeReader			= null;

	/**
	 * Constraint handler
	 */
	private ConstraintHandler		constraintHander	= null;

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
		factory.constraintHander = new ConstraintHandler();
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
	 * @return instance
	 */
	public Instance buildInstance(String instanceXmlPath) {
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
		return factory.instanceReader.getInstance();
	}

	/**
	 * Loads solution. If exception thrown, ensure xml configuration file
	 * contains class path to solution reader under key "solutionReader".
	 * 
	 * @param instanceXmlPath
	 *            path to solution xml file
	 * @return solution
	 */
	public Solution buildSolution(String solutionXmlPath) {
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
		return factory.solutionReader.getSolution();
	}

	/**
	 * Returns instance. Ensure instance has been loaded via
	 * buildInstance(String) method
	 * 
	 * @return instance
	 */
	public Instance getInstance() {
		return factory.instanceReader.getInstance();
	}

	/**
	 * Returns solution. Ensure solution has been loaded via
	 * buildSolution(String) method
	 * 
	 * @return solution
	 */
	public Solution getSolution() {
		return factory.solutionReader.getSolution();
	}

	/**
	 * Retrieves demand reader. If exception thrown, ensure xml configuration
	 * file contains class path to demand reader under key "demandReader".
	 * 
	 * @return demand reader
	 */
	public IDemandReader getDemandReader() {
		try {
			if (this.properties.getProperty("demandReader") != null) {
				Class<?> tClass;
				tClass = Class.forName(this.properties
						.getProperty("demandReader"));
				factory.demandReader = (IDemandReader) tClass.newInstance();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return factory.demandReader;
	}

	/**
	 * Retrieves distance calculator. If exception thrown, ensure xml
	 * configuration file contains class path to demand reader under key
	 * "distanceCalculator".
	 * 
	 * @return distance calculator
	 */
	public IDistanceCalculator getDistanceCalculator() {
		try {
			if (this.properties.getProperty("distanceCalculator") != null) {
				Class<?> tClass;
				tClass = Class.forName(this.properties
						.getProperty("distanceCalculator"));
				factory.distanceCalculator = (IDistanceCalculator) tClass
						.newInstance();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return factory.distanceCalculator;
	}

	/**
	 * Retrieves speed profile reader. If exception thrown, ensure xml
	 * configuration file contains class path to demand reader under key
	 * "speedProfileReader".
	 * 
	 * @return speed profile reader
	 */
	public ISpeedProfileReader getSpeedProfileReader() {
		try {
			if (this.properties.getProperty("speedProfileReader") != null) {
				Class<?> tClass;
				tClass = Class.forName(this.properties
						.getProperty("speedProfileReader"));
				factory.speedProfileReader = (ISpeedProfileReader) tClass
						.newInstance();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return factory.speedProfileReader;
	}

	/**
	 * Retrieves time reader. If exception thrown, ensure xml configuration file
	 * contains class path to demand reader under key "timeReader".
	 * 
	 * @return time reader
	 */
	public ITimeReader getTimeReader() {
		try {
			if (this.properties.getProperty("timeReader") != null) {
				Class<?> tClass;
				tClass = Class.forName(this.properties
						.getProperty("timeReader"));
				factory.timeReader = (ITimeReader) tClass.newInstance();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return factory.timeReader;
	}

	/**
	 * 
	 * @return constraint handler
	 */
	public ConstraintHandler getConstraintHandler() {
		return factory.constraintHander;
	}

	/**
	 * Adds a constraint to be evaluated to the constraint handler
	 * 
	 * @param constraint
	 *            constraint to add
	 */
	public void addConstraint(IConstraint constraint) {
		factory.constraintHander.addConstraint(constraint);
	}

	/**
	 * Evaluates all constraints and stores the results in a xml file
	 * 
	 * @return XML file of constraint validity results
	 */
	public File evaluateConstraints() {
		return factory.constraintHander.evaluateConstraints();
	}

	/**
	 * Cloning forbidden
	 */
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException(
				"Singleton pattern implemented on this class");
	}
}
