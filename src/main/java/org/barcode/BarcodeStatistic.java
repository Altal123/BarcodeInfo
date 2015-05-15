
package org.barcode;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "BarcodeStatistic", targetNamespace = "http://barcode.org/", wsdlLocation = "http://services.ukrposhta.com/barcodestatistic/barcodestatistic.asmx?WSDL")
public class BarcodeStatistic
    extends Service
{

    private final static URL BARCODESTATISTIC_WSDL_LOCATION;
    private final static WebServiceException BARCODESTATISTIC_EXCEPTION;
    private final static QName BARCODESTATISTIC_QNAME = new QName("http://barcode.org/", "BarcodeStatistic");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://services.ukrposhta.com/barcodestatistic/barcodestatistic.asmx?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        BARCODESTATISTIC_WSDL_LOCATION = url;
        BARCODESTATISTIC_EXCEPTION = e;
    }

    public BarcodeStatistic() {
        super(__getWsdlLocation(), BARCODESTATISTIC_QNAME);
    }

    public BarcodeStatistic(WebServiceFeature... features) {
        super(__getWsdlLocation(), BARCODESTATISTIC_QNAME, features);
    }

    public BarcodeStatistic(URL wsdlLocation) {
        super(wsdlLocation, BARCODESTATISTIC_QNAME);
    }

    public BarcodeStatistic(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, BARCODESTATISTIC_QNAME, features);
    }

    public BarcodeStatistic(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public BarcodeStatistic(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns BarcodeStatisticSoap
     */
    @WebEndpoint(name = "BarcodeStatisticSoap")
    public BarcodeStatisticSoap getBarcodeStatisticSoap() {
        return super.getPort(new QName("http://barcode.org/", "BarcodeStatisticSoap"), BarcodeStatisticSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns BarcodeStatisticSoap
     */
    @WebEndpoint(name = "BarcodeStatisticSoap")
    public BarcodeStatisticSoap getBarcodeStatisticSoap(WebServiceFeature... features) {
        return super.getPort(new QName("http://barcode.org/", "BarcodeStatisticSoap"), BarcodeStatisticSoap.class, features);
    }

    private static URL __getWsdlLocation() {
        if (BARCODESTATISTIC_EXCEPTION!= null) {
            throw BARCODESTATISTIC_EXCEPTION;
        }
        return BARCODESTATISTIC_WSDL_LOCATION;
    }

}
