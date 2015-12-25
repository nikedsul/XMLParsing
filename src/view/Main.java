package view;

import jdk.internal.util.xml.XMLStreamException;
import model.EFieldName;
import model.parsersXML.IParsersUniting;
import model.parsersXML.ParserDOM;
import model.Gun;
import model.parsersXML.ParserSAX;
import model.parsersXML.ParserStAX;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by Nikolai on 22.12.2015.
 */
public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, XMLStreamException {
        Client client = new Client();
        client.createXML();
        IParsersUniting domParser = new ParserDOM("Guns.xml");
        IParsersUniting saxParser = new ParserSAX("Guns.xml");
        IParsersUniting staxParser = new ParserStAX("Guns.xml");
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
