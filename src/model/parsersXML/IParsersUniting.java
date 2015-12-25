package model.parsersXML;

import model.enums.EFieldName;
import model.Gun;

import java.util.List;

/**
 * Interface IParsersUniting is an interface of different xml-parsers.
 * @author Sultan Mykola on 25.12.2015
 * @version X001
 */
public interface IParsersUniting {
    List<Gun> getGuns();
    void sortByField(final EFieldName fieldName);
}
