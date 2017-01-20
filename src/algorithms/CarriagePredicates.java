package algorithms;

import model.carriage.Carriage;
import model.characteristics.ComfortLevel;
import model.carriage.PassengerCarriage;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * The CarriagePredicates class used to filter out train carriages by special predicate.
 */
public class CarriagePredicates {
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
    public static List<Carriage> filterCarriages(List<Carriage> carriages,
                                                 Predicate predicate) {
        return carriages.stream().filter(carriage -> predicate.test(carriage)).collect(Collectors.toList());
    }
}