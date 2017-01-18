package infrastructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Train {
    private List<Carrage> carrages;
    private EngineType engineType;
    final static Logger logger = Logger.getLogger(Train.class.getName()); // TODO it may be better to use log4j

    public Train(EngineType engineType) {
        this.carrages = new ArrayList<>();
        this.engineType = engineType;
    }

    public List<Carrage> getCarrages() {
        List<Carrage> copyCarrages = new ArrayList<>(carrages.size());
        Collections.copy(copyCarrages, carrages);
        return copyCarrages;
    }

    public void setCarrages(List<Carrage> carrages) {
        this.carrages = carrages;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

    public void addCarrage(Carrage carrage) {
        carrages.add(carrage);
    }

    public void removeCarrage(int carragePosition) {
        if (carragePosition < carrages.size() && carragePosition >= 0)
            carrages.remove(carragePosition);
        else
            logger.log(Level.WARNING, "The carragePosition is invalid it has " +
                    "to be greater/equal to 0 and less than carrages.size() = " +
                    carrages.size());
    }

    public abstract String getTrainName();
}
