package algorithms;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * The AlgorithmProducer class is responsible
 * for creation specific algorithm.
 *
 * @author deniskovpaka
 */
public class AlgorithmProducer {
    /**
     * Use producePredicate method to get
     * object of type Predicate.
     * @param predicateType
     * @return specific comparator.
     */
    public static Predicate producePredicate(int predicateType) { // TODO Ploblem with additional data setting
        Predicate predicate = null;
        if (predicateType == CarriagePredicates.COMFORT_LEVEL_PREDICATE_ID) {
            // predicate = new ComfortLevelFilter();
        } else if (predicateType == CarriagePredicates.PASSENGER_PREDICATE_ID) {
            // predicate = new PassengersFilter();
        }
        return predicate;
    }

    /**
     * Use produceCalculation method to get
     * object of type Function.
     * @param calculationType
     * @return specific function.
     */
    public static Function produceCalculation(int calculationType) {
        Function function = null;
        if (calculationType == Calculation.BAGGAGE_CALCULATION_ID) {
            function = new Calculation.BaggageCalculator();
        } else if (calculationType == Calculation.PASSENGER_CALCULATION_ID) {
            function = new Calculation.PassengerCalculator();
        }
        return function;
    }

    /**
     * Use produceComparator method to get
     * object of type Function.
     * @param comparatorType
     * @return specific comparator.
     */
    public static Comparator produceComparator(int comparatorType) {
        Comparator comparator = null;
        if (comparatorType == CarriageComparators.PASSENGER_COMPARATOR_ID) {
            comparator = new CarriageComparators.SortPassengersByAscendingOrder();
        } else if (comparatorType == CarriageComparators.COMFORT_LEVEL_COMPARATOR_ID) {
            comparator = new CarriageComparators.SortByComfortLevel();
        }
        return comparator;
    }
}
