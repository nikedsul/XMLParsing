package model.enums;

/**
 * Created by Nikolai on 25.12.2015.
 */
public enum EFieldName {
    ID("ID"),
    MODEL("model"),
    ORIGIN("origin"),
    MATERIAL("material"),
    TWO_HAND("twoHand"),
    FIRE_RANGE("fireRange"),
    ACCURACY_RANGE("accuracyRange"),
    MAGAZINE("magazineCharger"),
    OPTICAL("opticalSight");

    private String fieldName;

    EFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getName() {
        return this.fieldName;
    }
}
