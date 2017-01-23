package model.train;

public class FreightTrain extends Train {
    @Override
    public String getTrainName() {
        return "FREIGHT_TRAIN";
    }

    @Override
    public String getTrainParameters() {
        return getTrainName()
                + ", " + getEngineType()
                + ", " + getCarriagesQuantity();
    }
}