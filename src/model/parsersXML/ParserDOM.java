package model.parsersXML;

import controller.XMLAgainstXSD;
import model.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikolai on 22.12.2015.
 */
public class ParserDOM implements IParsersUniting {
    private List<Gun> guns = new ArrayList<Gun>();

    public ParserDOM(String xml) throws IOException, SAXException, ParserConfigurationException {
        if (new XMLAgainstXSD(xml).validate()) {
            createObject(xml);
        } else {
            System.out.println("Incorrect XML-file!");
        }
    }

    @Override
    public List<Gun> getGuns() {
        return guns;
    }

    private void createObject(String xml) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document document = documentBuilder.parse(xml);

        NodeList nodeListGun = document.getElementsByTagName("gun");
        NodeList nodeListPerformanceCharacteristics = document.getElementsByTagName("performanceCharacteristics");

        for(int i = 0; i < nodeListGun.getLength(); i++) {
            Element elementGun = (Element) nodeListGun.item(i);
            Element elementChar = (Element) nodeListPerformanceCharacteristics.item(i);

            guns.add(
                new Gun(
                        Integer.valueOf(elementGun.getAttribute("id")),
                        EModel.valueOf(elementGun.getElementsByTagName("model").item(0).getTextContent()),
                        EOrigin.valueOf(elementGun.getElementsByTagName("origin").item(0).getTextContent()),
                        EMaterial.valueOf(elementGun.getElementsByTagName("material").item(0).getTextContent()),
                        (elementGun.getElementsByTagName("twoHand").item(0).getTextContent().equals("true")),
                        new PerformanceChars(
                                Integer.valueOf(elementChar.getElementsByTagName("fireRange").item(0).getTextContent()),
                                Integer.valueOf(elementChar.getElementsByTagName("accuracyRange").item(0).getTextContent()),
                                (elementChar.getElementsByTagName("magazineCharger").item(0).getTextContent().equals("true")),
                                (elementChar.getElementsByTagName("opticalSight").item(0).getTextContent().equals("true"))
                        )
                )
            );
        }

    }
}
