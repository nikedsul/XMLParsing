package model.enums;

/**
 * EOrigin contains all types of manufacturer countries
 * @author Sultan Mykola on 25.12.2015
 * @version X001
 */
public enum EOrigin {
    RUSSIA("Russia"),
    USA("United States"),
    GERMANY("Germany"),
    FRANCE("France"),
    ITALY("Italy"),
    ENGLAND("England");

    String originName;

    /**
     * constructor
     * @param modelName
     */
    EOrigin(String modelName) {
        this.originName = modelName;
    }

    public String getName() {
        return this.originName;
    }
}
