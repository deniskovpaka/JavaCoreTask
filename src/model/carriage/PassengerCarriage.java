package model.carriage;

import model.characteristics.ComfortLevel;

public class PassengerCarriage extends Carriage {
    private int numberOfPassengers;
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
        return super.toString() +
                ", numberOfPassengers=" + numberOfPassengers +
                '}';
    }
}
