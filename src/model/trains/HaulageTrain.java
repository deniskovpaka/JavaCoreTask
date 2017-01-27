package model.trains;

import model.builders.TrainBuilder;

/**
 * HaulageTrain class represent the haulage train.
 *
 * @author deniskovpaka
 */
public class HaulageTrain extends Train {
    private double carriageCost;
    private boolean isOnRepair;

    public boolean isOnRepair() {
        return isOnRepair;
    }

    public void setOnRepair(boolean onRepair) {
        this.isOnRepair = onRepair;
    }

    public double getCarriageCost() {
        return carriageCost;
    }

    public void setCarriageCost(double carriageCost) {
        this.carriageCost = carriageCost;
    }

    @Override
    public String getTrainName() {
        return HAULAGE_TRAIN_NAME;
    }

    @Override
    public String getTrainParameters() {
        return getTrainName()
                + ", " + getEngineType()
                + ", " + getCarriageCost()
                + ", " + isOnRepair()
                + ", " + getCarriagesParameters();
    }

    @Override
    public int getTrainParameterQuantity() {
        return TrainBuilder.HAULAGE_TRAIN_PARAMETER_QUANTITY;
    }
}