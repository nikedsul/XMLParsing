package model.parsersXML;

import controller.XMLAgainstXSD;
import model.*;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

/**
 * Created by Nikolai on 23.12.2015.
 */
public class ParserSAX extends ParsersUniting {

    public ParserSAX(String xml) {
        if (new XMLAgainstXSD(xml).validate()) {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            Handler handler = new Handler();
            try {
                SAXParser saxParser = saxParserFactory.newSAXParser();
                saxParser.parse(new File(xml), handler);
            } catch (ParserConfigurationException | SAXException | IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Incorrect XML-file!");
        }
    }

    private class Handler extends DefaultHandler {
        private String element = "";
        String gunID, model, origin, material, twoHand, fireRange, accuracyRange, magazineCharger, opticalSight;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            element = qName;
            if (element.equals("gun")){
                gunID = attributes.getValue(EFieldName.ID.getName());
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            element = qName;
            if (element.equals("gun")) {
                guns.add(
                        new Gun(
                                Integer.valueOf(gunID),
                                EModel.valueOf(model),
                                EOrigin.valueOf(origin),
                                EMaterial.valueOf(material),
                                twoHand.equals("true"),
                                new PerformanceChars(
                                        Integer.valueOf(fireRange),
                                        Integer.valueOf(accuracyRange),
                                        magazineCharger.equals("true"),
                                        opticalSight.equals("true")
                                )
                        )
                );
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String value = new String(ch, start, length);

            if (getElement().equals(EFieldName.MODEL.getName())) {
                model = value;
            } else if (getElement().equals(EFieldName.ORIGIN.getName())) {
                origin = value;
            } else if (getElement().equals(EFieldName.MATERIAL.getName())) {
                material = value;
            } else if (getElement().equals(EFieldName.TWO_HAND.getName())) {
                twoHand = value;
            } else if (getElement().equals(EFieldName.FIRE_RANGE.getName())) {
                fireRange = value;
            } else if (getElement().equals(EFieldName.ACCURACY_RANGE.getName())) {
                accuracyRange = value;
            } else if (getElement().equals(EFieldName.MAGAZINE.getName())) {
                magazineCharger = value;
            } else if (getElement().equals(EFieldName.OPTICAL.getName())) {
                opticalSight = value;
            }
        }

        public String getElement() {
            return element;
        }
    }
}
