package algorithms;

import model.carriages.Carriage;
import model.characteristics.ComfortLevel;
import model.carriages.PassengerCarriage;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * The CarriagePredicates class used to filter out
 * train carriages by special predicate.
 *
 * @author deniskovpaka
 */
public class CarriagePredicates {
    /**
     * Predicates ID's.
     */
    public static final int COMFORT_LEVEL_PREDICATE_ID = 1;
    public static final int PASSENGER_PREDICATE_ID = 2;

    /**
     * The ComfortLevelFilter class filtered out carriages by comfort level.
     */
    public static class ComfortLevelFilter implements Predicate<Carriage> {
        private ComfortLevel comfortLevel;

        public ComfortLevelFilter(ComfortLevel comfortLevel) {
            this.comfortLevel = comfortLevel;
        }

        @Override
        public boolean test(Carriage carriage) {
            return carriage.getComfortLevel() == comfortLevel;
        }
    }

    /**
     * The PassengersFilter class filtered out carriages by passenger quantity.
     */
    public static class PassengersFilter implements Predicate<PassengerCarriage> {
        private int quantityPassengers;

        public PassengersFilter(int quantityPassengers) {
            this.quantityPassengers = quantityPassengers;
        }

        @Override
        public boolean test(PassengerCarriage passengerCarriage) {
            return passengerCarriage.getNumberOfPassengers() == this.quantityPassengers;
        }
    }

    /**
     * The common algorithm for finding process.
     * @param carriages list of carriages.
     * @param predicate find by specific predicate.
     * @return filtered out carriages list by predicate.
     * Note: This method may throws ArrayStoreException if
     * there are different types of carriages.
     */
    public static List<Carriage> filterCarriages(List<Carriage> carriages,
                                                 Predicate predicate) {
        Carriage.areUniformCarriages(carriages);
        return carriages.stream().filter(carriage -> predicate.test(carriage)).collect(Collectors.toList());
    }

    /**
     * Use producePredicate method to get
     * object of type Predicate.
     * @param predicateType
     * @return specific comparator.
     */
    public static Predicate producePredicate(int predicateType) { // TODO
        Predicate predicate = null;
        if (predicateType == COMFORT_LEVEL_PREDICATE_ID) {
            // predicate = new ComfortLevelFilter();
        } else if (predicateType == PASSENGER_PREDICATE_ID) {
            // predicate = new PassengersFilter();
        }
        return predicate;
    }
}