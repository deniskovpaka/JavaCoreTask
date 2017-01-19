package algorithms;

import model.Carriage;
import model.ComfortLevel;
import model.PassengerCarriage;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * The CarriagePredicates class used to filter out train carriages by special predicate.
 */
public class CarriagePredicates {
    public static Predicate<PassengerCarriage> findByQuantityPassengers(int quantityPassengers) {
        return pred -> pred.getNumberOfPassengers() == quantityPassengers;
    }

    public static Predicate<Carriage> findByComfortLevel(ComfortLevel comfortLevel) {
        return pred -> pred.getComfortLevel() == comfortLevel;
    }

    public static List<Carriage> filterCarriages(List<Carriage> carriages,
                                                 Predicate<Carriage> predicate) {
        return carriages.stream().filter(predicate).collect(Collectors.toList());
    }
}