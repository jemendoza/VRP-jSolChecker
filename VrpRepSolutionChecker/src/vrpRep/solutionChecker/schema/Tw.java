//
// Ce fichier a �t� g�n�r� par l'impl�mentation de r�f�rence JavaTM Architecture for XML Binding (JAXB), v2.2.5-2 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apport�e � ce fichier sera perdue lors de la recompilation du sch�ma source. 
// G�n�r� le : 2012.07.18 � 10:55:38 AM CEST 
//


package vrpRep.solutionChecker.schema;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


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
 *         &lt;element name="start" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="isHard" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="end" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="isHard" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="period" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "start",
    "end"
})
@XmlRootElement(name = "tw")
public class Tw {

    protected Tw.Start start;
    protected Tw.End end;
    @XmlAttribute(name = "period")
    protected BigInteger period;

    /**
     * Obtient la valeur de la propri�t� start.
     * 
     * @return
     *     possible object is
     *     {@link Tw.Start }
     *     
     */
    public Tw.Start getStart() {
        return start;
    }

    /**
     * D�finit la valeur de la propri�t� start.
     * 
     * @param value
     *     allowed object is
     *     {@link Tw.Start }
     *     
     */
    public void setStart(Tw.Start value) {
        this.start = value;
    }

    /**
     * Obtient la valeur de la propri�t� end.
     * 
     * @return
     *     possible object is
     *     {@link Tw.End }
     *     
     */
    public Tw.End getEnd() {
        return end;
    }

    /**
     * D�finit la valeur de la propri�t� end.
     * 
     * @param value
     *     allowed object is
     *     {@link Tw.End }
     *     
     */
    public void setEnd(Tw.End value) {
        this.end = value;
    }

    /**
     * Obtient la valeur de la propri�t� period.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPeriod() {
        return period;
    }

    /**
     * D�finit la valeur de la propri�t� period.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPeriod(BigInteger value) {
        this.period = value;
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
     *       &lt;attribute name="isHard" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
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
    public static class End {

        @XmlValue
        protected String content;
        @XmlAttribute(name = "isHard")
        protected Boolean isHard;

        /**
         * Obtient la valeur de la propri�t� content.
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
         * D�finit la valeur de la propri�t� content.
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
         * Obtient la valeur de la propri�t� isHard.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public boolean isIsHard() {
            if (isHard == null) {
                return true;
            } else {
                return isHard;
            }
        }

        /**
         * D�finit la valeur de la propri�t� isHard.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setIsHard(Boolean value) {
            this.isHard = value;
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
     *       &lt;attribute name="isHard" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
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
    public static class Start {

        @XmlValue
        protected String content;
        @XmlAttribute(name = "isHard")
        protected Boolean isHard;

        /**
         * Obtient la valeur de la propri�t� content.
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
         * D�finit la valeur de la propri�t� content.
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
         * Obtient la valeur de la propri�t� isHard.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public boolean isIsHard() {
            if (isHard == null) {
                return true;
            } else {
                return isHard;
            }
        }

        /**
         * D�finit la valeur de la propri�t� isHard.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setIsHard(Boolean value) {
            this.isHard = value;
        }

    }

}
