package algorithms;

import model.carriage.Carriage;
import model.characteristics.ComfortLevel;
import model.carriage.PassengerCarriage;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CarriageComparators {

    public static class SortPassengersByAscendingOrder implements Comparator<PassengerCarriage> {
        @Override
        public int compare(PassengerCarriage o1, PassengerCarriage o2) {
            return o1.getNumberOfPassengers() - o2.getNumberOfPassengers();
        }
    }

    public static class SortByComfortLevel implements Comparator<Carriage> {
        @Override
        public int compare(Carriage o1, Carriage o2) {
            ComfortLevel comfortLevel1 = o1.getComfortLevel();
            ComfortLevel comfortLevel2 = o2.getComfortLevel();
            return comfortLevel1.compareTo(comfortLevel2);
        }
    }

    public static List<Carriage> sortingCarriages(List<Carriage> carriages,
                                                  Comparator comparator) {
        Collections.sort(carriages, comparator);
        return carriages;
    }
}