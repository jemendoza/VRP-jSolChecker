/**
 * 
 */
package sandbox;

import vrpRep.solutionChecker.DynamicFactory;
import vrpRep.solutionChecker.VrpRepSolutionChecker;

/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 * 
 */
public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*InstanceTranslator inst = new InstanceTranslator(new File(
				"./schemaFiles/A-n32-k5.xml.zip"));

		// Instance.Network.Descriptor des =
		// ((Instance)inst.getInstance()).getNetwork().getDescriptor();
		// System.out.println(des.getCustom().getAny().get(0).getTextContent());
		
		
		TDistribution t = new TDistribution(2);*/
		
		
		VrpRepSolutionChecker solCheck = new VrpRepSolutionChecker("./xmlTest/InstancetestDepartureArrivalNode.xml"
												, "./xmlTest/SolutiontestDepartureArrivalNode.xml");
		
		DynamicFactory factory = new DynamicFactory("./config/config.xml");
		
		factory.loadConstraints(solCheck);
		factory.loadObjective(solCheck);
		factory.setDistanceCalculator();
		
		

	}

}
