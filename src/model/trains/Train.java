package model.trains;

import model.characteristics.EngineType;
import model.carriages.Carriage;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The Train class contains common
 * parameters for all kinds of trains.
 * {FreightTrain, HaulageTrain, PassengerTrain}.
 *
 * @author deniskovpaka
 */
public abstract class Train {
    /**
     * Train names.
     */
    public static final String FREIGHT_TRAIN_NAME =     "Freight";
    public static final String HAULAGE_TRAIN_NAME =     "Haulage";
    public static final String PASSENGER_TRAIN_NAME =   "Passenger";

    /**
     * Store specific kinds of carriages.
     * {FreightCarriage, HaulageCarriage, PassengerCarriage}.
     */
    private List<Carriage> carriages;

    private EngineType engineType;
    final static Logger logger = Logger.getLogger(Train.class.getName());

    /**
     * Train constructor.
     */
    public Train() {
        this.carriages = new LinkedList<>();
    }

    public List<Carriage> getCarriagesCopy() {
        List<Carriage> carriagesCopy = new LinkedList<>(carriages);
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

    /**
     * Add specific carriage.
     * @param carriage
     */
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

    public int getCarriagesQuantity() {
        return carriages.size();
    }

    @Override
    public String toString() {
        return getTrainName() +
                ", engineType = " + engineType +
                "carriages = {\n" + carriages +
                '}';
    }

    /**
     * Some specific methods for saver's and viewer's classes.
     * As the viewer's classes will be used these parameters in
     * a different ways/modes.
     */
    public abstract String getTrainName();
    public abstract String getTrainParameters();
    public abstract int getTrainParameterQuantity();

    /**
     * This is a specific method that uses by saver's
     * class.
     * @return carriages parameters as string.
     */
    protected String getCarriagesParameters() {
        StringBuilder carriagesParameters = new StringBuilder();
        if (getCarriagesQuantity() > 0) {
            carriagesParameters.append(getCarriagesQuantity()).append(", ");
            for (Carriage carriage : getCarriagesCopy())
                carriagesParameters.append(carriage.getCarriagesParameter())
                                    .append(", ");
        }
        return carriagesParameters.toString();
    }
}