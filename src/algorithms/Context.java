package algorithms;

import java.util.Comparator;

/**
 * Context class responsible for execution definite
 * algorithm (Calculation, Sorting, Finding) at runtime.
 *
 * @author deniskovpaka
 */
public class Context {
    private CarriagePredicates carriagePredicates;
    private Comparator comparator;

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
}
