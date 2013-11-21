//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.5-2 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2013.11.21 à 03:08:03 PM CET 
//


package vrpRep.schema.solution;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the vrpRep.schema.solution package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: vrpRep.schema.solution
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Solution }
     * 
     */
    public Solution createSolution() {
        return new Solution();
    }

    /**
     * Create an instance of {@link Solution.Routes }
     * 
     */
    public Solution.Routes createSolutionRoutes() {
        return new Solution.Routes();
    }

    /**
     * Create an instance of {@link Solution.Routes.Route }
     * 
     */
    public Solution.Routes.Route createSolutionRoutesRoute() {
        return new Solution.Routes.Route();
    }

    /**
     * Create an instance of {@link Solution.Info }
     * 
     */
    public Solution.Info createSolutionInfo() {
        return new Solution.Info();
    }

    /**
     * Create an instance of {@link Solution.Routes.Route.Node }
     * 
     */
    public Solution.Routes.Route.Node createSolutionRoutesRouteNode() {
        return new Solution.Routes.Route.Node();
    }

    /**
     * Create an instance of {@link Solution.Info.Contributor }
     * 
     */
    public Solution.Info.Contributor createSolutionInfoContributor() {
        return new Solution.Info.Contributor();
    }

}
