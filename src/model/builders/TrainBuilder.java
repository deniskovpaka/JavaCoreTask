package model.builders;

import model.characteristics.EngineType;
import model.trains.Train;

/**
 * The TrainBuilder class is responsible
 * for creation specific train.
 *
 * @author deniskovpaka
 */
public abstract class TrainBuilder {
    /** Every train has a various parameters quantity.
     * Freight train {Freight, EngineType}.
     * Passenger train {Passenger, EngineType, NumberOfAvailableSeats}.
     * Haulage train {Haulage, EngineType, CarriageCost, isOnRepair}.
     */
    public static int FREIGHT_TRAIN_PARAMETER_QUANTITY = 2;
    public static int PASSENGER_TRAIN_PARAMETER_QUANTITY = 3;
    public static int HAULAGE_TRAIN_PARAMETER_QUANTITY = 4;

    /** Every carriage has a various parameters quantity.
     * Freight carriage {baggageCapacity, KindOfGoods}.
     * Passenger carriage {baggageCapacity, ComfortLevel, numberOfPassengers}.
     * Haulage carriage {baggageCapacity, ComfortLevel, tractionForce}.
     * Advance forward through *carriageParameterQuantity* parameter step.
     */
    public static int FREIGHT_CARRIAGE_PARAMETER_QUANTITY = 2;
    public static int PASSENGER_CARRIAGE_PARAMETER_QUANTITY = 3;
    public static int HAULAGE_CARRIAGE_PARAMETER_QUANTITY = 3;
    protected final int carriageParameterQuantity;

    /**
     * TrainBuilder constructor.
     * @param carriageParameterQuantity carriage parameter quantity.
     */
    public TrainBuilder(int carriageParameterQuantity) {
        this.carriageParameterQuantity = carriageParameterQuantity;
    }

    /**
     * A template method for building specific train.
     * @param parameters train attributes.
     * @return new specific train.
     */
    public final Train buildTrain(String[] parameters) throws IllegalArgumentException {
        createTrain();
        buildTrainParameters(parameters);
        return getTrain();
    }

    abstract Train getTrain();
    abstract void createTrain();

    /**
     * Builds train parameters by using String array.
     * Each string parameter is parsed for specific train attribute.
     * @param parameters train attributes.
     * @throws NumberFormatException in case of invalid parameter.
     */
    abstract void buildTrainParameters(String[] parameters) throws IllegalArgumentException;

    /**
     * Check input string array size for validity and
     * minimum required parameters for train creation.
     * @param minimumRequiredParameters minimum parameters for train creation.
     * @param parameters train parameters as string array.
     * @throws IllegalArgumentException in case of invalid input parameters.
     */
    protected void checkInputParametersSize(int minimumRequiredParameters,
                                            String[] parameters) {
        if (parameters == null || minimumRequiredParameters > parameters.length)
            throw new IllegalArgumentException();
    }

    /**
     * Additional checking for proper carriages quantity creation.
     * @param numberOfRequiredCarriages
     * @param numberOfCreatedCarriages
     * @throws IllegalArgumentException in case of invalid created carriages.
     */
    protected void checkCorrectnessCreatedCarriagesNumbe(int numberOfRequiredCarriages,
                                                         int numberOfCreatedCarriages) {
        if (numberOfRequiredCarriages != numberOfCreatedCarriages)
            throw new IllegalArgumentException();
    }

    /**
     * Check if there are exist parameters for carriages creation.
     * @param minimumRequiredParameters minimum parameters for train creation.
     * @param parameters train parameters as string array.
     * @return TRUE parameters contains attributes for carriages creation, FALSE otherwise.
     */
    protected boolean areParametersExistForCarriagesCreation(int minimumRequiredParameters,
                                                             String[] parameters) {
        return minimumRequiredParameters < parameters.length;
    }

    /**
     * Builds train's engine type.
     * @param engineType
     * @param train
     * @throws NumberFormatException in case of invalid input parameters.
     */
    protected void buildEngineType(EngineType engineType, Train train) {
        if (engineType == null) throw new NumberFormatException();
        train.setEngineType(engineType);
    }
}