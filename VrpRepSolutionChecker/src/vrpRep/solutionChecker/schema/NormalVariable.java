//
// Ce fichier a �t� g�n�r� par l'impl�mentation de r�f�rence JavaTM Architecture for XML Binding (JAXB), v2.2.5-2 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apport�e � ce fichier sera perdue lors de la recompilation du sch�ma source. 
// G�n�r� le : 2012.07.18 � 10:55:38 AM CEST 
//


package vrpRep.solutionChecker.schema;

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
 *       &lt;sequence>
 *         &lt;element name="mean" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="variance" type="{}positiveDouble"/>
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
    "mean",
    "variance"
})
@XmlRootElement(name = "NormalVariable")
public class NormalVariable {

    @XmlElement(defaultValue = "0")
    protected double mean;
    @XmlElement(defaultValue = "1")
    protected double variance;

    /**
     * Obtient la valeur de la propri�t� mean.
     * 
     */
    public double getMean() {
        return mean;
    }

    /**
     * D�finit la valeur de la propri�t� mean.
     * 
     */
    public void setMean(double value) {
        this.mean = value;
    }

    /**
     * Obtient la valeur de la propri�t� variance.
     * 
     */
    public double getVariance() {
        return variance;
    }

    /**
     * D�finit la valeur de la propri�t� variance.
     * 
     */
    public void setVariance(double value) {
        this.variance = value;
    }

}
