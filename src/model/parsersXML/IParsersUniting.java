package model.parsersXML;

import model.Gun;

import java.util.List;

/**
 * Created by Nikolai on 25.12.2015.
 */
public interface IParsersUniting {
    List<Gun> getGuns();
    void sortByField(final String fieldName);
}
