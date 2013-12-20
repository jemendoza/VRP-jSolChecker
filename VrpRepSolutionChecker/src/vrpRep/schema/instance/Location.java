//
// Ce fichier a �t� g�n�r� par l'impl�mentation de r�f�rence JavaTM Architecture for XML Binding (JAXB), v2.2.5-2 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apport�e � ce fichier sera perdue lors de la recompilation du sch�ma source. 
// G�n�r� le : 2013.12.20 � 12:01:55 PM CET 
//


package vrpRep.schema.instance;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="euclidean">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="cx" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                   &lt;element name="cy" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                   &lt;element name="cz" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="GPSCoordinates">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="lat" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *                 &lt;attribute name="lon" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element ref="{}custom"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "euclidean",
    "gpsCoordinates",
    "custom"
})
@XmlRootElement(name = "location")
public class Location {

    protected Location.Euclidean euclidean;
    @XmlElement(name = "GPSCoordinates")
    protected Location.GPSCoordinates gpsCoordinates;
    protected Custom custom;

    /**
     * Obtient la valeur de la propri�t� euclidean.
     * 
     * @return
     *     possible object is
     *     {@link Location.Euclidean }
     *     
     */
    public Location.Euclidean getEuclidean() {
        return euclidean;
    }

    /**
     * D�finit la valeur de la propri�t� euclidean.
     * 
     * @param value
     *     allowed object is
     *     {@link Location.Euclidean }
     *     
     */
    public void setEuclidean(Location.Euclidean value) {
        this.euclidean = value;
    }

    /**
     * Obtient la valeur de la propri�t� gpsCoordinates.
     * 
     * @return
     *     possible object is
     *     {@link Location.GPSCoordinates }
     *     
     */
    public Location.GPSCoordinates getGPSCoordinates() {
        return gpsCoordinates;
    }

    /**
     * D�finit la valeur de la propri�t� gpsCoordinates.
     * 
     * @param value
     *     allowed object is
     *     {@link Location.GPSCoordinates }
     *     
     */
    public void setGPSCoordinates(Location.GPSCoordinates value) {
        this.gpsCoordinates = value;
    }

    /**
     * Obtient la valeur de la propri�t� custom.
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
     * D�finit la valeur de la propri�t� custom.
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
     * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="cx" type="{http://www.w3.org/2001/XMLSchema}double"/>
     *         &lt;element name="cy" type="{http://www.w3.org/2001/XMLSchema}double"/>
     *         &lt;element name="cz" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
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
        "cx",
        "cy",
        "cz"
    })
    public static class Euclidean {

        protected double cx;
        protected double cy;
        protected Double cz;

        /**
         * Obtient la valeur de la propri�t� cx.
         * 
         */
        public double getCx() {
            return cx;
        }

        /**
         * D�finit la valeur de la propri�t� cx.
         * 
         */
        public void setCx(double value) {
            this.cx = value;
        }

        /**
         * Obtient la valeur de la propri�t� cy.
         * 
         */
        public double getCy() {
            return cy;
        }

        /**
         * D�finit la valeur de la propri�t� cy.
         * 
         */
        public void setCy(double value) {
            this.cy = value;
        }

        /**
         * Obtient la valeur de la propri�t� cz.
         * 
         * @return
         *     possible object is
         *     {@link Double }
         *     
         */
        public Double getCz() {
            return cz;
        }

        /**
         * D�finit la valeur de la propri�t� cz.
         * 
         * @param value
         *     allowed object is
         *     {@link Double }
         *     
         */
        public void setCz(Double value) {
            this.cz = value;
        }

    }


    /**
     * <p>Classe Java pour anonymous complex type.
     * 
     * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="lat" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
     *       &lt;attribute name="lon" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class GPSCoordinates {

        @XmlAttribute(name = "lat", required = true)
        protected double lat;
        @XmlAttribute(name = "lon", required = true)
        protected double lon;

        /**
         * Obtient la valeur de la propri�t� lat.
         * 
         */
        public double getLat() {
            return lat;
        }

        /**
         * D�finit la valeur de la propri�t� lat.
         * 
         */
        public void setLat(double value) {
            this.lat = value;
        }

        /**
         * Obtient la valeur de la propri�t� lon.
         * 
         */
        public double getLon() {
            return lon;
        }

        /**
         * D�finit la valeur de la propri�t� lon.
         * 
         */
        public void setLon(double value) {
            this.lon = value;
        }

    }

}
