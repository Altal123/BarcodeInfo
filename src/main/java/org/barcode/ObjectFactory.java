
package org.barcode;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.barcode package. 
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

    private final static QName _BarcodeInfoService_QNAME = new QName("http://barcode.org/", "BarcodeInfoService");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.barcode
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetBarcodeInfoResponse }
     * 
     */
    public GetBarcodeInfoResponse createGetBarcodeInfoResponse() {
        return new GetBarcodeInfoResponse();
    }

    /**
     * Create an instance of {@link BarcodeInfoService }
     * 
     */
    public BarcodeInfoService createBarcodeInfoService() {
        return new BarcodeInfoService();
    }

    /**
     * Create an instance of {@link GetBarcodeInfo }
     * 
     */
    public GetBarcodeInfo createGetBarcodeInfo() {
        return new GetBarcodeInfo();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BarcodeInfoService }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://barcode.org/", name = "BarcodeInfoService")
    public JAXBElement<BarcodeInfoService> createBarcodeInfoService(BarcodeInfoService value) {
        return new JAXBElement<BarcodeInfoService>(_BarcodeInfoService_QNAME, BarcodeInfoService.class, null, value);
    }

}
