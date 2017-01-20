package algorithms;

import model.carriage.Carriage;
import model.carriage.PassengerCarriage;

import java.util.List;
import java.util.function.Function;

public class Calculation {
    public static class BaggageCalculator implements Function<Carriage, Double> {
        @Override
        public Double apply(Carriage passengerCarriage) {
            return passengerCarriage.getBaggageCapacity();
        }
    }

    public static class PassengerCalculator implements Function<PassengerCarriage, Double> {
        @Override
        public Double apply(PassengerCarriage passengerCarriage) {
            return (double) passengerCarriage.getNumberOfPassengers();
        }
    }

    public static double calculate(List<Carriage> carriages,
                                   Function function) {
        double sum = 0.0;
        for (Carriage carriage: carriages) {
            sum += (double)(function.apply(carriage)); // TODO need remove double cast
        }
        return sum;
    }
}
