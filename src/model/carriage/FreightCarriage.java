package model.carriage;

import model.characteristics.KindOfGoods;

public class FreightCarriage extends Carriage {
    private KindOfGoods kindOfGoods;

    public FreightCarriage(double baggageCapacity, KindOfGoods kindOfGoods) {
        super(baggageCapacity);
        this.kindOfGoods = kindOfGoods;
    }

    public KindOfGoods getKindOfGoods() {
        return kindOfGoods;
    }

    public void setKindOfGoods(KindOfGoods kindOfGoods) {
        this.kindOfGoods = kindOfGoods;
    }
}
