package model;

/**
 * Created by Nikolai on 22.12.2015.
 */
public enum EOrigin {
    RUSSIA("Russia"),
    USA("United States"),
    GERMANY("Germany"),
    FRANCE("France"),
    ITALY("Italy"),
    ENGLAND("England");

    String originName;

    EOrigin(String modelName) {
        this.originName = modelName;
    }

    public String getName() {
        return this.originName;
    }
}
