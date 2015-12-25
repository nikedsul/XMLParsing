package model;

import model.enums.EFieldName;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * Class XMLAssembler creates xml-file from given parameters
 * @author Sultan Mykola on 25.12.2015
 * @version X001
 */
public class XMLAssembler {
    private final static String XML = "Guns.xml";

    public XMLAssembler(String[]... guns) throws ParserConfigurationException {
        assembleXML(getDocument(guns));
    }

    /**
     * Method getDocument
     * @param guns string array with gun characteristics
     * @return xml-document
     * @throws ParserConfigurationException
     */
    private Document getDocument(String[]... guns) throws ParserConfigurationException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document document = documentBuilder.newDocument();

        Element root = document.createElement("guns");
        document.appendChild(root);

        for (int i = 0; i < guns.length; i++) {

            Element gun = document.createElement("gun");
            gun.setAttribute("ID", String.valueOf(i));
            gun.setIdAttribute("ID", true);
            root.appendChild(gun);

            Element type = document.createElement(EFieldName.MODEL.getName());
            type.appendChild(document.createTextNode(guns[i][0]));
            gun.appendChild(type);

            Element origin = document.createElement(EFieldName.ORIGIN.getName());
            origin.appendChild(document.createTextNode(guns[i][1]));
            gun.appendChild(origin);

            Element material = document.createElement(EFieldName.MATERIAL.getName());
            material.appendChild(document.createTextNode(guns[i][2]));
            gun.appendChild(material);

            Element twoHand = document.createElement(EFieldName.TWO_HAND.getName());
            twoHand.appendChild(document.createTextNode(guns[i][3]));
            gun.appendChild(twoHand);

            Element performanceChars = document.createElement("performanceCharacteristics");
            gun.appendChild(performanceChars);

                Element fireRange = document.createElement(EFieldName.FIRE_RANGE.getName());
                Attr attr = document.createAttribute("measure");
                attr.setValue("km");
                fireRange.setAttributeNode(attr);
                fireRange.appendChild(document.createTextNode(guns[i][4]));
                performanceChars.appendChild(fireRange);

                Element accuracyRange = document.createElement(EFieldName.ACCURACY_RANGE.getName());
                Attr accuracyAttr = document.createAttribute("measure");
                accuracyAttr.setValue("m");
                accuracyRange.setAttributeNode(accuracyAttr);
                accuracyRange.appendChild(document.createTextNode(guns[i][5]));
                performanceChars.appendChild(accuracyRange);

                Element magazineCharger = document.createElement(EFieldName.MAGAZINE.getName());
                magazineCharger.appendChild(document.createTextNode(guns[i][6]));
                performanceChars.appendChild(magazineCharger);

                Element opticalSight = document.createElement(EFieldName.OPTICAL.getName());
                opticalSight.appendChild(document.createTextNode(guns[i][7]));
                performanceChars.appendChild(opticalSight);

        }
        return document;
    }

    /**
     * Method assembleXML makes xml-file from xml-document
     * @param document is an xml-document
     */
    private void assembleXML(Document document) {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();

        try {
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(XML));
            transformer.transform(domSource, streamResult);
            System.out.println("XML-file has been created successfully!");
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
