//
// Ce fichier a �t� g�n�r� par l'impl�mentation de r�f�rence JavaTM Architecture for XML Binding (JAXB), v2.2.5-2 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apport�e � ce fichier sera perdue lors de la recompilation du sch�ma source. 
// G�n�r� le : 2014.01.23 � 04:10:08 PM CET 
//


package vrpRep.schema.output;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the vrpRep.schema.output package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: vrpRep.schema.output
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Result }
     * 
     */
    public Result createResult() {
        return new Result();
    }

    /**
     * Create an instance of {@link Result.Constraints }
     * 
     */
    public Result.Constraints createResultConstraints() {
        return new Result.Constraints();
    }

    /**
     * Create an instance of {@link Result.Constraints.Valid }
     * 
     */
    public Result.Constraints.Valid createResultConstraintsValid() {
        return new Result.Constraints.Valid();
    }

    /**
     * Create an instance of {@link Result.Constraints.NonValid }
     * 
     */
    public Result.Constraints.NonValid createResultConstraintsNonValid() {
        return new Result.Constraints.NonValid();
    }

    /**
     * Create an instance of {@link Result.ObjectiveFunction }
     * 
     */
    public Result.ObjectiveFunction createResultObjectiveFunction() {
        return new Result.ObjectiveFunction();
    }

    /**
     * Create an instance of {@link Result.Constraints.Valid.Constraint }
     * 
     */
    public Result.Constraints.Valid.Constraint createResultConstraintsValidConstraint() {
        return new Result.Constraints.Valid.Constraint();
    }

    /**
     * Create an instance of {@link Result.Constraints.NonValid.Constraint }
     * 
     */
    public Result.Constraints.NonValid.Constraint createResultConstraintsNonValidConstraint() {
        return new Result.Constraints.NonValid.Constraint();
    }

}
