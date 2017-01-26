package model.train;

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
                + ", " + getCarriagesQuantity();
    }
}