package model.carriage;

import model.characteristics.ComfortLevel;

import java.util.EnumSet;

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

    /**
     * This method implements the common algorithm in order to
     * get specific enum value. As every carriage has a some
     * certain enum parameter.
     * @param clazz carriage enum.
     * @param str carriage enum as String.
     * @return certain enum parameter.
     */
    public static <E extends Enum<E>>
    E convertString(Class<E> clazz, String str){
        for(E en : EnumSet.allOf(clazz)){
            if(en.toString().equals(str.toUpperCase())){
                return en;
            }
        }
        return null;
    }
}