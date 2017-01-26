package model.train;

/**
 * PassengerTrain class represent the passenger train.
 *
 * @author deniskovpaka
 */
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
        return PASSENGER_TRAIN_NAME;
    }

    @Override
    public String getTrainParameters() {
        return getTrainName()
                + ", " + getEngineType()
                + ", " + getNumberOfAvailableSeats()
                + ", " + getCarriagesQuantity();
    }
}