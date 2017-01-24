package model.builders;

import model.carriage.Carriage;
import model.carriage.FreightCarriage;
import model.characteristics.EngineType;
import model.characteristics.KindOfGoods;
import model.train.FreightTrain;
import model.train.Train;

public class FreightTrainBuilder implements TrainBuilder {
    FreightTrain train;

    @Override
    public void createTrain() {
        train = new FreightTrain();
    }

    @Override
    public Train getTrain() {
        return train;
    }

    @Override
    public void buildTrainParameters(String[] parameters) throws IllegalArgumentException {
        /** Freight carriage has 2 parameters
        * {baggageCapacity, KindOfGoods}.
        * Advance forward through two parameter step.
        * This is also minimum parameters number for freight train creation.
        */
        int freightCarriageStep = 2;
        if (parameters == null || parameters.length <= freightCarriageStep)
            throw new IllegalArgumentException();

        int parameterPosition = 0;

        // EngineType value parsing.
        EngineType engineType = Carriage.convertString(EngineType.class,
                parameters[parameterPosition++]);
        if (engineType == null) throw new NumberFormatException();
        train.setEngineType(engineType);

        // CarriagesQuantity value parsing.
        int carriagesQuantity = Integer.parseInt(parameters[parameterPosition++]);

        // Freight carriage values parsing.
        while (parameterPosition < parameters.length) {
            // BaggageCapacity value parsing.
            double baggageCapacity = Double.parseDouble(parameters[parameterPosition + 1]);

            // KindOfGoods value parsing.
            KindOfGoods kindOfGoods = Carriage.convertString(KindOfGoods.class,
                                        parameters[parameterPosition + 2]);

            // FreightTrain creation.
            FreightCarriage carriage = new FreightCarriage(baggageCapacity, kindOfGoods);
            train.addCarrage(carriage);

            parameterPosition += freightCarriageStep;
        }

        /** Additional checking for proper carriages quantity
         * creation.
         */
        if (carriagesQuantity != train.getCarriagesQuantity()) {
            throw new IllegalArgumentException();
        }
    }
}
