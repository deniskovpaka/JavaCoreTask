package model.carriage;

import model.characteristics.ComfortLevel;

public abstract class Carriage {
    private ComfortLevel comfortLevel;
    private double baggageCapacity;

    public Carriage(double baggageCapacity) {
        this.comfortLevel = ComfortLevel.NONE;
        this.baggageCapacity = baggageCapacity;
    }

    public ComfortLevel getComfortLevel() {
        return comfortLevel;
    }

    public void setComfortLevel(ComfortLevel comfortLevel) {
        this.comfortLevel = comfortLevel;
    }

    public double getBaggageCapacity() {
        return baggageCapacity;
    }

    @Override
    public String toString() {
        return "Carriage{" +
                "comfortLevel=" + comfortLevel +
                ", baggageCapacity=" + baggageCapacity;
    }

    /**
     * Specific method for saver's and viewer's classes.
     * As the viewer's classes will be used these parameters in
     * a different ways/modes.
     */
    public abstract String getCarriagesParameters();
}