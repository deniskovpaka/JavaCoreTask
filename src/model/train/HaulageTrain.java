package model.train;

public class HaulageTrain extends Train {
    private double carriageCost;
    private boolean onRepair;

    public boolean isOnRepair() {
        return onRepair;
    }

    public void setOnRepair(boolean onRepair) {
        this.onRepair = onRepair;
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
}
