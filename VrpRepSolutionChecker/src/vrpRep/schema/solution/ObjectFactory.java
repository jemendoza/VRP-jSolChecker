//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.5-2 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2014.01.19 à 06:49:45 PM CET 
//


package vrpRep.schema.solution;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


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

    private final static QName _SolutionRoutesRouteRequestDemand_QNAME = new QName("", "demand");

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
     * Create an instance of {@link Solution.Routes.Route.Request }
     * 
     */
    public Solution.Routes.Route.Request createSolutionRoutesRouteRequest() {
        return new Solution.Routes.Route.Request();
    }

    /**
     * Create an instance of {@link Solution.Info }
     * 
     */
    public Solution.Info createSolutionInfo() {
        return new Solution.Info();
    }

    /**
     * Create an instance of {@link Solution.ObjectiveFunction }
     * 
     */
    public Solution.ObjectiveFunction createSolutionObjectiveFunction() {
        return new Solution.ObjectiveFunction();
    }

    /**
     * Create an instance of {@link Solution.Routes.Route.Request.Demand }
     * 
     */
    public Solution.Routes.Route.Request.Demand createSolutionRoutesRouteRequestDemand() {
        return new Solution.Routes.Route.Request.Demand();
    }

    /**
     * Create an instance of {@link Solution.Info.Contributor }
     * 
     */
    public Solution.Info.Contributor createSolutionInfoContributor() {
        return new Solution.Info.Contributor();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Solution.Routes.Route.Request.Demand }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "demand", scope = Solution.Routes.Route.Request.class)
    public JAXBElement<Solution.Routes.Route.Request.Demand> createSolutionRoutesRouteRequestDemand(Solution.Routes.Route.Request.Demand value) {
        return new JAXBElement<Solution.Routes.Route.Request.Demand>(_SolutionRoutesRouteRequestDemand_QNAME, Solution.Routes.Route.Request.Demand.class, Solution.Routes.Route.Request.class, value);
    }

}
