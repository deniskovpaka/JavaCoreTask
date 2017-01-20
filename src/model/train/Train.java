package model.train;

import model.characteristics.EngineType;
import model.carriage.Carriage;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Train{
    private List<Carriage> carriages;
    private EngineType engineType;
    final static Logger logger = Logger.getLogger(Train.class.getName()); // TODO it may be better to use log4j

    public Train() {
        this.carriages = new ArrayList<>();
    }

    public List<Carriage> getCarriagesCopy() {
        List<Carriage> carriagesCopy = new ArrayList<>(carriages);
        return carriagesCopy;
    }

    public void setCarriages(List<Carriage> carriages) {
        this.carriages = carriages;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

    public void addCarrage(Carriage carriage) {
        carriages.add(carriage);
    }

    public void removeCarrage(int carragePosition) {
        if (carragePosition < carriages.size() && carragePosition >= 0)
            carriages.remove(carragePosition);
        else
            logger.log(Level.WARNING, "The carragePosition is invalid it has " +
                    "to be greater/equal to 0 and less than carriages.size() = " +
                    carriages.size());
    }

    public abstract String getTrainName();

    @Override
    public String toString() {
        return "Train{" +
                "carriages=" + carriages +
                ", engineType=" + engineType +
                '}';
    }
}
