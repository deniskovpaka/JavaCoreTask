package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Train {
    private List<Carriage> carriages;
    private EngineType engineType;
    final static Logger logger = Logger.getLogger(Train.class.getName()); // TODO it may be better to use log4j

    public Train() {
        this.carriages = new ArrayList<>();
    }

    public List<Carriage> getCarriages() {
        List<Carriage> copyCarriages = new ArrayList<>(carriages.size());
        Collections.copy(copyCarriages, carriages);
        return copyCarriages;
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
}
