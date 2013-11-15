//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.5-2 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2012.07.18 à 10:55:38 AM CEST 
//


package vrpRep.schema;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Variable capacity (e.g. MC-VRP)
 * 
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;sequence>
 *           &lt;element name="minCapacity" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *           &lt;element name="maxCapacity" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;/sequence>
 *         &lt;sequence>
 *           &lt;element name="fixed" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;/sequence>
 *       &lt;/choice>
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
    "minCapacity",
    "maxCapacity",
    "fixed"
})
@XmlRootElement(name = "compartment")
public class Compartment {

    protected Double minCapacity;
    protected Double maxCapacity;
    protected Double fixed;
    @XmlAttribute(name = "type")
    protected BigInteger type;

    /**
     * Obtient la valeur de la propriété minCapacity.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getMinCapacity() {
        return minCapacity;
    }

    /**
     * Définit la valeur de la propriété minCapacity.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setMinCapacity(Double value) {
        this.minCapacity = value;
    }

    /**
     * Obtient la valeur de la propriété maxCapacity.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getMaxCapacity() {
        return maxCapacity;
    }

    /**
     * Définit la valeur de la propriété maxCapacity.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setMaxCapacity(Double value) {
        this.maxCapacity = value;
    }

    /**
     * Obtient la valeur de la propriété fixed.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getFixed() {
        return fixed;
    }

    /**
     * Définit la valeur de la propriété fixed.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setFixed(Double value) {
        this.fixed = value;
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
