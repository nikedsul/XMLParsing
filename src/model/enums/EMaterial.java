package model.enums;

/**
 * EMaterial contains all types of a gun material
 * @author Sultan Mykola on 25.12.2015
 * @version X001
 */
public enum EMaterial {
    STEEL("Steel"),
    TITANIUM("Titanium"),
    COMPOSITE("Composite");

    String materialName;

    /**
     * Constructor
     * @param modelName
     */
    EMaterial(String modelName) {
        this.materialName = modelName;
    }

    /**
     * @return value of enum-type
     */
    public String getName() {
        return this.materialName;
    }
}
