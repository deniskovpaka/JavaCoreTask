package model.builders;

import model.carriage.Carriage;
import model.carriage.PassengerCarriage;
import model.characteristics.ComfortLevel;
import model.characteristics.EngineType;
import model.train.PassengerTrain;
import model.train.Train;

public class PassengerTrainBuilder extends TrainBuilder {
    private PassengerTrain train;

    public PassengerTrainBuilder() {
        super(TrainBuilder.PASSENGER_CARRIAGE_PARAMETER_QUANTITY);
    }

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
        /**
         * (TrainBuilder.PASSENGER_TRAIN_PARAMETER_QUANTITY) this is
         * a minimum parameters number for passenger train creation:
         * {Passenger, EngineType, NumberOfAvailableSeats}.
         */
        checkInputParametersSize(TrainBuilder.PASSENGER_TRAIN_PARAMETER_QUANTITY,
                                parameters);

        int parameterPosition = 0;

        // EngineType value parsing.
        EngineType engineType = Carriage.convertString(EngineType.class,
                                parameters[parameterPosition++]);
        buildEngineType(engineType, train);

        // NumberOfAvailableSeats value parsing.
        int numberOfAvailableSeats = Integer.parseInt(parameters[parameterPosition++]);
        buildNumberOfAvailableSeats(numberOfAvailableSeats);

        /**
         * Create passengers carriages if and only if there
         * are exist parameters for their creation.
         */
        if (areParametersExistForCarriagesCreation(TrainBuilder.PASSENGER_TRAIN_PARAMETER_QUANTITY,
                                                    parameters)) {
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
                buildNumberOfPassengersInCarriage(carriage, numberOfPassengers);
                train.addCarrage(carriage);

                parameterPosition += TrainBuilder.PASSENGER_CARRIAGE_PARAMETER_QUANTITY;
            }
            checkCorrectnessCreatedCarriagesNumbe(carriagesQuantity, train.getCarriagesQuantity());
        }
    }

    private void buildNumberOfAvailableSeats(int numberOfAvailableSeats) {
        train.setNumberOfAvailableSeats(numberOfAvailableSeats);
    }

    private void buildNumberOfPassengersInCarriage(PassengerCarriage passengerCarriage,
                                                   int numberOfPassengers) {
        passengerCarriage.setNumberOfPassengers(numberOfPassengers);
    }
}