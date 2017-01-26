package model.builders;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The BuilderFactory class is responsible
 * for creation a specific train's builder.
 *
 * @author deniskovpaka
 */
public class BuilderFactory {
    final static Logger logger = Logger.getLogger(BuilderFactory.class.getName());
    /**
     * Use createTrainBuilder method to get
     * object of type TrainBuilder.
     * @param builderName
     * @return specific TrainBuilder
     */
    public static TrainBuilder createTrainBuilder(String builderName) {
        if (builderName == null) {
            logger.log(Level.WARNING, "The TrainBuilder creation FAILED!!!" +
                    " The builderName is NULL.");
            return null;
        }
        if (builderName.equalsIgnoreCase("PASSENGER")) {
            return new PassengerTrainBuilder();
        } else if (builderName.equalsIgnoreCase("FREIGHT")) {
            return new FreightTrainBuilder();
        } else if (builderName.equalsIgnoreCase("HAULAGE")) {
            return new HaulageTrainBuilder();
        }
        logger.log(Level.WARNING, "The TrainBuilder creation FAILED!!!" +
                " The builderName is UNKNOWN.");
        return null;
    }
}