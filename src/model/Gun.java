package model;

import model.enums.EMaterial;
import model.enums.EModel;
import model.enums.EOrigin;

/**
 * Created by Nikolai on 22.12.2015.
 */
public class Gun {
    private int ID;
    private EModel model;
    private EOrigin origin;
    private EMaterial material;
    private boolean twoHand;
    private PerformanceChars performanceChars;

    public Gun(int ID, EModel model, EOrigin origin, EMaterial material, boolean twoHand, PerformanceChars performanceChars) {
        this.ID = ID;
        this.model = model;
        this.origin = origin;
        this.material = material;
        this.twoHand = twoHand;
        this.performanceChars = performanceChars;
    }

    public int getID() {
        return ID;
    }

    public EModel getModel() {
        return model;
    }

    public EOrigin getOrigin() {
        return origin;
    }

    public EMaterial getMaterial() {
        return material;
    }

    public boolean isTwoHand() {
        return twoHand;
    }

    public PerformanceChars getPerformanceChars() {
        return performanceChars;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "Gun[ID_".concat(String.valueOf(this.getID()))
                .concat("] - Model: ")
                .concat(this.getModel().getName())
                .concat(".  Manufacturer country: ")
                .concat(this.getOrigin().getName())
                .concat(". Material: ")
                .concat(this.getMaterial().getName())
                .concat(". TwoHand: ")
                .concat(String.valueOf(this.isTwoHand())
                .concat(". ")
                .concat(getPerformanceChars().toString()));
    }
}
