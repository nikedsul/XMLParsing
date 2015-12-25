package model.parsersXML;

import model.Gun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Nikolai on 24.12.2015.
 */
abstract class ParsersUniting {
    List<Gun> guns = new ArrayList<Gun>();

    public List<Gun> getGuns() {
        return guns;
    }

    public void sortByField(final String fieldName) {
        Collections.sort(guns, new Comparator<Gun>() {
            @Override
            public int compare(Gun o1, Gun o2) {
                if (fieldName.equals("Model")) {
                    return o1.getModel().getName().compareTo(o2.getModel().getName());
                } else if (fieldName.equals("Manufacturer country")) {
                    return o1.getOrigin().getName().compareTo(o2.getOrigin().getName());
                } else if (fieldName.equals("Material")) {
                    return o1.getMaterial().getName().compareTo(o2.getMaterial().getName());
                } else if (fieldName.equals("TwoHand")) {
                    return String.valueOf(o1.isTwoHand()).compareTo
                            (String.valueOf(o2.isTwoHand()));
                } else if (fieldName.equals("Fire range")) {
                    return String.valueOf(o1.getPerformanceChars().getFireRange()).compareTo
                            (String.valueOf(o2.getPerformanceChars().getFireRange()));
                } else if (fieldName.equals("Accuracy range")) {
                    return String.valueOf(o1.getPerformanceChars().getAccuracyRange()).compareTo
                            (String.valueOf(o2.getPerformanceChars().getAccuracyRange()));
                } else if (fieldName.equals("Magazine charger")) {
                    return String.valueOf(o1.getPerformanceChars().isMagazineCharger()).compareTo
                            (String.valueOf(o2.getPerformanceChars().isMagazineCharger()));
                } else if (fieldName.equals("Optical sight")) {
                    return String.valueOf(o1.getPerformanceChars().isOpticalSight()).compareTo
                            (String.valueOf(o2.getPerformanceChars().isOpticalSight()));
                } else return 0;
            }
        });
    }
}
