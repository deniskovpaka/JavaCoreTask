package algorithms;

import model.carriages.Carriage;
import model.characteristics.ComfortLevel;
import model.carriages.PassengerCarriage;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * The CarriageComparators class provides comparator
 * set in order to sort carriages by
 * specific parameter.
 *
 * @author deniskovpaka
 */
public class CarriageComparators {
    /**
     * Comparators ID's.
     */
    public static final int PASSENGER_COMPARATOR_ID = 1;
    public static final int COMFORT_LEVEL_COMPARATOR_ID = 2;

    /**
     * Sort carriages by passenger number.
     */
    public static class SortPassengersByAscendingOrder implements Comparator<PassengerCarriage> {
        @Override
        public int compare(PassengerCarriage o1, PassengerCarriage o2) {
            return o1.getNumberOfPassengers() - o2.getNumberOfPassengers();
        }
    }

    /**
     * Sort carriages by comfort level.
     */
    public static class SortByComfortLevel implements Comparator<Carriage> {
        @Override
        public int compare(Carriage o1, Carriage o2) {
            ComfortLevel comfortLevel1 = o1.getComfortLevel();
            ComfortLevel comfortLevel2 = o2.getComfortLevel();
            return comfortLevel1.compareTo(comfortLevel2);
        }
    }

    /**
     * The common algorithm for sorting process.
     * @param carriages list of carriages.
     * @param comparator sorter by specific parameters.
     * @return sorted carriages list by comparator.
     * Note: This method may throws ArrayStoreException if
     * there are different types of carriages.
     */
    public static List<Carriage> sortingCarriages(List<Carriage> carriages,
                                                  Comparator comparator) {
        Carriage.areUniformCarriages(carriages);
        Collections.sort(carriages, comparator);
        return carriages;
    }
}