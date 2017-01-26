package model.builders;

import model.carriage.Carriage;
import model.carriage.FreightCarriage;
import model.characteristics.EngineType;
import model.characteristics.KindOfGoods;
import model.train.FreightTrain;
import model.train.Train;

/**
 * The FreightTrainBuilder class is responsible
 * for creation a freight train's builder.
 *
 * @author deniskovpaka
 */
public class FreightTrainBuilder extends TrainBuilder {
    FreightTrain train;

    /**
     * FreightTrainBuilder constructor.
     */
    public FreightTrainBuilder() {
        super(TrainBuilder.FREIGHT_CARRIAGE_PARAMETER_QUANTITY);
    }

    @Override
    public void createTrain() {
        train = new FreightTrain();
    }

    @Override
    public Train getTrain() {
        return train;
    }

    /**
     * Builds freight train parameters by using String array.
     * @param parameters freight train attributes.
     * @throws NumberFormatException in case of invalid parameter.
     */
    @Override
    public void buildTrainParameters(String[] parameters) throws IllegalArgumentException {
        /**
         * (TrainBuilder.FREIGHT_TRAIN_PARAMETER_QUANTITY) this is
         * a minimum parameters number for freight train creation:
         * {Freight, EngineType}.
         */
        checkInputParametersSize(TrainBuilder.FREIGHT_TRAIN_PARAMETER_QUANTITY,
                                parameters);

        int parameterPosition = 0;

        // EngineType value parsing.
        EngineType engineType = Carriage.convertString(EngineType.class,
                parameters[parameterPosition++]);
        buildEngineType(engineType, train);

        /**
         * Create freight carriages if and only if there
         * are exist parameters for their creation.
         */
        if (areParametersExistForCarriagesCreation(TrainBuilder.FREIGHT_TRAIN_PARAMETER_QUANTITY,
                                                    parameters)) {
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

                parameterPosition += TrainBuilder.FREIGHT_CARRIAGE_PARAMETER_QUANTITY;
            }
            checkCorrectnessCreatedCarriagesNumbe(carriagesQuantity, train.getCarriagesQuantity());
        }
    }
}