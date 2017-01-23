package model.builders;

import model.characteristics.EngineType;
import model.train.PassengerTrain;
import model.train.Train;

public class PassengerTrainBuilder implements TrainBuilder {
    PassengerTrain train;

    @Override
    public void createTrain() {
        train = new PassengerTrain();
    }

    @Override
    public Train getTrain() {
        return train;
    }

    @Override
    public void buildTrainParameters(String[] parameters) {
        // Passenger carriage has 3 parameters {ComfortLevel,
        // baggageCapacity, numberOfPassengers}.
        // Advance forward through three parameter step.
        int passengerCarriageStep = 3;
        int parameterPosition = 0;
        train.setEngineType(EngineType.convertString(parameters[parameterPosition++]));
        int numberOfAvailableSeats = Integer.parseInt(parameters[parameterPosition++]);
        buildNumberOfAvailableSeats(numberOfAvailableSeats);
        int carriagesQuantity = Integer.parseInt(parameters[parameterPosition++]);
        while (parameterPosition < parameters.length) {

            parameterPosition += passengerCarriageStep;
        }
        if (carriagesQuantity != train.getCarriagesQuantity()) {
            throw new IllegalArgumentException();
        }
    }

    private void buildNumberOfAvailableSeats(int numberOfAvailableSeats) {
        train.setNumberOfAvailableSeats(numberOfAvailableSeats);
    }
}