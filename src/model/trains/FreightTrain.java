package model.trains;

import model.builders.TrainBuilder;

/**
 * The FreightTrain class represent freight train.
 *
 * @author deniskovpaka
 */
public class FreightTrain extends Train {
    @Override
    public String getTrainName() {
        return FREIGHT_TRAIN_NAME;
    }

    @Override
    public String getTrainParameters() {
        return getTrainName()
                + ", " + getEngineType()
                + ", " + getCarriagesParameters();
    }

    @Override
    public int getTrainParameterQuantity() {
        return TrainBuilder.FREIGHT_TRAIN_PARAMETER_QUANTITY;
    }
}