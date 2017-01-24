package model.builders;

import model.carriage.Carriage;
import model.carriage.PassengerCarriage;
import model.characteristics.ComfortLevel;
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
    public void buildTrainParameters(String[] parameters) throws IllegalArgumentException {
        /** Passenger carriage has 3 parameters {ComfortLevel,
         * baggageCapacity, numberOfPassengers}.
         * Advance forward through three parameter step.
         * This is also minimum parameters number for passenger train creation.
         */
        int passengerCarriageStep = 3;
        if (parameters == null || parameters.length <= passengerCarriageStep)
            throw new IllegalArgumentException();

        int parameterPosition = 0;

        // EngineType value parsing.
        EngineType engineType = Carriage.convertString(EngineType.class,
                                parameters[parameterPosition++]);
        if (engineType == null) throw new NumberFormatException();
        train.setEngineType(engineType);

        // NumberOfAvailableSeats value parsing.
        int numberOfAvailableSeats = Integer.parseInt(parameters[parameterPosition++]);
        buildNumberOfAvailableSeats(numberOfAvailableSeats);

        // CarriagesQuantity value parsing.
        int carriagesQuantity = Integer.parseInt(parameters[parameterPosition++]);

        // Passenger carriage values parsing.
        while (parameterPosition < parameters.length) {
            // ComfortLevel value parsing.
            ComfortLevel comfortLevel = Carriage.convertString(ComfortLevel.class,
                                        parameters[parameterPosition + 1]);
            if (comfortLevel == null) throw new NumberFormatException();

            // BaggageCapacity value parsing.
            double baggageCapacity = Double.parseDouble(parameters[parameterPosition + 2]);

            // NumberOfPassengers value parsing.
            int numberOfPassengers = Integer.parseInt(parameters[parameterPosition + 3]);

            // PassengerCarriage creation.
            PassengerCarriage carriage = new PassengerCarriage(comfortLevel, baggageCapacity);
            carriage.setNumberOfPassengers(numberOfPassengers);
            train.addCarrage(carriage);

            parameterPosition += passengerCarriageStep;
        }

        /** Additional checking for proper carriages quantity
         * creation.
         */
        if (carriagesQuantity != train.getCarriagesQuantity()) {
            throw new IllegalArgumentException();
        }
    }

    private void buildNumberOfAvailableSeats(int numberOfAvailableSeats) {
        train.setNumberOfAvailableSeats(numberOfAvailableSeats);
    }
}