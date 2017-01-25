package model.carriage;

public class HaulageCarriage extends Carriage {
    private int tractionForce;

    public HaulageCarriage(double baggageCapacity, int tractionForce) {
        super(baggageCapacity);
        this.tractionForce = tractionForce;
    }

    public int getTractionForce() {
        return tractionForce;
    }

    public void setTractionForce(int tractionForce) {
        this.tractionForce = tractionForce;
    }

    @Override
    public String getCarriagesParameters() {
        return getComfortLevel()
                + ", " + getBaggageCapacity()
                + ", " + getTractionForce();
    }
}