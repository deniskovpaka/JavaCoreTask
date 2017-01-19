package model;

public class PassengerTrain extends Train {
    private int numberOfAvailableSeats;

    public int getNumberOfAvailableSeats() {
        return numberOfAvailableSeats;
    }

    public void setNumberOfAvailableSeats(int numberOfAvailableSeats) {
        this.numberOfAvailableSeats = numberOfAvailableSeats;
    }

    @Override
    public String getTrainName() {
        return "PASSENGER_TRAIN";
    }

    @Override
    public String toString() {
        return super.toString() + " PassengerTrain{" +
                "numberOfAvailableSeats=" + numberOfAvailableSeats +
                '}';
    }
}