package model;

import java.util.ArrayList;
import java.util.List;

public class PassengerTrain extends Train {
    private List<Integer> numberOfPassengersInEveryCarriage;
    private int numberOfAvailableSeats;

    public PassengerTrain() {
        super();
        numberOfPassengersInEveryCarriage = new ArrayList<>();
    }

    public int getNumberOfAvailableSeats() {
        return numberOfAvailableSeats;
    }

    public void setNumberOfAvailableSeats(int numberOfAvailableSeats) {
        this.numberOfAvailableSeats = numberOfAvailableSeats;
    }

    public List<Integer> getNumberOfPassengersInEveryCarriage() {
        return numberOfPassengersInEveryCarriage;
    }

    public void setNumberOfPassengersInEveryCarriage(List<Integer> numberOfPassengersInEveryCarriage) {
        this.numberOfPassengersInEveryCarriage = numberOfPassengersInEveryCarriage;
    }

    @Override
    public String getTrainName() {
        return "PASSENGER_TRAIN";
    }
}
