package model.builders;

import model.carriage.Carriage;
import model.carriage.HaulageCarriage;
import model.characteristics.ComfortLevel;
import model.characteristics.EngineType;
import model.train.HaulageTrain;
import model.train.Train;

public class HaulageTrainBuilder implements TrainBuilder {
    HaulageTrain train;

    @Override
    public void createTrain() {
        train = new HaulageTrain();
    }

    @Override
    public Train getTrain() {
        return train;
    }

    @Override
    public void buildTrainParameters(String[] parameters) throws IllegalArgumentException {
        /** Freight carriage has 3 parameters
         * {baggageCapacity, ComfortLevel, tractionForce}.
         * Advance forward through three parameter step.
         * (haulageCarriageStep + 1) is also minimum parameters
         * number for freight train creation.
         */
        int haulageCarriageStep = 3;
        if (parameters == null || parameters.length <= (haulageCarriageStep + 1))
            throw new IllegalArgumentException();

        int parameterPosition = 0;

        // EngineType value parsing. // TODO remove dups in all builders
        EngineType engineType = Carriage.convertString(EngineType.class,
                parameters[parameterPosition++]);
        if (engineType == null) throw new NumberFormatException();
        train.setEngineType(engineType);

        // CarriageCost value parsing.
        double carriageCost = Double.parseDouble(parameters[parameterPosition++]);
        buildCarriageCost(carriageCost);

        // IsOnRepair value parsing.
        boolean isOnRepair = Boolean.parseBoolean(parameters[parameterPosition++]);
        buildIsOnRepairParameter(isOnRepair);

        // CarriagesQuantity value parsing.
        int carriagesQuantity = Integer.parseInt(parameters[parameterPosition++]);

        // Haulage carriage values parsing.
        while (parameterPosition < parameters.length) {
            // ComfortLevel value parsing.
            ComfortLevel comfortLevel = Carriage.convertString(ComfortLevel.class,
                    parameters[parameterPosition + 1]);
            if (comfortLevel == null) throw new NumberFormatException();

            // BaggageCapacity value parsing.
            double baggageCapacity = Double.parseDouble(parameters[parameterPosition + 2]);

            // TractionForce value parsing.
            int tractionForce = Integer.parseInt(parameters[parameterPosition + 3]);

            // FreightTrain creation.
            HaulageCarriage carriage = new HaulageCarriage(baggageCapacity, tractionForce);
            carriage.setComfortLevel(comfortLevel);
            train.addCarrage(carriage);

            parameterPosition += haulageCarriageStep;
        }

        /** Additional checking for proper carriages quantity
         * creation.
         */
        if (carriagesQuantity != train.getCarriagesQuantity()) {  // TODO remove dups in all builders
            throw new IllegalArgumentException();
        }
    }

    private void buildCarriageCost(double carriageCost) {
        train.setCarriageCost(carriageCost);
    }

    private void buildIsOnRepairParameter(boolean isOnRepair) {
        train.setOnRepair(isOnRepair);
    }
}
