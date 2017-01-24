package model.train;

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
        return "HAULAGE_TRAIN";
    }

    @Override
    public String getTrainParameters() {
        return getTrainName()
                + ", " + getEngineType()
                + ", " + getCarriageCost()
                + ", " + isOnRepair()
                + ", " + getCarriagesQuantity();
    }
}
