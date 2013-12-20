//
// Ce fichier a �t� g�n�r� par l'impl�mentation de r�f�rence JavaTM Architecture for XML Binding (JAXB), v2.2.5-2 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apport�e � ce fichier sera perdue lors de la recompilation du sch�ma source. 
// G�n�r� le : 2013.12.20 � 12:01:55 PM CET 
//


package vrpRep.schema.instance;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="avg" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;sequence>
 *           &lt;element name="speedInterval" maxOccurs="unbounded">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element name="speed" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                     &lt;element ref="{}tw" maxOccurs="unbounded"/>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *         &lt;/sequence>
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
    "avg",
    "speedInterval"
})
@XmlRootElement(name = "speedProfile")
public class SpeedProfile {

    protected Double avg;
    protected List<SpeedProfile.SpeedInterval> speedInterval;

    /**
     * Obtient la valeur de la propri�t� avg.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getAvg() {
        return avg;
    }

    /**
     * D�finit la valeur de la propri�t� avg.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setAvg(Double value) {
        this.avg = value;
    }

    /**
     * Gets the value of the speedInterval property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the speedInterval property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSpeedInterval().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SpeedProfile.SpeedInterval }
     * 
     * 
     */
    public List<SpeedProfile.SpeedInterval> getSpeedInterval() {
        if (speedInterval == null) {
            speedInterval = new ArrayList<SpeedProfile.SpeedInterval>();
        }
        return this.speedInterval;
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
     *         &lt;element name="speed" type="{http://www.w3.org/2001/XMLSchema}double"/>
     *         &lt;element ref="{}tw" maxOccurs="unbounded"/>
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
        "speed",
        "tw"
    })
    public static class SpeedInterval {

        protected double speed;
        @XmlElement(required = true)
        protected List<Tw> tw;

        /**
         * Obtient la valeur de la propri�t� speed.
         * 
         */
        public double getSpeed() {
            return speed;
        }

        /**
         * D�finit la valeur de la propri�t� speed.
         * 
         */
        public void setSpeed(double value) {
            this.speed = value;
        }

        /**
         * Time window at which this speed should be used Gets the value of the tw property.
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

    }

}
