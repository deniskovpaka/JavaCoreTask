package model.carriage;

import model.characteristics.KindOfGoods;

/**
 * This class represent the freight carriage.
 *
 * @author deniskovpaka
 */
public class FreightCarriage extends Carriage {
    private KindOfGoods kindOfGoods;

    /**
     * FreightCarriage constructor.
     * @param baggageCapacity
     * @param kindOfGoods kind of goods in a carriage.
     */
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

    @Override
    public String toString() {
        return "FreightCarriage: " +
                "kindOfGoods = " + getKindOfGoods() + "\r\n"
                + super.toString();
    }

    @Override
    public String getCarriagesParameters() {
        return getBaggageCapacity()
                + ", " + getKindOfGoods();
    }

    @Override
    public int getCarriageID() {
        return FREIGHT_CARRIAGE_ID;
    }
}