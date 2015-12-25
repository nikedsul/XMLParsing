package view;

import jdk.internal.util.xml.XMLStreamException;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Class Main
 * @author Sultan Mykola on 25.12.2015
 * @version X001
 */
public class Main {

    public static void main(String[] args){

        Client client = new Client();
        try {
            client.printAll();
        } catch (ParserConfigurationException | XMLStreamException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

}
