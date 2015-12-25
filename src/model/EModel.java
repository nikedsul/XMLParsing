package model;

/**
 * Created by Nikolai on 22.12.2015.
 */
public enum EModel {
    PISTOL("pistol"),
    ASSAULT_RIFLE("assault rifle"),
    GRENADE_LAUNCHER("grenade launcher"),
    SUBMACHINE_GUN("submachine gun");

    String modelName;

    EModel(String modelName) {
        this.modelName = modelName;
    }

    public String getName() {
        return this.modelName;
    }
}
