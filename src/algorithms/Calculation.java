package algorithms;

import model.carriages.Carriage;
import model.carriages.PassengerCarriage;

import java.util.List;
import java.util.function.Function;

/**
 * The Calculation class provides function set
 * in order to calculate specific parameter in
 * carriages.
 *
 * @author deniskovpaka
 */
public class Calculation {
    private Function function;
    public Calculation(Function function) {
        this.function = function;
    }
    public Function getFunction() {
        return function;
    }
    /**
     * The BaggageCalculator class calculates baggage capacity
     * in all carriages.
     */
    public static class BaggageCalculator implements Function<Carriage, Double> {
        @Override
        public Double apply(Carriage passengerCarriage) {
            return passengerCarriage.getBaggageCapacity();
        }
    }

    /**
     * The PassengerCalculator class calculated passengers
     * in all carriages.
     */
    public static class PassengerCalculator implements Function<PassengerCarriage, Double> {
        @Override
        public Double apply(PassengerCarriage passengerCarriage) {
            return (double) passengerCarriage.getNumberOfPassengers();
        }
    }

    /**
     * The common algorithm for calculation process.
     * @param carriages list of carriages.
     * @param function calculation class by specific parameters.
     * @return sum value of specific parameter.
     * Note: This method may throws ArrayStoreException if
     * there are different types of carriages.
     */
    public static double calculate(List<Carriage> carriages,
                                   Function function) {
        double sum = 0.0;
        Carriage.areUniformCarriages(carriages);

        for (Carriage carriage: carriages) {
            sum += (double)(function.apply(carriage)); // TODO need remove double cast
        }
        return sum;
    }
}