//
// Ce fichier a �t� g�n�r� par l'impl�mentation de r�f�rence JavaTM Architecture for XML Binding (JAXB), v2.2.5-2 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apport�e � ce fichier sera perdue lors de la recompilation du sch�ma source. 
// G�n�r� le : 2014.01.23 � 04:10:08 PM CET 
//


package vrpRep.schema.output;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *       &lt;all>
 *         &lt;element name="solution" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *         &lt;element name="objectiveFunction">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="valid" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="constraints">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element name="nonValid" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="constraint" maxOccurs="unbounded">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="valid" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="constraint" maxOccurs="unbounded">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/all>
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
@XmlRootElement(name = "result")
public class Result {

    @XmlElement(required = true)
    protected Object solution;
    @XmlElement(required = true)
    protected Result.ObjectiveFunction objectiveFunction;
    @XmlElement(required = true)
    protected Result.Constraints constraints;

    /**
     * Obtient la valeur de la propri�t� solution.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getSolution() {
        return solution;
    }

    /**
     * D�finit la valeur de la propri�t� solution.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setSolution(Object value) {
        this.solution = value;
    }

    /**
     * Obtient la valeur de la propri�t� objectiveFunction.
     * 
     * @return
     *     possible object is
     *     {@link Result.ObjectiveFunction }
     *     
     */
    public Result.ObjectiveFunction getObjectiveFunction() {
        return objectiveFunction;
    }

    /**
     * D�finit la valeur de la propri�t� objectiveFunction.
     * 
     * @param value
     *     allowed object is
     *     {@link Result.ObjectiveFunction }
     *     
     */
    public void setObjectiveFunction(Result.ObjectiveFunction value) {
        this.objectiveFunction = value;
    }

    /**
     * Obtient la valeur de la propri�t� constraints.
     * 
     * @return
     *     possible object is
     *     {@link Result.Constraints }
     *     
     */
    public Result.Constraints getConstraints() {
        return constraints;
    }

    /**
     * D�finit la valeur de la propri�t� constraints.
     * 
     * @param value
     *     allowed object is
     *     {@link Result.Constraints }
     *     
     */
    public void setConstraints(Result.Constraints value) {
        this.constraints = value;
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
     *       &lt;all>
     *         &lt;element name="nonValid" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="constraint" maxOccurs="unbounded">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="valid" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="constraint" maxOccurs="unbounded">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
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
    public static class Constraints {

        protected Result.Constraints.NonValid nonValid;
        protected Result.Constraints.Valid valid;

        /**
         * Obtient la valeur de la propri�t� nonValid.
         * 
         * @return
         *     possible object is
         *     {@link Result.Constraints.NonValid }
         *     
         */
        public Result.Constraints.NonValid getNonValid() {
            return nonValid;
        }

        /**
         * D�finit la valeur de la propri�t� nonValid.
         * 
         * @param value
         *     allowed object is
         *     {@link Result.Constraints.NonValid }
         *     
         */
        public void setNonValid(Result.Constraints.NonValid value) {
            this.nonValid = value;
        }

        /**
         * Obtient la valeur de la propri�t� valid.
         * 
         * @return
         *     possible object is
         *     {@link Result.Constraints.Valid }
         *     
         */
        public Result.Constraints.Valid getValid() {
            return valid;
        }

        /**
         * D�finit la valeur de la propri�t� valid.
         * 
         * @param value
         *     allowed object is
         *     {@link Result.Constraints.Valid }
         *     
         */
        public void setValid(Result.Constraints.Valid value) {
            this.valid = value;
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
         *         &lt;element name="constraint" maxOccurs="unbounded">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
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
            "constraint"
        })
        public static class NonValid {

            @XmlElement(required = true)
            protected List<Result.Constraints.NonValid.Constraint> constraint;

            /**
             * Gets the value of the constraint property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the constraint property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getConstraint().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Result.Constraints.NonValid.Constraint }
             * 
             * 
             */
            public List<Result.Constraints.NonValid.Constraint> getConstraint() {
                if (constraint == null) {
                    constraint = new ArrayList<Result.Constraints.NonValid.Constraint>();
                }
                return this.constraint;
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
             *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
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
            public static class Constraint {

                @XmlValue
                protected String content;
                @XmlAttribute(name = "name")
                @XmlSchemaType(name = "anySimpleType")
                protected String name;

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
                 * Obtient la valeur de la propri�t� name.
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
                 * D�finit la valeur de la propri�t� name.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setName(String value) {
                    this.name = value;
                }

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
         *       &lt;sequence>
         *         &lt;element name="constraint" maxOccurs="unbounded">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
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
            "constraint"
        })
        public static class Valid {

            @XmlElement(required = true)
            protected List<Result.Constraints.Valid.Constraint> constraint;

            /**
             * Gets the value of the constraint property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the constraint property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getConstraint().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Result.Constraints.Valid.Constraint }
             * 
             * 
             */
            public List<Result.Constraints.Valid.Constraint> getConstraint() {
                if (constraint == null) {
                    constraint = new ArrayList<Result.Constraints.Valid.Constraint>();
                }
                return this.constraint;
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
             *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
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
            public static class Constraint {

                @XmlValue
                protected String content;
                @XmlAttribute(name = "name")
                @XmlSchemaType(name = "anySimpleType")
                protected String name;

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
                 * Obtient la valeur de la propri�t� name.
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
                 * D�finit la valeur de la propri�t� name.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setName(String value) {
                    this.name = value;
                }

            }

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
     *       &lt;attribute name="valid" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class ObjectiveFunction {

        @XmlAttribute(name = "valid")
        @XmlSchemaType(name = "anySimpleType")
        protected String valid;

        /**
         * Obtient la valeur de la propri�t� valid.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValid() {
            return valid;
        }

        /**
         * D�finit la valeur de la propri�t� valid.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValid(String value) {
            this.valid = value;
        }

    }

}
