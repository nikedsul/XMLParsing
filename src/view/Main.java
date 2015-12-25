package view;

import jdk.internal.util.xml.XMLStreamException;
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
        IParsersUniting parser = new ParserStAX("Guns.xml");
        domParser.sortByField("Manufacturer country");
        for (Gun gun : domParser.getGuns()) {
            System.out.println(gun.toString());
        }
    }

}
