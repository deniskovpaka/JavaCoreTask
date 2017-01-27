package model.carriages;

import model.characteristics.ComfortLevel;

/**
 * PassengerCarriage class represent the passenger carriage.
 *
 * @author deniskovpaka
 */
public class PassengerCarriage extends Carriage {
    private int numberOfPassengers;

    /**
     * PassengerCarriage constructor.
     * @param comfortLevel
     * @param baggageCapacity
     */
    public PassengerCarriage(ComfortLevel comfortLevel, double baggageCapacity) {
        super(baggageCapacity);
        setComfortLevel(comfortLevel);
    }
    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    @Override
    public String toString() {
        return "PassengerCarriage: "
                + "numberOfPassengers = " + numberOfPassengers
                + super.toString();
    }

    @Override
    public String getCarriagesParameters() {
        return getComfortLevel()
                + ", " + getBaggageCapacity()
                + ", " + getNumberOfPassengers();
    }

    @Override
    public int getCarriageID() {
        return PASSENGER_CARRIAGE_ID;
    }
}