package model.train;

import model.train.Train;

public class HaulageTrain extends Train {
    private double trainPower;

    public double getTrainPower() {
        return trainPower;
    }

    public void setTrainPower(double trainPower) {
        this.trainPower = trainPower;
    }

    @Override
    public String getTrainName() {
        return "HAULAGE_TRAIN";
    }
}
