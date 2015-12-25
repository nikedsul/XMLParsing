package view;

import model.XMLAssembler;
import jdk.internal.util.xml.XMLStreamException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by Nikolai on 22.12.2015.
 */
public class Client {
    public void createXML() throws ParserConfigurationException, IOException, SAXException, XMLStreamException {

        new XMLAssembler(
                new String[]{"PISTOL", "RUSSIA", "TITANIUM", "false", "500", "100", "false", "false"},
                new String[]{"ASSAULT_RIFLE", "ITALY", "STEEL", "true", "800", "500", "true", "false"},
                new String[]{"GRENADE_LAUNCHER", "ENGLAND", "COMPOSITE", "true", "1000", "300", "false", "true"},
                new String[]{"GRENADE_LAUNCHER", "USA", "STEEL", "true", "1000", "300", "true", "true"},
                new String[]{"SUBMACHINE_GUN", "FRANCE", "COMPOSITE", "true", "800", "100", "false", "true"}
        );
    }

}
