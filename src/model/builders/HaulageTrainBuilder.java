package model.builders;

import model.carriages.Carriage;
import model.carriages.HaulageCarriage;
import model.characteristics.ComfortLevel;
import model.characteristics.EngineType;
import model.trains.HaulageTrain;
import model.trains.Train;

/**
 * The HaulageTrainBuilder class is responsible
 * for creation a haulage train's builder.
 *
 * @author deniskovpaka
 */
public class HaulageTrainBuilder extends TrainBuilder {
    HaulageTrain train;

    /**
     * HaulageTrainBuilder constructor.
     */
    public HaulageTrainBuilder() {
        super(TrainBuilder.HAULAGE_CARRIAGE_PARAMETER_QUANTITY);
    }

    @Override
    public void createTrain() {
        train = new HaulageTrain();
    }

    @Override
    public Train getTrain() {
        return train;
    }

    /**
     * Builds haulage train parameters by using String array.
     * @param parameters haulage train attributes.
     * @throws NumberFormatException in case of invalid parameter.
     */
    @Override
    public void buildTrainParameters(String[] parameters) throws IllegalArgumentException {
        /**
         * (TrainBuilder.HAULAGE_TRAIN_PARAMETER_QUANTITY) this is
         * a minimum parameters number for haulage train creation:
         * {Haulage, EngineType, CarriageCost, isOnRepair}.
         */
        checkInputParametersSize(TrainBuilder.HAULAGE_TRAIN_PARAMETER_QUANTITY,
                                parameters);

        int parameterPosition = 0;

        // EngineType value parsing.
        EngineType engineType = Carriage.convertString(EngineType.class,
                parameters[parameterPosition++]);
        buildEngineType(engineType, train);

        // CarriageCost value parsing.
        double carriageCost = Double.parseDouble(parameters[parameterPosition++]);
        buildCarriageCost(carriageCost);

        // IsOnRepair value parsing.
        boolean isOnRepair = Boolean.parseBoolean(parameters[parameterPosition++]);
        buildIsOnRepairParameter(isOnRepair);

        /**
         * Create haulage carriages if and only if there
         * are exist parameters for their creation.
         */
        if (areParametersExistForCarriagesCreation(TrainBuilder.HAULAGE_TRAIN_PARAMETER_QUANTITY,
                                                    parameters)) {
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
                buildComfortLevel(carriage, comfortLevel);
                train.addCarrage(carriage);

                parameterPosition += TrainBuilder.HAULAGE_CARRIAGE_PARAMETER_QUANTITY;
            }
            checkCorrectnessCreatedCarriagesNumbe(carriagesQuantity, train.getCarriagesQuantity());
        }
    }

    /**
     * Some specific private build methods for creation haulage train.
     */
    private void buildCarriageCost(double carriageCost) {
        train.setCarriageCost(carriageCost);
    }

    private void buildIsOnRepairParameter(boolean isOnRepair) {
        train.setOnRepair(isOnRepair);
    }

    private void buildComfortLevel(HaulageCarriage carriage, ComfortLevel comfortLevel) {
        carriage.setComfortLevel(comfortLevel);
    }
}