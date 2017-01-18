package model;

public class FreightTrain extends Train {
    private KindOfGoods kindOfGoods;

    public KindOfGoods getKindOfGoods() {
        return kindOfGoods;
    }

    public void setKindOfGoods(KindOfGoods kindOfGoods) {
        this.kindOfGoods = kindOfGoods;
    }

    @Override
    public String getTrainName() {
        return "FREIGHT_TRAIN";
    }
}
