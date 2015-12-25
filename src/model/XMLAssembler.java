package model;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * Created by Nikolai on 22.12.2015.
 */
public class XMLAssembler {

    public XMLAssembler(String[]... guns) throws ParserConfigurationException {
        assembleXML(getDocument(guns));
    }

    private Document getDocument(String[]... guns) throws ParserConfigurationException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document document = documentBuilder.newDocument();

        Element mainElement = document.createElement("guns");
        document.appendChild(mainElement);

        for (int i = 0; i < guns.length; i++) {

            Element gun = document.createElement("gun");
            Attr gunID = document.createAttribute("id");
            gunID.setValue(String.valueOf(i));
            gun.setAttributeNode(gunID);
            mainElement.appendChild(gun);

            Element type = document.createElement("model");
            type.appendChild(document.createTextNode(guns[i][0]));
            gun.appendChild(type);

            Element origin = document.createElement("origin");
            origin.appendChild(document.createTextNode(guns[i][1]));
            gun.appendChild(origin);

            Element material = document.createElement("material");
            material.appendChild(document.createTextNode(guns[i][2]));
            gun.appendChild(material);

            Element twoHand = document.createElement("twoHand");
            twoHand.appendChild(document.createTextNode(guns[i][3]));
            gun.appendChild(twoHand);

            Element performanceChars = document.createElement("performanceCharacteristics");
            gun.appendChild(performanceChars);

                Element fireRange = document.createElement("fireRange");
                fireRange.appendChild(document.createTextNode(guns[i][4]));
                performanceChars.appendChild(fireRange);

                Element accuracyRange = document.createElement("accuracyRange");
                accuracyRange.appendChild(document.createTextNode(guns[i][5]));
                performanceChars.appendChild(accuracyRange);

                Element magazineCharger = document.createElement("magazineCharger");
                magazineCharger.appendChild(document.createTextNode(guns[i][6]));
                performanceChars.appendChild(magazineCharger);

                Element opticalSight = document.createElement("opticalSight");
                opticalSight.appendChild(document.createTextNode(guns[i][7]));
                performanceChars.appendChild(opticalSight);

        }
        return document;
    }

    private void assembleXML(Document document) {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();

        try {
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File("Guns.xml"));
            transformer.transform(domSource, streamResult);
            System.out.println("XML-file has been created successfully!");
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
