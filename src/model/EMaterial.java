package model;

/**
 * Created by Nikolai on 22.12.2015.
 */
public enum EMaterial {
    STEEL("Steel"),
    TITANIUM("Titanium"),
    COMPOSITE("Composite");

    String materialName;

    EMaterial(String modelName) {
        this.materialName = modelName;
    }

    public String getName() {
        return this.materialName;
    }
}
