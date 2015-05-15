
package org.barcode;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Culture.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Culture">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="uk"/>
 *     &lt;enumeration value="en"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Culture")
@XmlEnum
public enum Culture {

    @XmlEnumValue("uk")
    UK("uk"),
    @XmlEnumValue("en")
    EN("en");
    private final String value;

    Culture(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Culture fromValue(String v) {
        for (Culture c: Culture.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
