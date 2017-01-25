package algorithms;

import java.util.Comparator;

/**
 * Context class responsible for execution definite
 * algorithm (Calculation, Comparator for sorting,
 * CarriagePredicates for finding) at runtime.
 *
 * @author deniskovpaka
 */
public class Context {
    private CarriagePredicates carriagePredicates;
    private Comparator comparator;
    private Calculation calculation;

    public CarriagePredicates getCarriagePredicates() {
        return carriagePredicates;
    }

    public void setCarriagePredicates(CarriagePredicates carriagePredicates) {
        this.carriagePredicates = carriagePredicates;
    }

    public Comparator getComparator() {
        return comparator;
    }

    public void setComparator(Comparator comparator) {
        this.comparator = comparator;
    }

    public Calculation getCalculation() {
        return calculation;
    }

    public void setCalculation(Calculation calculation) {
        this.calculation = calculation;
    }
}