package view;

import model.Gun;
import model.XMLAssembler;
import jdk.internal.util.xml.XMLStreamException;
import model.enums.EFieldName;
import model.parsersXML.IParsersUniting;
import model.parsersXML.ParserDOM;
import model.parsersXML.ParserSAX;
import model.parsersXML.ParserStAX;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Class Client
 * @author Sultan Mykola on 25.12.2015
 * @version X001
 */
public class Client {
    public void createXML() throws ParserConfigurationException, IOException, SAXException, XMLStreamException {

        new XMLAssembler(
                new String[]{"PISTOL", "RUSSIA", "TITANIUM", "false", "1100", "100", "false", "false"},
                new String[]{"ASSAULT_RIFLE", "ITALY", "STEEL", "true", "1800", "500", "true", "false"},
                new String[]{"GRENADE_LAUNCHER", "ENGLAND", "COMPOSITE", "true", "1000", "300", "false", "true"},
                new String[]{"GRENADE_LAUNCHER", "USA", "STEEL", "true", "1500", "300", "true", "true"},
                new String[]{"SUBMACHINE_GUN", "FRANCE", "COMPOSITE", "true", "1200", "100", "false", "true"}
        );
    }

    public void printAll()  throws ParserConfigurationException, IOException, SAXException, XMLStreamException {
        final String XML = "Guns.xml";
        this.createXML();
        IParsersUniting domParser = new ParserDOM(XML);
        IParsersUniting saxParser = new ParserSAX(XML);
        IParsersUniting staxParser = new ParserStAX(XML);
        domParser.sortByField(EFieldName.ACCURACY_RANGE);
        saxParser.sortByField(EFieldName.FIRE_RANGE);
        staxParser.sortByField(EFieldName.MODEL);

        for (Gun gun : domParser.getGuns()) {
            System.out.println(gun.toString());
        }
        System.out.println("==============================");
        for (Gun gun : saxParser.getGuns()) {
            System.out.println(gun.toString());
        }
        System.out.println("==============================");
        for (Gun gun : staxParser.getGuns()) {
            System.out.println(gun.toString());
        }

    }

}
