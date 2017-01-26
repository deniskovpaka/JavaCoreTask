package model.carriages;

/**
 * HaulageCarriage class represent the haulage carriage.
 *
 * @author deniskovpaka
 */
public class HaulageCarriage extends Carriage {
    private int tractionForce;

    /**
     * HaulageCarriage constructor.
     * @param baggageCapacity
     * @param tractionForce
     */
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
    public String toString() {
        return "HaulageCarriage: " +
                "tractionForce = " + getTractionForce() + "\r\n"
                + super.toString();
    }

    @Override
    public String getCarriagesParameters() {
        return getComfortLevel()
                + ", " + getBaggageCapacity()
                + ", " + getTractionForce();
    }

    @Override
    public int getCarriageID() {
        return HAULAGE_CARRIAGE_ID;
    }
}