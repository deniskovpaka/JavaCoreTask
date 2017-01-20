package model.train;

public class FreightTrain extends Train {
    private int cargoCost;

    public int getCargoCost() {
        return cargoCost;
    }

    public void setCargoCost(int cargoCost) {
        this.cargoCost = cargoCost;
    }

    @Override
    public String getTrainName() {
        return "FREIGHT_TRAIN";
    }
}