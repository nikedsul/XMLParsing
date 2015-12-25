package model.enums;

/**
 * EModel contains names of all gun models
 * @author Sultan Mykola on 25.12.2015
 * @version X001
 */
public enum EModel {
    PISTOL("pistol"),
    ASSAULT_RIFLE("assault rifle"),
    GRENADE_LAUNCHER("grenade launcher"),
    SUBMACHINE_GUN("submachine gun");

    String modelName;

    /**
     * constructor
     * @param modelName
     */
    EModel(String modelName) {
        this.modelName = modelName;
    }

    /**
     * @return value of enum-type
     */
    public String getName() {
        return this.modelName;
    }
}
