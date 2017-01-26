package model.carriage;

import model.characteristics.ComfortLevel;

import java.util.EnumSet;
import java.util.List;

/**
 * The Carriage class contains common
 * parameters for all kinds of carriages.
 * {FreightCarriage, HaulageCarriage, PassengerCarriage}.
 *
 * @author deniskovpaka
 */
public abstract class Carriage {
    /**
     * Carriages ID's.
     */
    public static final int FREIGHT_CARRIAGE_ID =       1;
    public static final int HAULAGE_CARRIAGE_ID =       2;
    public static final int PASSENGER_CARRIAGE_ID =     3;

    /**
     * Common attributes for all kinds of carriages.
     */
    private ComfortLevel comfortLevel;
    private double baggageCapacity;

    /**
     * Carriage constructor.
     * @param baggageCapacity
     */
    public Carriage(double baggageCapacity) {
        this.comfortLevel = ComfortLevel.NONE;
        this.baggageCapacity = baggageCapacity;
    }

    /**
     * List of common carriages methods.
     */
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
        return "comfortLevel = " + comfortLevel + "\r\n" +
               "baggageCapacity = " + baggageCapacity + "\r\n";
    }

    /**
     * Specific method for saver's and viewer's classes.
     * As the viewer's classes will be used these parameters in
     * a different ways/modes.
     */
    public abstract String getCarriagesParameters();

    /**
     * This method return specific carriage ID.
     * @return carriage ID.
     */
    public abstract int getCarriageID();

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

    /**
     * This method checks that carriages should be uniform
     * in order to execute one an algorithm on them.
     * @param carriages carriages array.
     * @throws ArrayStoreException if there are different types of carriages.
     */
    public static void areUniformCarriages(List<Carriage> carriages)
            throws ArrayStoreException {
        if (carriages.isEmpty()) return;
        /**
         * Get first carriage ID.
         * It should be unified in list of
         * carriages.
         */
        int carriageID = carriages.get(0).getCarriageID();
        for(Carriage carriage : carriages) {
            if (carriageID != carriage.getCarriageID())
                new ArrayStoreException("Carriage list isn't uniform type");
        }
    }
}