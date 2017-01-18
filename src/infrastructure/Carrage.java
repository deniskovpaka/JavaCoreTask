package infrastructure;

public class Carrage {
    private ComfortLevel comfortLevel;
    private double baggageCapacity;

    public Carrage(ComfortLevel comfortLevel, double baggageCapacity) {
        this.comfortLevel = comfortLevel;
        this.baggageCapacity = baggageCapacity;
    }

    public ComfortLevel getComfortLevel() {
        return comfortLevel;
    }

    public void setComfortLevel(ComfortLevel comfortLevel) {
        this.comfortLevel = comfortLevel;
    }

    public double getBaggageCapacity() {
        return baggageCapacity;
    }

    @Override
    public String toString() {
        return "Carrage{" +
                "comfortLevel=" + comfortLevel +
                ", baggageCapacity=" + baggageCapacity +
                '}';
    }
}
