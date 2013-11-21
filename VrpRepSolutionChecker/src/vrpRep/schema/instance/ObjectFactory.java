//
// Ce fichier a �t� g�n�r� par l'impl�mentation de r�f�rence JavaTM Architecture for XML Binding (JAXB), v2.2.5-2 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apport�e � ce fichier sera perdue lors de la recompilation du sch�ma source. 
// G�n�r� le : 2012.07.18 � 10:55:38 AM CEST 
//


package vrpRep.schema.instance;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the vroom.common.modeling.vrprep package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: vroom.common.modeling.vrprep
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Location }
     * 
     */
    public Location createLocation() {
        return new Location();
    }

    /**
     * Create an instance of {@link Tw }
     * 
     */
    public Tw createTw() {
        return new Tw();
    }

    /**
     * Create an instance of {@link SpeedProfile }
     * 
     */
    public SpeedProfile createSpeedProfile() {
        return new SpeedProfile();
    }

    /**
     * Create an instance of {@link Instance }
     * 
     */
    public Instance createInstance() {
        return new Instance();
    }

    /**
     * Create an instance of {@link Instance.Requests }
     * 
     */
    public Instance.Requests createInstanceRequests() {
        return new Instance.Requests();
    }

    /**
     * Create an instance of {@link Instance.Requests.Request }
     * 
     */
    public Instance.Requests.Request createInstanceRequestsRequest() {
        return new Instance.Requests.Request();
    }

    /**
     * Create an instance of {@link Instance.Fleet }
     * 
     */
    public Instance.Fleet createInstanceFleet() {
        return new Instance.Fleet();
    }

    /**
     * Create an instance of {@link Instance.Fleet.Vehicle }
     * 
     */
    public Instance.Fleet.Vehicle createInstanceFleetVehicle() {
        return new Instance.Fleet.Vehicle();
    }

    /**
     * Create an instance of {@link Instance.Fleet.Vehicle.WorkloadProfile }
     * 
     */
    public Instance.Fleet.Vehicle.WorkloadProfile createInstanceFleetVehicleWorkloadProfile() {
        return new Instance.Fleet.Vehicle.WorkloadProfile();
    }

    /**
     * Create an instance of {@link Instance.Network }
     * 
     */
    public Instance.Network createInstanceNetwork() {
        return new Instance.Network();
    }

    /**
     * Create an instance of {@link Instance.Network.Links }
     * 
     */
    public Instance.Network.Links createInstanceNetworkLinks() {
        return new Instance.Network.Links();
    }

    /**
     * Create an instance of {@link Instance.Network.Nodes }
     * 
     */
    public Instance.Network.Nodes createInstanceNetworkNodes() {
        return new Instance.Network.Nodes();
    }

    /**
     * Create an instance of {@link Instance.Info }
     * 
     */
    public Instance.Info createInstanceInfo() {
        return new Instance.Info();
    }

    /**
     * Create an instance of {@link PoissonVariable }
     * 
     */
    public PoissonVariable createPoissonVariable() {
        return new PoissonVariable();
    }

    /**
     * Create an instance of {@link Skill }
     * 
     */
    public Skill createSkill() {
        return new Skill();
    }

    /**
     * Create an instance of {@link Location.Euclidean }
     * 
     */
    public Location.Euclidean createLocationEuclidean() {
        return new Location.Euclidean();
    }

    /**
     * Create an instance of {@link Location.GPSCoordinates }
     * 
     */
    public Location.GPSCoordinates createLocationGPSCoordinates() {
        return new Location.GPSCoordinates();
    }

    /**
     * Create an instance of {@link Custom }
     * 
     */
    public Custom createCustom() {
        return new Custom();
    }

    /**
     * Create an instance of {@link Tw.Start }
     * 
     */
    public Tw.Start createTwStart() {
        return new Tw.Start();
    }

    /**
     * Create an instance of {@link Tw.End }
     * 
     */
    public Tw.End createTwEnd() {
        return new Tw.End();
    }

    /**
     * Create an instance of {@link Tool }
     * 
     */
    public Tool createTool() {
        return new Tool();
    }

    /**
     * Create an instance of {@link SpeedProfile.SpeedInterval }
     * 
     */
    public SpeedProfile.SpeedInterval createSpeedProfileSpeedInterval() {
        return new SpeedProfile.SpeedInterval();
    }

    /**
     * Create an instance of {@link Compartment }
     * 
     */
    public Compartment createCompartment() {
        return new Compartment();
    }

    /**
     * Create an instance of {@link NormalVariable }
     * 
     */
    public NormalVariable createNormalVariable() {
        return new NormalVariable();
    }

    /**
     * Create an instance of {@link Demand }
     * 
     */
    public Demand createDemand() {
        return new Demand();
    }

    /**
     * Create an instance of {@link Time }
     * 
     */
    public Time createTime() {
        return new Time();
    }

    /**
     * Create an instance of {@link Instance.Requests.Request.Predecessors }
     * 
     */
    public Instance.Requests.Request.Predecessors createInstanceRequestsRequestPredecessors() {
        return new Instance.Requests.Request.Predecessors();
    }

    /**
     * Create an instance of {@link Instance.Requests.Request.Successors }
     * 
     */
    public Instance.Requests.Request.Successors createInstanceRequestsRequestSuccessors() {
        return new Instance.Requests.Request.Successors();
    }

    /**
     * Create an instance of {@link Instance.Fleet.Vehicle.MaxTravelDistance }
     * 
     */
    public Instance.Fleet.Vehicle.MaxTravelDistance createInstanceFleetVehicleMaxTravelDistance() {
        return new Instance.Fleet.Vehicle.MaxTravelDistance();
    }

    /**
     * Create an instance of {@link Instance.Fleet.Vehicle.MaxRequests }
     * 
     */
    public Instance.Fleet.Vehicle.MaxRequests createInstanceFleetVehicleMaxRequests() {
        return new Instance.Fleet.Vehicle.MaxRequests();
    }

    /**
     * Create an instance of {@link Instance.Fleet.Vehicle.WorkloadProfile.MaxWorkTime }
     * 
     */
    public Instance.Fleet.Vehicle.WorkloadProfile.MaxWorkTime createInstanceFleetVehicleWorkloadProfileMaxWorkTime() {
        return new Instance.Fleet.Vehicle.WorkloadProfile.MaxWorkTime();
    }

    /**
     * Create an instance of {@link Instance.Network.Descriptor }
     * 
     */
    public Instance.Network.Descriptor createInstanceNetworkDescriptor() {
        return new Instance.Network.Descriptor();
    }

    /**
     * Create an instance of {@link Instance.Network.Links.Link }
     * 
     */
    public Instance.Network.Links.Link createInstanceNetworkLinksLink() {
        return new Instance.Network.Links.Link();
    }

    /**
     * Create an instance of {@link Instance.Network.Nodes.Node }
     * 
     */
    public Instance.Network.Nodes.Node createInstanceNetworkNodesNode() {
        return new Instance.Network.Nodes.Node();
    }

    /**
     * Create an instance of {@link Instance.Info.Contributor }
     * 
     */
    public Instance.Info.Contributor createInstanceInfoContributor() {
        return new Instance.Info.Contributor();
    }

}
