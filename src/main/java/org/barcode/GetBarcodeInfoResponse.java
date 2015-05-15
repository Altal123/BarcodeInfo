
package org.barcode;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetBarcodeInfoResult" type="{http://barcode.org/}BarcodeInfoService" minOccurs="0"/>
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
    "getBarcodeInfoResult"
})
@XmlRootElement(name = "GetBarcodeInfoResponse")
public class GetBarcodeInfoResponse {

    @XmlElement(name = "GetBarcodeInfoResult")
    protected BarcodeInfoService getBarcodeInfoResult;

    /**
     * Gets the value of the getBarcodeInfoResult property.
     * 
     * @return
     *     possible object is
     *     {@link BarcodeInfoService }
     *     
     */
    public BarcodeInfoService getGetBarcodeInfoResult() {
        return getBarcodeInfoResult;
    }

    /**
     * Sets the value of the getBarcodeInfoResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link BarcodeInfoService }
     *     
     */
    public void setGetBarcodeInfoResult(BarcodeInfoService value) {
        this.getBarcodeInfoResult = value;
    }

}
