package controller;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;

/**
 * Created by Nikolai on 22.12.2015.
 */
public class XMLAgainstXSD {
    private final String XSD = "Guns.xsd";
    private String xml;

    public XMLAgainstXSD(String xml) {
        this.xml = xml;
    }

    public boolean validate() {
        try {
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            schemaFactory.newSchema(new File(XSD)).newValidator().validate(new StreamSource(new File(xml)));
            return true;
        } catch (SAXException e) {
            return false;
        } catch (IOException e) {
            return false;
        }
    }
}
