package model.parsersXML;

import controller.XMLAgainstXSD;
import model.*;
import model.enums.EFieldName;
import model.enums.EMaterial;
import model.enums.EModel;
import model.enums.EOrigin;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

/**
 * Created by Nikolai on 24.12.2015.
 */
public class ParserStAX extends ParsersUniting {

    public ParserStAX(String xml){
        if (new XMLAgainstXSD(xml).validate()) {
            createObject(xml);
        } else {
            System.out.println("Incorrect XML-file!");
        }
    }

    private void createObject(String xml) {
        boolean bModel = false;
        boolean bOrigin = false;
        boolean bMaterial = false;
        boolean bTwoHand = false;
        boolean bAccuracyRange = false;
        boolean bFireRange = false;
        boolean bMagazineCharger = false;
        boolean bOpticalSight = false;
        String gunID = "";
        String model = "";
        String origin = "";
        String material = "";
        String twoHand = "";
        String fireRange = "";
        String accuracyRange = "";
        String magazineCharger = "";
        String opticalSight = "";
        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader eventReader = factory.createXMLEventReader(new FileReader(xml));

            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();
                switch (event.getEventType()) {
                    case XMLStreamConstants.START_ELEMENT:
                        StartElement startElement = event.asStartElement();
                        String qName = startElement.getName().getLocalPart();
                        if (qName.equalsIgnoreCase("gun")) {
                            Iterator<Attribute> attributes = startElement.getAttributes();
                            gunID = attributes.next().getValue();
                        } else if (qName.equals(EFieldName.MODEL.getName())) {
                            bModel = true;
                        } else if (qName.equals(EFieldName.ORIGIN.getName())) {
                            bOrigin = true;
                        } else if (qName.equals(EFieldName.MATERIAL.getName())) {
                            bMaterial = true;
                        } else if (qName.equals(EFieldName.TWO_HAND.getName())) {
                            bTwoHand = true;
                        } else if (qName.equals(EFieldName.FIRE_RANGE.getName())) {
                            bFireRange = true;
                        } else if (qName.equals(EFieldName.ACCURACY_RANGE.getName())) {
                            bAccuracyRange = true;
                        } else if (qName.equals(EFieldName.MAGAZINE.getName())) {
                            bMagazineCharger = true;
                        } else if (qName.equals(EFieldName.OPTICAL.getName())) {
                            bOpticalSight = true;
                        }
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        Characters characters = event.asCharacters();
                        if (bModel) {
                            model = characters.getData();
                            bModel = false;
                        }
                        if (bOrigin) {
                            origin = characters.getData();
                            bOrigin = false;
                        }
                        if (bMaterial) {
                            material = characters.getData();
                            bMaterial = false;
                        }
                        if (bTwoHand) {
                            twoHand = characters.getData();
                            bTwoHand = false;
                        }
                        if (bFireRange) {
                            fireRange = characters.getData();
                            bFireRange = false;
                        }
                        if (bAccuracyRange) {
                            accuracyRange = characters.getData();
                            bAccuracyRange = false;
                        }
                        if (bMagazineCharger) {
                            magazineCharger = characters.getData();
                            bMagazineCharger = false;
                        }
                        if (bOpticalSight) {
                            opticalSight = characters.getData();
                            bOpticalSight = false;
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        EndElement endElement = event.asEndElement();
                        if (endElement.getName().getLocalPart().equalsIgnoreCase("gun")) {
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
                        break;
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
