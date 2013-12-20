//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.5-2 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2013.12.20 à 12:01:55 PM CET 
//


package vrpRep.schema.instance;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="info">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="problem" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="reference" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="contributor">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="email">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;pattern value="[^@]+@[^\.]+\..+"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="network">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="nodes">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="node" maxOccurs="unbounded">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element ref="{}location" minOccurs="0"/>
 *                                       &lt;element ref="{}custom" minOccurs="0"/>
 *                                     &lt;/sequence>
 *                                     &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                                     &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="links" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="link" maxOccurs="unbounded">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="cost" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *                                       &lt;element name="length" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *                                       &lt;element name="time" type="{}_time" minOccurs="0"/>
 *                                       &lt;element ref="{}custom" minOccurs="0"/>
 *                                     &lt;/sequence>
 *                                     &lt;attribute name="tail" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                                     &lt;attribute name="head" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                                     &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                                     &lt;attribute name="directed" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *                                     &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="descriptor">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="isComplete" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                             &lt;element name="distanceType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="roundingRule" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element ref="{}custom" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="fleet">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="vehicle" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="fixedCost" type="{http://www.w3.org/2001/XMLSchema}double" maxOccurs="unbounded" minOccurs="0"/>
 *                             &lt;element name="variableCost" type="{http://www.w3.org/2001/XMLSchema}double" maxOccurs="unbounded" minOccurs="0"/>
 *                             &lt;element name="number" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *                             &lt;element name="nodeTypesCompatible" type="{http://www.w3.org/2001/XMLSchema}integer" maxOccurs="unbounded" minOccurs="0"/>
 *                             &lt;element ref="{}speedProfile" minOccurs="0"/>
 *                             &lt;element name="maxTravelDistance" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;attribute name="isFlexible" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="maxRequests" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;attribute name="isFlexible" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="workloadProfile" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="maxWorkTime" minOccurs="0">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;attribute name="isFlexible" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element ref="{}tw" maxOccurs="unbounded" minOccurs="0"/>
 *                                       &lt;element ref="{}custom" minOccurs="0"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="capacity" type="{http://www.w3.org/2001/XMLSchema}double" maxOccurs="unbounded" minOccurs="0"/>
 *                             &lt;element ref="{}compartment" maxOccurs="unbounded" minOccurs="0"/>
 *                             &lt;element name="departureNode" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *                             &lt;element name="arrivalNode" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *                             &lt;element ref="{}skill" maxOccurs="unbounded" minOccurs="0"/>
 *                             &lt;element ref="{}tool" maxOccurs="unbounded" minOccurs="0"/>
 *                             &lt;element ref="{}custom" minOccurs="0"/>
 *                           &lt;/sequence>
 *                           &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="requests">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="request" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element ref="{}tw" maxOccurs="unbounded" minOccurs="0"/>
 *                             &lt;element ref="{}demand" maxOccurs="unbounded" minOccurs="0"/>
 *                             &lt;element name="prize" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *                             &lt;element name="cost" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *                             &lt;element name="releaseDate" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *                             &lt;element name="serviceTime" type="{}_time" minOccurs="0"/>
 *                             &lt;element name="predecessors" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="request" type="{http://www.w3.org/2001/XMLSchema}integer" maxOccurs="unbounded"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="successors" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="request" type="{http://www.w3.org/2001/XMLSchema}integer" maxOccurs="unbounded"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element ref="{}skill" maxOccurs="unbounded" minOccurs="0"/>
 *                             &lt;element ref="{}tool" maxOccurs="unbounded" minOccurs="0"/>
 *                             &lt;element ref="{}custom" minOccurs="0"/>
 *                           &lt;/sequence>
 *                           &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                           &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                           &lt;attribute name="node" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                           &lt;attribute name="link" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
@XmlRootElement(name = "instance")
public class Instance {

    @XmlElement(required = true)
    protected Instance.Info info;
    @XmlElement(required = true)
    protected Instance.Network network;
    @XmlElement(required = true)
    protected Instance.Fleet fleet;
    @XmlElement(required = true)
    protected Instance.Requests requests;

    /**
     * Obtient la valeur de la propriété info.
     * 
     * @return
     *     possible object is
     *     {@link Instance.Info }
     *     
     */
    public Instance.Info getInfo() {
        return info;
    }

    /**
     * Définit la valeur de la propriété info.
     * 
     * @param value
     *     allowed object is
     *     {@link Instance.Info }
     *     
     */
    public void setInfo(Instance.Info value) {
        this.info = value;
    }

    /**
     * Obtient la valeur de la propriété network.
     * 
     * @return
     *     possible object is
     *     {@link Instance.Network }
     *     
     */
    public Instance.Network getNetwork() {
        return network;
    }

    /**
     * Définit la valeur de la propriété network.
     * 
     * @param value
     *     allowed object is
     *     {@link Instance.Network }
     *     
     */
    public void setNetwork(Instance.Network value) {
        this.network = value;
    }

    /**
     * Obtient la valeur de la propriété fleet.
     * 
     * @return
     *     possible object is
     *     {@link Instance.Fleet }
     *     
     */
    public Instance.Fleet getFleet() {
        return fleet;
    }

    /**
     * Définit la valeur de la propriété fleet.
     * 
     * @param value
     *     allowed object is
     *     {@link Instance.Fleet }
     *     
     */
    public void setFleet(Instance.Fleet value) {
        this.fleet = value;
    }

    /**
     * Obtient la valeur de la propriété requests.
     * 
     * @return
     *     possible object is
     *     {@link Instance.Requests }
     *     
     */
    public Instance.Requests getRequests() {
        return requests;
    }

    /**
     * Définit la valeur de la propriété requests.
     * 
     * @param value
     *     allowed object is
     *     {@link Instance.Requests }
     *     
     */
    public void setRequests(Instance.Requests value) {
        this.requests = value;
    }


    /**
     * <p>Classe Java pour anonymous complex type.
     * 
     * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="vehicle" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="fixedCost" type="{http://www.w3.org/2001/XMLSchema}double" maxOccurs="unbounded" minOccurs="0"/>
     *                   &lt;element name="variableCost" type="{http://www.w3.org/2001/XMLSchema}double" maxOccurs="unbounded" minOccurs="0"/>
     *                   &lt;element name="number" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
     *                   &lt;element name="nodeTypesCompatible" type="{http://www.w3.org/2001/XMLSchema}integer" maxOccurs="unbounded" minOccurs="0"/>
     *                   &lt;element ref="{}speedProfile" minOccurs="0"/>
     *                   &lt;element name="maxTravelDistance" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;attribute name="isFlexible" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="maxRequests" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;attribute name="isFlexible" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="workloadProfile" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="maxWorkTime" minOccurs="0">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;attribute name="isFlexible" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                             &lt;element ref="{}tw" maxOccurs="unbounded" minOccurs="0"/>
     *                             &lt;element ref="{}custom" minOccurs="0"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="capacity" type="{http://www.w3.org/2001/XMLSchema}double" maxOccurs="unbounded" minOccurs="0"/>
     *                   &lt;element ref="{}compartment" maxOccurs="unbounded" minOccurs="0"/>
     *                   &lt;element name="departureNode" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
     *                   &lt;element name="arrivalNode" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
     *                   &lt;element ref="{}skill" maxOccurs="unbounded" minOccurs="0"/>
     *                   &lt;element ref="{}tool" maxOccurs="unbounded" minOccurs="0"/>
     *                   &lt;element ref="{}custom" minOccurs="0"/>
     *                 &lt;/sequence>
     *                 &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "vehicle"
    })
    public static class Fleet {

        @XmlElement(required = true)
        protected List<Instance.Fleet.Vehicle> vehicle;

        /**
         * Gets the value of the vehicle property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the vehicle property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getVehicle().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Instance.Fleet.Vehicle }
         * 
         * 
         */
        public List<Instance.Fleet.Vehicle> getVehicle() {
            if (vehicle == null) {
                vehicle = new ArrayList<Instance.Fleet.Vehicle>();
            }
            return this.vehicle;
        }


        /**
         * <p>Classe Java pour anonymous complex type.
         * 
         * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="fixedCost" type="{http://www.w3.org/2001/XMLSchema}double" maxOccurs="unbounded" minOccurs="0"/>
         *         &lt;element name="variableCost" type="{http://www.w3.org/2001/XMLSchema}double" maxOccurs="unbounded" minOccurs="0"/>
         *         &lt;element name="number" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
         *         &lt;element name="nodeTypesCompatible" type="{http://www.w3.org/2001/XMLSchema}integer" maxOccurs="unbounded" minOccurs="0"/>
         *         &lt;element ref="{}speedProfile" minOccurs="0"/>
         *         &lt;element name="maxTravelDistance" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;attribute name="isFlexible" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="maxRequests" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;attribute name="isFlexible" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="workloadProfile" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="maxWorkTime" minOccurs="0">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;attribute name="isFlexible" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                   &lt;element ref="{}tw" maxOccurs="unbounded" minOccurs="0"/>
         *                   &lt;element ref="{}custom" minOccurs="0"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="capacity" type="{http://www.w3.org/2001/XMLSchema}double" maxOccurs="unbounded" minOccurs="0"/>
         *         &lt;element ref="{}compartment" maxOccurs="unbounded" minOccurs="0"/>
         *         &lt;element name="departureNode" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
         *         &lt;element name="arrivalNode" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
         *         &lt;element ref="{}skill" maxOccurs="unbounded" minOccurs="0"/>
         *         &lt;element ref="{}tool" maxOccurs="unbounded" minOccurs="0"/>
         *         &lt;element ref="{}custom" minOccurs="0"/>
         *       &lt;/sequence>
         *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}integer" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "fixedCost",
            "variableCost",
            "number",
            "nodeTypesCompatible",
            "speedProfile",
            "maxTravelDistance",
            "maxRequests",
            "workloadProfile",
            "capacity",
            "compartment",
            "departureNode",
            "arrivalNode",
            "skill",
            "tool",
            "custom"
        })
        public static class Vehicle {

            @XmlElement(type = Double.class)
            protected List<Double> fixedCost;
            @XmlElement(type = Double.class)
            protected List<Double> variableCost;
            protected BigInteger number;
            protected List<BigInteger> nodeTypesCompatible;
            protected SpeedProfile speedProfile;
            protected Instance.Fleet.Vehicle.MaxTravelDistance maxTravelDistance;
            protected Instance.Fleet.Vehicle.MaxRequests maxRequests;
            protected Instance.Fleet.Vehicle.WorkloadProfile workloadProfile;
            @XmlElement(type = Double.class)
            protected List<Double> capacity;
            protected List<Compartment> compartment;
            protected BigInteger departureNode;
            protected BigInteger arrivalNode;
            protected List<Skill> skill;
            protected List<Tool> tool;
            protected Custom custom;
            @XmlAttribute(name = "type")
            protected BigInteger type;

            /**
             * Gets the value of the fixedCost property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the fixedCost property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getFixedCost().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Double }
             * 
             * 
             */
            public List<Double> getFixedCost() {
                if (fixedCost == null) {
                    fixedCost = new ArrayList<Double>();
                }
                return this.fixedCost;
            }

            /**
             * Gets the value of the variableCost property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the variableCost property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getVariableCost().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Double }
             * 
             * 
             */
            public List<Double> getVariableCost() {
                if (variableCost == null) {
                    variableCost = new ArrayList<Double>();
                }
                return this.variableCost;
            }

            /**
             * Obtient la valeur de la propriété number.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getNumber() {
                return number;
            }

            /**
             * Définit la valeur de la propriété number.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setNumber(BigInteger value) {
                this.number = value;
            }

            /**
             * Gets the value of the nodeTypesCompatible property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the nodeTypesCompatible property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getNodeTypesCompatible().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link BigInteger }
             * 
             * 
             */
            public List<BigInteger> getNodeTypesCompatible() {
                if (nodeTypesCompatible == null) {
                    nodeTypesCompatible = new ArrayList<BigInteger>();
                }
                return this.nodeTypesCompatible;
            }

            /**
             * Speed caracteristics of the vehicle
             * 
             * @return
             *     possible object is
             *     {@link SpeedProfile }
             *     
             */
            public SpeedProfile getSpeedProfile() {
                return speedProfile;
            }

            /**
             * Définit la valeur de la propriété speedProfile.
             * 
             * @param value
             *     allowed object is
             *     {@link SpeedProfile }
             *     
             */
            public void setSpeedProfile(SpeedProfile value) {
                this.speedProfile = value;
            }

            /**
             * Obtient la valeur de la propriété maxTravelDistance.
             * 
             * @return
             *     possible object is
             *     {@link Instance.Fleet.Vehicle.MaxTravelDistance }
             *     
             */
            public Instance.Fleet.Vehicle.MaxTravelDistance getMaxTravelDistance() {
                return maxTravelDistance;
            }

            /**
             * Définit la valeur de la propriété maxTravelDistance.
             * 
             * @param value
             *     allowed object is
             *     {@link Instance.Fleet.Vehicle.MaxTravelDistance }
             *     
             */
            public void setMaxTravelDistance(Instance.Fleet.Vehicle.MaxTravelDistance value) {
                this.maxTravelDistance = value;
            }

            /**
             * Obtient la valeur de la propriété maxRequests.
             * 
             * @return
             *     possible object is
             *     {@link Instance.Fleet.Vehicle.MaxRequests }
             *     
             */
            public Instance.Fleet.Vehicle.MaxRequests getMaxRequests() {
                return maxRequests;
            }

            /**
             * Définit la valeur de la propriété maxRequests.
             * 
             * @param value
             *     allowed object is
             *     {@link Instance.Fleet.Vehicle.MaxRequests }
             *     
             */
            public void setMaxRequests(Instance.Fleet.Vehicle.MaxRequests value) {
                this.maxRequests = value;
            }

            /**
             * Obtient la valeur de la propriété workloadProfile.
             * 
             * @return
             *     possible object is
             *     {@link Instance.Fleet.Vehicle.WorkloadProfile }
             *     
             */
            public Instance.Fleet.Vehicle.WorkloadProfile getWorkloadProfile() {
                return workloadProfile;
            }

            /**
             * Définit la valeur de la propriété workloadProfile.
             * 
             * @param value
             *     allowed object is
             *     {@link Instance.Fleet.Vehicle.WorkloadProfile }
             *     
             */
            public void setWorkloadProfile(Instance.Fleet.Vehicle.WorkloadProfile value) {
                this.workloadProfile = value;
            }

            /**
             * Gets the value of the capacity property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the capacity property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getCapacity().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Double }
             * 
             * 
             */
            public List<Double> getCapacity() {
                if (capacity == null) {
                    capacity = new ArrayList<Double>();
                }
                return this.capacity;
            }

            /**
             * Vehicle compartment capacities Gets the value of the compartment property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the compartment property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getCompartment().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Compartment }
             * 
             * 
             */
            public List<Compartment> getCompartment() {
                if (compartment == null) {
                    compartment = new ArrayList<Compartment>();
                }
                return this.compartment;
            }

            /**
             * Obtient la valeur de la propriété departureNode.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getDepartureNode() {
                return departureNode;
            }

            /**
             * Définit la valeur de la propriété departureNode.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setDepartureNode(BigInteger value) {
                this.departureNode = value;
            }

            /**
             * Obtient la valeur de la propriété arrivalNode.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getArrivalNode() {
                return arrivalNode;
            }

            /**
             * Définit la valeur de la propriété arrivalNode.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setArrivalNode(BigInteger value) {
                this.arrivalNode = value;
            }

            /**
             * Gets the value of the skill property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the skill property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getSkill().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Skill }
             * 
             * 
             */
            public List<Skill> getSkill() {
                if (skill == null) {
                    skill = new ArrayList<Skill>();
                }
                return this.skill;
            }

            /**
             * Gets the value of the tool property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the tool property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getTool().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Tool }
             * 
             * 
             */
            public List<Tool> getTool() {
                if (tool == null) {
                    tool = new ArrayList<Tool>();
                }
                return this.tool;
            }

            /**
             * Obtient la valeur de la propriété custom.
             * 
             * @return
             *     possible object is
             *     {@link Custom }
             *     
             */
            public Custom getCustom() {
                return custom;
            }

            /**
             * Définit la valeur de la propriété custom.
             * 
             * @param value
             *     allowed object is
             *     {@link Custom }
             *     
             */
            public void setCustom(Custom value) {
                this.custom = value;
            }

            /**
             * Obtient la valeur de la propriété type.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getType() {
                return type;
            }

            /**
             * Définit la valeur de la propriété type.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setType(BigInteger value) {
                this.type = value;
            }


            /**
             * <p>Classe Java pour anonymous complex type.
             * 
             * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;attribute name="isFlexible" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "content"
            })
            public static class MaxRequests {

                @XmlValue
                protected String content;
                @XmlAttribute(name = "isFlexible")
                protected Boolean isFlexible;

                /**
                 * Obtient la valeur de la propriété content.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getContent() {
                    return content;
                }

                /**
                 * Définit la valeur de la propriété content.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setContent(String value) {
                    this.content = value;
                }

                /**
                 * Obtient la valeur de la propriété isFlexible.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Boolean }
                 *     
                 */
                public boolean isIsFlexible() {
                    if (isFlexible == null) {
                        return false;
                    } else {
                        return isFlexible;
                    }
                }

                /**
                 * Définit la valeur de la propriété isFlexible.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Boolean }
                 *     
                 */
                public void setIsFlexible(Boolean value) {
                    this.isFlexible = value;
                }

            }


            /**
             * <p>Classe Java pour anonymous complex type.
             * 
             * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;attribute name="isFlexible" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "content"
            })
            public static class MaxTravelDistance {

                @XmlValue
                protected String content;
                @XmlAttribute(name = "isFlexible")
                protected Boolean isFlexible;

                /**
                 * Obtient la valeur de la propriété content.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getContent() {
                    return content;
                }

                /**
                 * Définit la valeur de la propriété content.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setContent(String value) {
                    this.content = value;
                }

                /**
                 * Obtient la valeur de la propriété isFlexible.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Boolean }
                 *     
                 */
                public boolean isIsFlexible() {
                    if (isFlexible == null) {
                        return false;
                    } else {
                        return isFlexible;
                    }
                }

                /**
                 * Définit la valeur de la propriété isFlexible.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Boolean }
                 *     
                 */
                public void setIsFlexible(Boolean value) {
                    this.isFlexible = value;
                }

            }


            /**
             * <p>Classe Java pour anonymous complex type.
             * 
             * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="maxWorkTime" minOccurs="0">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;attribute name="isFlexible" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *         &lt;element ref="{}tw" maxOccurs="unbounded" minOccurs="0"/>
             *         &lt;element ref="{}custom" minOccurs="0"/>
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "maxWorkTime",
                "tw",
                "custom"
            })
            public static class WorkloadProfile {

                protected Instance.Fleet.Vehicle.WorkloadProfile.MaxWorkTime maxWorkTime;
                protected List<Tw> tw;
                protected Custom custom;

                /**
                 * Obtient la valeur de la propriété maxWorkTime.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Instance.Fleet.Vehicle.WorkloadProfile.MaxWorkTime }
                 *     
                 */
                public Instance.Fleet.Vehicle.WorkloadProfile.MaxWorkTime getMaxWorkTime() {
                    return maxWorkTime;
                }

                /**
                 * Définit la valeur de la propriété maxWorkTime.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Instance.Fleet.Vehicle.WorkloadProfile.MaxWorkTime }
                 *     
                 */
                public void setMaxWorkTime(Instance.Fleet.Vehicle.WorkloadProfile.MaxWorkTime value) {
                    this.maxWorkTime = value;
                }

                /**
                 * Time windows. May model either breaks or availability times Gets the value of the tw property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the tw property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getTw().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link Tw }
                 * 
                 * 
                 */
                public List<Tw> getTw() {
                    if (tw == null) {
                        tw = new ArrayList<Tw>();
                    }
                    return this.tw;
                }

                /**
                 * Obtient la valeur de la propriété custom.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Custom }
                 *     
                 */
                public Custom getCustom() {
                    return custom;
                }

                /**
                 * Définit la valeur de la propriété custom.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Custom }
                 *     
                 */
                public void setCustom(Custom value) {
                    this.custom = value;
                }


                /**
                 * <p>Classe Java pour anonymous complex type.
                 * 
                 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;complexContent>
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *       &lt;attribute name="isFlexible" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "content"
                })
                public static class MaxWorkTime {

                    @XmlValue
                    protected String content;
                    @XmlAttribute(name = "isFlexible")
                    protected Boolean isFlexible;

                    /**
                     * Obtient la valeur de la propriété content.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getContent() {
                        return content;
                    }

                    /**
                     * Définit la valeur de la propriété content.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setContent(String value) {
                        this.content = value;
                    }

                    /**
                     * Obtient la valeur de la propriété isFlexible.
                     * 
                     * @return
                     *     possible object is
                     *     {@link Boolean }
                     *     
                     */
                    public boolean isIsFlexible() {
                        if (isFlexible == null) {
                            return false;
                        } else {
                            return isFlexible;
                        }
                    }

                    /**
                     * Définit la valeur de la propriété isFlexible.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link Boolean }
                     *     
                     */
                    public void setIsFlexible(Boolean value) {
                        this.isFlexible = value;
                    }

                }

            }

        }

    }


    /**
     * <p>Classe Java pour anonymous complex type.
     * 
     * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="problem" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="reference" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="contributor">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="email">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;pattern value="[^@]+@[^\.]+\..+"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "name",
        "problem",
        "reference",
        "contributor"
    })
    public static class Info {

        @XmlElement(required = true)
        protected String name;
        @XmlElement(required = true)
        protected String problem;
        @XmlElement(required = true)
        protected String reference;
        @XmlElement(required = true)
        protected Instance.Info.Contributor contributor;

        /**
         * Obtient la valeur de la propriété name.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
            return name;
        }

        /**
         * Définit la valeur de la propriété name.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setName(String value) {
            this.name = value;
        }

        /**
         * Obtient la valeur de la propriété problem.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getProblem() {
            return problem;
        }

        /**
         * Définit la valeur de la propriété problem.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setProblem(String value) {
            this.problem = value;
        }

        /**
         * Obtient la valeur de la propriété reference.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getReference() {
            return reference;
        }

        /**
         * Définit la valeur de la propriété reference.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setReference(String value) {
            this.reference = value;
        }

        /**
         * Obtient la valeur de la propriété contributor.
         * 
         * @return
         *     possible object is
         *     {@link Instance.Info.Contributor }
         *     
         */
        public Instance.Info.Contributor getContributor() {
            return contributor;
        }

        /**
         * Définit la valeur de la propriété contributor.
         * 
         * @param value
         *     allowed object is
         *     {@link Instance.Info.Contributor }
         *     
         */
        public void setContributor(Instance.Info.Contributor value) {
            this.contributor = value;
        }


        /**
         * <p>Classe Java pour anonymous complex type.
         * 
         * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="email">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;pattern value="[^@]+@[^\.]+\..+"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "name",
            "email"
        })
        public static class Contributor {

            @XmlElement(required = true)
            protected String name;
            @XmlElement(required = true)
            protected String email;

            /**
             * Obtient la valeur de la propriété name.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getName() {
                return name;
            }

            /**
             * Définit la valeur de la propriété name.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setName(String value) {
                this.name = value;
            }

            /**
             * Obtient la valeur de la propriété email.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getEmail() {
                return email;
            }

            /**
             * Définit la valeur de la propriété email.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setEmail(String value) {
                this.email = value;
            }

        }

    }


    /**
     * <p>Classe Java pour anonymous complex type.
     * 
     * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="nodes">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="node" maxOccurs="unbounded">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element ref="{}location" minOccurs="0"/>
     *                             &lt;element ref="{}custom" minOccurs="0"/>
     *                           &lt;/sequence>
     *                           &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *                           &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="links" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="link" maxOccurs="unbounded">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="cost" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
     *                             &lt;element name="length" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
     *                             &lt;element name="time" type="{}_time" minOccurs="0"/>
     *                             &lt;element ref="{}custom" minOccurs="0"/>
     *                           &lt;/sequence>
     *                           &lt;attribute name="tail" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *                           &lt;attribute name="head" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *                           &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *                           &lt;attribute name="directed" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
     *                           &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="descriptor">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="isComplete" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
     *                   &lt;element name="distanceType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="roundingRule" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element ref="{}custom" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "nodes",
        "links",
        "descriptor"
    })
    public static class Network {

        @XmlElement(required = true)
        protected Instance.Network.Nodes nodes;
        protected Instance.Network.Links links;
        @XmlElement(required = true)
        protected Instance.Network.Descriptor descriptor;

        /**
         * Obtient la valeur de la propriété nodes.
         * 
         * @return
         *     possible object is
         *     {@link Instance.Network.Nodes }
         *     
         */
        public Instance.Network.Nodes getNodes() {
            return nodes;
        }

        /**
         * Définit la valeur de la propriété nodes.
         * 
         * @param value
         *     allowed object is
         *     {@link Instance.Network.Nodes }
         *     
         */
        public void setNodes(Instance.Network.Nodes value) {
            this.nodes = value;
        }

        /**
         * Obtient la valeur de la propriété links.
         * 
         * @return
         *     possible object is
         *     {@link Instance.Network.Links }
         *     
         */
        public Instance.Network.Links getLinks() {
            return links;
        }

        /**
         * Définit la valeur de la propriété links.
         * 
         * @param value
         *     allowed object is
         *     {@link Instance.Network.Links }
         *     
         */
        public void setLinks(Instance.Network.Links value) {
            this.links = value;
        }

        /**
         * Obtient la valeur de la propriété descriptor.
         * 
         * @return
         *     possible object is
         *     {@link Instance.Network.Descriptor }
         *     
         */
        public Instance.Network.Descriptor getDescriptor() {
            return descriptor;
        }

        /**
         * Définit la valeur de la propriété descriptor.
         * 
         * @param value
         *     allowed object is
         *     {@link Instance.Network.Descriptor }
         *     
         */
        public void setDescriptor(Instance.Network.Descriptor value) {
            this.descriptor = value;
        }


        /**
         * <p>Classe Java pour anonymous complex type.
         * 
         * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="isComplete" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
         *         &lt;element name="distanceType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="roundingRule" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element ref="{}custom" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "isComplete",
            "distanceType",
            "roundingRule",
            "custom"
        })
        public static class Descriptor {

            @XmlElement(defaultValue = "false")
            protected Boolean isComplete;
            protected String distanceType;
            protected String roundingRule;
            protected Custom custom;

            /**
             * Obtient la valeur de la propriété isComplete.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public Boolean isIsComplete() {
                return isComplete;
            }

            /**
             * Définit la valeur de la propriété isComplete.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setIsComplete(Boolean value) {
                this.isComplete = value;
            }

            /**
             * Obtient la valeur de la propriété distanceType.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDistanceType() {
                return distanceType;
            }

            /**
             * Définit la valeur de la propriété distanceType.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDistanceType(String value) {
                this.distanceType = value;
            }

            /**
             * Obtient la valeur de la propriété roundingRule.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRoundingRule() {
                return roundingRule;
            }

            /**
             * Définit la valeur de la propriété roundingRule.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRoundingRule(String value) {
                this.roundingRule = value;
            }

            /**
             * Obtient la valeur de la propriété custom.
             * 
             * @return
             *     possible object is
             *     {@link Custom }
             *     
             */
            public Custom getCustom() {
                return custom;
            }

            /**
             * Définit la valeur de la propriété custom.
             * 
             * @param value
             *     allowed object is
             *     {@link Custom }
             *     
             */
            public void setCustom(Custom value) {
                this.custom = value;
            }

        }


        /**
         * <p>Classe Java pour anonymous complex type.
         * 
         * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="link" maxOccurs="unbounded">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="cost" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
         *                   &lt;element name="length" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
         *                   &lt;element name="time" type="{}_time" minOccurs="0"/>
         *                   &lt;element ref="{}custom" minOccurs="0"/>
         *                 &lt;/sequence>
         *                 &lt;attribute name="tail" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
         *                 &lt;attribute name="head" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
         *                 &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}integer" />
         *                 &lt;attribute name="directed" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
         *                 &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}integer" />
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "link"
        })
        public static class Links {

            @XmlElement(required = true)
            protected List<Instance.Network.Links.Link> link;

            /**
             * Gets the value of the link property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the link property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getLink().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Instance.Network.Links.Link }
             * 
             * 
             */
            public List<Instance.Network.Links.Link> getLink() {
                if (link == null) {
                    link = new ArrayList<Instance.Network.Links.Link>();
                }
                return this.link;
            }


            /**
             * <p>Classe Java pour anonymous complex type.
             * 
             * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="cost" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
             *         &lt;element name="length" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
             *         &lt;element name="time" type="{}_time" minOccurs="0"/>
             *         &lt;element ref="{}custom" minOccurs="0"/>
             *       &lt;/sequence>
             *       &lt;attribute name="tail" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
             *       &lt;attribute name="head" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
             *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}integer" />
             *       &lt;attribute name="directed" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
             *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}integer" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "cost",
                "length",
                "time",
                "custom"
            })
            public static class Link {

                protected Double cost;
                protected Double length;
                protected Time time;
                protected Custom custom;
                @XmlAttribute(name = "tail", required = true)
                protected BigInteger tail;
                @XmlAttribute(name = "head", required = true)
                protected BigInteger head;
                @XmlAttribute(name = "id")
                protected BigInteger id;
                @XmlAttribute(name = "directed")
                protected Boolean directed;
                @XmlAttribute(name = "type")
                protected BigInteger type;

                /**
                 * Obtient la valeur de la propriété cost.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Double }
                 *     
                 */
                public Double getCost() {
                    return cost;
                }

                /**
                 * Définit la valeur de la propriété cost.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Double }
                 *     
                 */
                public void setCost(Double value) {
                    this.cost = value;
                }

                /**
                 * Obtient la valeur de la propriété length.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Double }
                 *     
                 */
                public Double getLength() {
                    return length;
                }

                /**
                 * Définit la valeur de la propriété length.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Double }
                 *     
                 */
                public void setLength(Double value) {
                    this.length = value;
                }

                /**
                 * Obtient la valeur de la propriété time.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Time }
                 *     
                 */
                public Time getTime() {
                    return time;
                }

                /**
                 * Définit la valeur de la propriété time.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Time }
                 *     
                 */
                public void setTime(Time value) {
                    this.time = value;
                }

                /**
                 * Obtient la valeur de la propriété custom.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Custom }
                 *     
                 */
                public Custom getCustom() {
                    return custom;
                }

                /**
                 * Définit la valeur de la propriété custom.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Custom }
                 *     
                 */
                public void setCustom(Custom value) {
                    this.custom = value;
                }

                /**
                 * Obtient la valeur de la propriété tail.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getTail() {
                    return tail;
                }

                /**
                 * Définit la valeur de la propriété tail.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setTail(BigInteger value) {
                    this.tail = value;
                }

                /**
                 * Obtient la valeur de la propriété head.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getHead() {
                    return head;
                }

                /**
                 * Définit la valeur de la propriété head.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setHead(BigInteger value) {
                    this.head = value;
                }

                /**
                 * Obtient la valeur de la propriété id.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getId() {
                    return id;
                }

                /**
                 * Définit la valeur de la propriété id.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setId(BigInteger value) {
                    this.id = value;
                }

                /**
                 * Obtient la valeur de la propriété directed.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Boolean }
                 *     
                 */
                public boolean isDirected() {
                    if (directed == null) {
                        return false;
                    } else {
                        return directed;
                    }
                }

                /**
                 * Définit la valeur de la propriété directed.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Boolean }
                 *     
                 */
                public void setDirected(Boolean value) {
                    this.directed = value;
                }

                /**
                 * Obtient la valeur de la propriété type.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getType() {
                    return type;
                }

                /**
                 * Définit la valeur de la propriété type.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setType(BigInteger value) {
                    this.type = value;
                }

            }

        }


        /**
         * <p>Classe Java pour anonymous complex type.
         * 
         * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="node" maxOccurs="unbounded">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element ref="{}location" minOccurs="0"/>
         *                   &lt;element ref="{}custom" minOccurs="0"/>
         *                 &lt;/sequence>
         *                 &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
         *                 &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}integer" />
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "node"
        })
        public static class Nodes {

            @XmlElement(required = true)
            protected List<Instance.Network.Nodes.Node> node;

            /**
             * Gets the value of the node property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the node property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getNode().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Instance.Network.Nodes.Node }
             * 
             * 
             */
            public List<Instance.Network.Nodes.Node> getNode() {
                if (node == null) {
                    node = new ArrayList<Instance.Network.Nodes.Node>();
                }
                return this.node;
            }


            /**
             * <p>Classe Java pour anonymous complex type.
             * 
             * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element ref="{}location" minOccurs="0"/>
             *         &lt;element ref="{}custom" minOccurs="0"/>
             *       &lt;/sequence>
             *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
             *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}integer" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "location",
                "custom"
            })
            public static class Node {

                protected Location location;
                protected Custom custom;
                @XmlAttribute(name = "id", required = true)
                protected BigInteger id;
                @XmlAttribute(name = "type")
                protected BigInteger type;

                /**
                 * Represents a node location
                 * 
                 * @return
                 *     possible object is
                 *     {@link Location }
                 *     
                 */
                public Location getLocation() {
                    return location;
                }

                /**
                 * Définit la valeur de la propriété location.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Location }
                 *     
                 */
                public void setLocation(Location value) {
                    this.location = value;
                }

                /**
                 * Obtient la valeur de la propriété custom.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Custom }
                 *     
                 */
                public Custom getCustom() {
                    return custom;
                }

                /**
                 * Définit la valeur de la propriété custom.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Custom }
                 *     
                 */
                public void setCustom(Custom value) {
                    this.custom = value;
                }

                /**
                 * Obtient la valeur de la propriété id.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getId() {
                    return id;
                }

                /**
                 * Définit la valeur de la propriété id.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setId(BigInteger value) {
                    this.id = value;
                }

                /**
                 * Obtient la valeur de la propriété type.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getType() {
                    return type;
                }

                /**
                 * Définit la valeur de la propriété type.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setType(BigInteger value) {
                    this.type = value;
                }

            }

        }

    }


    /**
     * <p>Classe Java pour anonymous complex type.
     * 
     * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="request" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element ref="{}tw" maxOccurs="unbounded" minOccurs="0"/>
     *                   &lt;element ref="{}demand" maxOccurs="unbounded" minOccurs="0"/>
     *                   &lt;element name="prize" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
     *                   &lt;element name="cost" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
     *                   &lt;element name="releaseDate" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
     *                   &lt;element name="serviceTime" type="{}_time" minOccurs="0"/>
     *                   &lt;element name="predecessors" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="request" type="{http://www.w3.org/2001/XMLSchema}integer" maxOccurs="unbounded"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="successors" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="request" type="{http://www.w3.org/2001/XMLSchema}integer" maxOccurs="unbounded"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element ref="{}skill" maxOccurs="unbounded" minOccurs="0"/>
     *                   &lt;element ref="{}tool" maxOccurs="unbounded" minOccurs="0"/>
     *                   &lt;element ref="{}custom" minOccurs="0"/>
     *                 &lt;/sequence>
     *                 &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *                 &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *                 &lt;attribute name="node" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *                 &lt;attribute name="link" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "request"
    })
    public static class Requests {

        @XmlElement(required = true)
        protected List<Instance.Requests.Request> request;

        /**
         * Gets the value of the request property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the request property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRequest().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Instance.Requests.Request }
         * 
         * 
         */
        public List<Instance.Requests.Request> getRequest() {
            if (request == null) {
                request = new ArrayList<Instance.Requests.Request>();
            }
            return this.request;
        }


        /**
         * <p>Classe Java pour anonymous complex type.
         * 
         * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element ref="{}tw" maxOccurs="unbounded" minOccurs="0"/>
         *         &lt;element ref="{}demand" maxOccurs="unbounded" minOccurs="0"/>
         *         &lt;element name="prize" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
         *         &lt;element name="cost" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
         *         &lt;element name="releaseDate" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
         *         &lt;element name="serviceTime" type="{}_time" minOccurs="0"/>
         *         &lt;element name="predecessors" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="request" type="{http://www.w3.org/2001/XMLSchema}integer" maxOccurs="unbounded"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="successors" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="request" type="{http://www.w3.org/2001/XMLSchema}integer" maxOccurs="unbounded"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element ref="{}skill" maxOccurs="unbounded" minOccurs="0"/>
         *         &lt;element ref="{}tool" maxOccurs="unbounded" minOccurs="0"/>
         *         &lt;element ref="{}custom" minOccurs="0"/>
         *       &lt;/sequence>
         *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
         *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}integer" />
         *       &lt;attribute name="node" type="{http://www.w3.org/2001/XMLSchema}integer" />
         *       &lt;attribute name="link" type="{http://www.w3.org/2001/XMLSchema}integer" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "tw",
            "demand",
            "prize",
            "cost",
            "releaseDate",
            "serviceTime",
            "predecessors",
            "successors",
            "skill",
            "tool",
            "custom"
        })
        public static class Request {

            protected List<Tw> tw;
            protected List<Demand> demand;
            protected BigInteger prize;
            protected Double cost;
            protected Double releaseDate;
            protected Time serviceTime;
            protected Instance.Requests.Request.Predecessors predecessors;
            protected Instance.Requests.Request.Successors successors;
            protected List<Skill> skill;
            protected List<Tool> tool;
            protected Custom custom;
            @XmlAttribute(name = "id", required = true)
            protected BigInteger id;
            @XmlAttribute(name = "type")
            protected BigInteger type;
            @XmlAttribute(name = "node")
            protected BigInteger node;
            @XmlAttribute(name = "link")
            protected BigInteger link;

            /**
             * Defines a time window Gets the value of the tw property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the tw property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getTw().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Tw }
             * 
             * 
             */
            public List<Tw> getTw() {
                if (tw == null) {
                    tw = new ArrayList<Tw>();
                }
                return this.tw;
            }

            /**
             * Defines a demand (e.g. customer demand) Gets the value of the demand property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the demand property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getDemand().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Demand }
             * 
             * 
             */
            public List<Demand> getDemand() {
                if (demand == null) {
                    demand = new ArrayList<Demand>();
                }
                return this.demand;
            }

            /**
             * Obtient la valeur de la propriété prize.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getPrize() {
                return prize;
            }

            /**
             * Définit la valeur de la propriété prize.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setPrize(BigInteger value) {
                this.prize = value;
            }

            /**
             * Obtient la valeur de la propriété cost.
             * 
             * @return
             *     possible object is
             *     {@link Double }
             *     
             */
            public Double getCost() {
                return cost;
            }

            /**
             * Définit la valeur de la propriété cost.
             * 
             * @param value
             *     allowed object is
             *     {@link Double }
             *     
             */
            public void setCost(Double value) {
                this.cost = value;
            }

            /**
             * Obtient la valeur de la propriété releaseDate.
             * 
             * @return
             *     possible object is
             *     {@link Double }
             *     
             */
            public Double getReleaseDate() {
                return releaseDate;
            }

            /**
             * Définit la valeur de la propriété releaseDate.
             * 
             * @param value
             *     allowed object is
             *     {@link Double }
             *     
             */
            public void setReleaseDate(Double value) {
                this.releaseDate = value;
            }

            /**
             * Obtient la valeur de la propriété serviceTime.
             * 
             * @return
             *     possible object is
             *     {@link Time }
             *     
             */
            public Time getServiceTime() {
                return serviceTime;
            }

            /**
             * Définit la valeur de la propriété serviceTime.
             * 
             * @param value
             *     allowed object is
             *     {@link Time }
             *     
             */
            public void setServiceTime(Time value) {
                this.serviceTime = value;
            }

            /**
             * Obtient la valeur de la propriété predecessors.
             * 
             * @return
             *     possible object is
             *     {@link Instance.Requests.Request.Predecessors }
             *     
             */
            public Instance.Requests.Request.Predecessors getPredecessors() {
                return predecessors;
            }

            /**
             * Définit la valeur de la propriété predecessors.
             * 
             * @param value
             *     allowed object is
             *     {@link Instance.Requests.Request.Predecessors }
             *     
             */
            public void setPredecessors(Instance.Requests.Request.Predecessors value) {
                this.predecessors = value;
            }

            /**
             * Obtient la valeur de la propriété successors.
             * 
             * @return
             *     possible object is
             *     {@link Instance.Requests.Request.Successors }
             *     
             */
            public Instance.Requests.Request.Successors getSuccessors() {
                return successors;
            }

            /**
             * Définit la valeur de la propriété successors.
             * 
             * @param value
             *     allowed object is
             *     {@link Instance.Requests.Request.Successors }
             *     
             */
            public void setSuccessors(Instance.Requests.Request.Successors value) {
                this.successors = value;
            }

            /**
             * Gets the value of the skill property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the skill property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getSkill().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Skill }
             * 
             * 
             */
            public List<Skill> getSkill() {
                if (skill == null) {
                    skill = new ArrayList<Skill>();
                }
                return this.skill;
            }

            /**
             * Gets the value of the tool property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the tool property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getTool().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Tool }
             * 
             * 
             */
            public List<Tool> getTool() {
                if (tool == null) {
                    tool = new ArrayList<Tool>();
                }
                return this.tool;
            }

            /**
             * Obtient la valeur de la propriété custom.
             * 
             * @return
             *     possible object is
             *     {@link Custom }
             *     
             */
            public Custom getCustom() {
                return custom;
            }

            /**
             * Définit la valeur de la propriété custom.
             * 
             * @param value
             *     allowed object is
             *     {@link Custom }
             *     
             */
            public void setCustom(Custom value) {
                this.custom = value;
            }

            /**
             * Obtient la valeur de la propriété id.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getId() {
                return id;
            }

            /**
             * Définit la valeur de la propriété id.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setId(BigInteger value) {
                this.id = value;
            }

            /**
             * Obtient la valeur de la propriété type.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getType() {
                return type;
            }

            /**
             * Définit la valeur de la propriété type.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setType(BigInteger value) {
                this.type = value;
            }

            /**
             * Obtient la valeur de la propriété node.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getNode() {
                return node;
            }

            /**
             * Définit la valeur de la propriété node.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setNode(BigInteger value) {
                this.node = value;
            }

            /**
             * Obtient la valeur de la propriété link.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getLink() {
                return link;
            }

            /**
             * Définit la valeur de la propriété link.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setLink(BigInteger value) {
                this.link = value;
            }


            /**
             * <p>Classe Java pour anonymous complex type.
             * 
             * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="request" type="{http://www.w3.org/2001/XMLSchema}integer" maxOccurs="unbounded"/>
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "request"
            })
            public static class Predecessors {

                @XmlElement(required = true)
                protected List<BigInteger> request;

                /**
                 * Gets the value of the request property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the request property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getRequest().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link BigInteger }
                 * 
                 * 
                 */
                public List<BigInteger> getRequest() {
                    if (request == null) {
                        request = new ArrayList<BigInteger>();
                    }
                    return this.request;
                }

            }


            /**
             * <p>Classe Java pour anonymous complex type.
             * 
             * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="request" type="{http://www.w3.org/2001/XMLSchema}integer" maxOccurs="unbounded"/>
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "request"
            })
            public static class Successors {

                @XmlElement(required = true)
                protected List<BigInteger> request;

                /**
                 * Gets the value of the request property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the request property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getRequest().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link BigInteger }
                 * 
                 * 
                 */
                public List<BigInteger> getRequest() {
                    if (request == null) {
                        request = new ArrayList<BigInteger>();
                    }
                    return this.request;
                }

            }

        }

    }

}
