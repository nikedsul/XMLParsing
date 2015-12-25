package model.parsersXML;

import model.enums.EFieldName;
import model.Gun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Class ParsersUniting is a parent of different xml-parsers.
 * @author Sultan Mykola on 25.12.2015
 * @version X001
 */
abstract class ParsersUniting implements IParsersUniting {

    /** List guns contains all objects of the Gun-class */
    List<Gun> guns = new ArrayList<Gun>();

    /**
     *
     * @return list of Gun objects
     */
    @Override
    public List<Gun> getGuns() {
        return guns;
    }

    /**
     * Method sortByField sorts object list by chosen field
     * @param fieldName desired field to be parameter for sorting
     */
    @Override
    public void sortByField(final EFieldName fieldName) {
        Collections.sort(guns, new Comparator<Gun>() {
            @Override
            public int compare(Gun o1, Gun o2) {
                if (fieldName.getName().equals(EFieldName.MODEL.getName())) {
                    return o1.getModel().getName().compareTo(o2.getModel().getName());
                } else if (fieldName.getName().equals(EFieldName.ORIGIN.getName())) {
                    return o1.getOrigin().getName().compareTo(o2.getOrigin().getName());
                } else if (fieldName.getName().equals(EFieldName.MATERIAL.getName())) {
                    return o1.getMaterial().getName().compareTo(o2.getMaterial().getName());
                } else if (fieldName.getName().equals(EFieldName.TWO_HAND.getName())) {
                    return String.valueOf(o1.isTwoHand()).compareTo
                            (String.valueOf(o2.isTwoHand()));
                } else if (fieldName.getName().equals(EFieldName.FIRE_RANGE.getName())) {
                    return String.valueOf(o1.getPerformanceChars().getFireRange()).compareTo
                            (String.valueOf(o2.getPerformanceChars().getFireRange()));
                } else if (fieldName.getName().equals(EFieldName.ACCURACY_RANGE.getName())) {
                    return String.valueOf(o1.getPerformanceChars().getAccuracyRange()).compareTo
                            (String.valueOf(o2.getPerformanceChars().getAccuracyRange()));
                } else if (fieldName.getName().equals(EFieldName.MAGAZINE.getName())) {
                    return String.valueOf(o1.getPerformanceChars().isMagazineCharger()).compareTo
                            (String.valueOf(o2.getPerformanceChars().isMagazineCharger()));
                } else if (fieldName.getName().equals(EFieldName.OPTICAL.getName())) {
                    return String.valueOf(o1.getPerformanceChars().isOpticalSight()).compareTo
                            (String.valueOf(o2.getPerformanceChars().isOpticalSight()));
                } else return 0;
            }
        });
    }
}
