
package org.barcode;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BarcodeInfoService complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BarcodeInfoService">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="barcode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lastofficeindex" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="eventdate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lastoffice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="eventdescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BarcodeInfoService", propOrder = {
    "barcode",
    "code",
    "lastofficeindex",
    "eventdate",
    "lastoffice",
    "eventdescription"
})
public class BarcodeInfoService {

    protected String barcode;
    protected String code;
    protected String lastofficeindex;
    protected String eventdate;
    protected String lastoffice;
    protected String eventdescription;

    /**
     * Gets the value of the barcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBarcode() {
        return barcode;
    }

    /**
     * Sets the value of the barcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBarcode(String value) {
        this.barcode = value;
    }

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the lastofficeindex property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastofficeindex() {
        return lastofficeindex;
    }

    /**
     * Sets the value of the lastofficeindex property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastofficeindex(String value) {
        this.lastofficeindex = value;
    }

    /**
     * Gets the value of the eventdate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEventdate() {
        return eventdate;
    }

    /**
     * Sets the value of the eventdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEventdate(String value) {
        this.eventdate = value;
    }

    /**
     * Gets the value of the lastoffice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastoffice() {
        return lastoffice;
    }

    /**
     * Sets the value of the lastoffice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastoffice(String value) {
        this.lastoffice = value;
    }

    /**
     * Gets the value of the eventdescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEventdescription() {
        return eventdescription;
    }

    /**
     * Sets the value of the eventdescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEventdescription(String value) {
        this.eventdescription = value;
    }

}
