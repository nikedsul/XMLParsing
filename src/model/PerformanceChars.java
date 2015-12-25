package model;

/**
 * Created by Nikolai on 22.12.2015.
 */
public class PerformanceChars {
    int fireRange;
    int accuracyRange;
    boolean magazineCharger;
    boolean opticalSight;

    public PerformanceChars(int fireRange, int accuracyRange, boolean magazineCharger, boolean opticalSight) {
        this.fireRange = fireRange;
        this.accuracyRange = accuracyRange;
        this.magazineCharger = magazineCharger;
        this.opticalSight = opticalSight;
    }

    public int getFireRange() {
        return fireRange;
    }

    public int getAccuracyRange() {
        return accuracyRange;
    }

    public boolean isMagazineCharger() {
        return magazineCharger;
    }

    public boolean isOpticalSight() {
        return opticalSight;
    }

    /**
     * Returns a string representation of the object.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "Fire range: "
                .concat(String.valueOf(this.getFireRange()))
                .concat(". Accuracy range: ")
                .concat(String.valueOf(this.getAccuracyRange()))
                .concat(". Magazine charger: ")
                .concat(String.valueOf(this.isMagazineCharger()))
                .concat(". Optical sight: ")
                .concat(String.valueOf(this.isOpticalSight()));
    }
}
