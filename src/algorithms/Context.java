package algorithms;

import model.carriages.Carriage;
import model.trains.Train;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Context class responsible for execution definite
 * algorithm (Calculation, Comparator for sorting,
 * CarriagePredicates for finding) at runtime.
 *
 * @author deniskovpaka
 */
public class Context {
    /**
     * Predicates used for finding specific carriages.
     */
    private Predicate finderPredicate;

    /**
     * Comparators used for sorting specific carriages.
     */
    private Comparator sortingComparator;

    /**
     * Function used for calculation specific parameter
     * in carriages.
     */
    private Function calculationFunction;

    private Train train;
    final static Logger logger = Logger.getLogger(Train.class.getName());

    public void setFinderPredicate(Predicate finderPredicate, Train train) {
        this.finderPredicate = finderPredicate;
        this.train = train;
    }

    /**
     * The method executes filtering out train carriages by specific filter.
     * @return filtered out carriages.
     */
    public List<Carriage> executeFinding() {
        List<Carriage> filterOutCarriages = new LinkedList<>();
        if (checkObjectsForNull(finderPredicate)) {
            logger.log(Level.WARNING, "The carriagePredicates wasn't set correctly!!!");
            return filterOutCarriages;
        }
        filterOutCarriages = CarriagePredicates.filterCarriages(train.getCarriagesCopy(),
                finderPredicate);
        return filterOutCarriages;
    }

    public void setSortingComparator(Comparator comparator, Train train) {
        this.sortingComparator = comparator;
        this.train = train;
    }

    /**
     * The method executes sorting train carriages by specific filter.
     * @return sorted carriages.
     */
    public List<Carriage> executeSorting() {
        List<Carriage> sortedCarriages = new LinkedList<>();
        if (checkObjectsForNull(sortingComparator)) {
            logger.log(Level.WARNING, "The carriagePredicates wasn't set correctly!!!");
            return sortedCarriages;
        }
        sortedCarriages = CarriageComparators.sortingCarriages(train.getCarriagesCopy(),
                sortingComparator);
        return sortedCarriages;
    }

    public void setCalculationFunction(Function calculationFunction, Train train) {
        this.calculationFunction = calculationFunction;
        this.train = train;
    }

    /**
     * The method executes calculation of specific carriage parameter.
     * @return sum of specific carriage parameter.
     */
    public double executeCalculation() {
        double ret = 0.0;
        if (checkObjectsForNull(calculationFunction)) {
            logger.log(Level.WARNING, "The calculationFunction wasn't set correctly!!!");
            return ret;
        }
        ret = Calculation.calculate(train.getCarriagesCopy(),
                calculationFunction);
        return ret;
    }

    /**
     * This method is called before algorithm
     * execution process. Additional checking train
     * object for NULL due to every algorithm
     * uses it.
     * @return TRUE if either obj or train is NULL, FALSE otherwise.
     */
    private boolean checkObjectsForNull(Object obl) {
        return obl == null || train == null;
    }
}