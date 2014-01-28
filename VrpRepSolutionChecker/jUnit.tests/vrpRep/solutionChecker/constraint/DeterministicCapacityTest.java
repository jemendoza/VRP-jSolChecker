/**
 * 
 */
package vrpRep.solutionChecker.constraint;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.junit.Before;
import org.junit.Test;

import vrpRep.factory.ConstraintHandler;
import vrpRep.fileReaders.InstanceTranslator;
import vrpRep.fileReaders.SolutionTranslator;
import vrpRep.schema.output.Constraint;
import vrpRep.schema.output.Result;
import vrpRep.schema.output.Result.Constraints;
import vrpRep.schema.output.Result.Constraints.NonValid;
import vrpRep.schema.output.Result.Constraints.Valid;
import vrpRep.utilities.ConstraintResult;
import vrpRep.utilities.VRPRepJAXBUtilities;

/**
 * @author Maxim HOSKINS, Romain LIENARD, Raphael MOLY and Alexandre RENAUD
 *
 */
public class DeterministicCapacityTest {

	
	@Before
	public void setUp() throws Exception {
		new InstanceTranslator(new File(
				"./schemaFiles/DeterministicCapacityInstance.xml"));
		new SolutionTranslator(new File(
				"./schemaFiles/DeterministicCapacitySolution.xml"));

	}

	@Test
	public void test() {
		ConstraintHandler ch = new ConstraintHandler();
		
		IConstraint constraint = new DeterministicCapacity();
		ConstraintResult c = constraint.evaluate();
		
		Result res = ch.getOf().createResult();	
		Constraints cs = ch.getOf().createResultConstraints();
		Constraint cc;
		if(c.isValid()) {
			Valid val = ch.getOf().createResultConstraintsValid();
			cc = ch.getOf().createConstraint();
			cc.setName(c.getContraintName());
			val.getConstraint().add(cc);
			cs.setValid(val);
		}else {
			NonValid val = ch.getOf().createResultConstraintsNonValid();
			cc = ch.getOf().createConstraint();
			cc.setName(c.getContraintName());
			cc.setContent(c.getDetail());
			val.getConstraint().add(cc);
			cs.setNonValid(val);
		}
		res.setConstraints(cs);
		
		try {
			VRPRepJAXBUtilities.writeResult(res, new File("./solutionTestOutput/DeterministicCapacity"), false);
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		assertTrue(c.isValid());
	}

}
