package view;

import algorithms.CarriagePredicates;

/**
 * The TUIMenu class represents
 * common user interface menu items
 * via text in console.
 *
 * @author deniskovpaka
 */
public class TUIMenu implements UIMenu {
    /**
     * Shows common UI interface for clients via text in console.
     */
    @Override
    public void showUserInterfaceMenu() {
        System.out.println("What would you like to do with train:");
        System.out.println("1. Sort by specific parameter in carriages");
        System.out.println("2. Calculate by specific parameter in carriages");
        System.out.println("3. Find/Filtered Out by specific parameter in carriages");
        System.out.println("4. Save train to file");
        System.out.println("5. Exit from program");
    }

    /**
     * Show sorting menu via text in console.
     */
    @Override
    public void showSortMenu() {
        System.out.println("Would you like to sort by:");
        System.out.println("1. Passenger number");
        System.out.println("2. Comfort level");
    }

    /**
     * Show calculation menu via text in console.
     */
    @Override
    public void showCalculationMenu() {
        System.out.println("Would you like to calculate all:");
        System.out.println("1. Baggage in train");
        System.out.println("2. Passengers in train");
    }

    /**
     * Show finding menu via text in console.
     */
    @Override
    public void showFindMenu() {
        System.out.println("Would you like to find/filtered out by:");
        System.out.println("1. Carriage comfort level");
        System.out.println("2. Passengers in train");
    }

    /**
     * Show sub find menu.
     * It is quite close related with
     * showFindMenu function.
     */
    @Override
    public void showSubFindMenu(int subMenuIndex) {
        if (subMenuIndex == CarriagePredicates.COMFORT_LEVEL_PREDICATE_ID) {
            showSubFindMenuByComfortLevel();
        } else if (subMenuIndex == CarriagePredicates.PASSENGER_PREDICATE_ID) {
            showSubFindMenuByPassengerNumber();
        }
    }

    /**
     * Show comfort level menu via text in console.
     */
    @Override
    public void showSubFindMenuByComfortLevel() {
        System.out.println("Please, select the comfort level:");
        System.out.println("0. STANDARD");
        System.out.println("1. COMFORT");
        System.out.println("2. LUXURY");
        System.out.println("3. VIP");
    }

    /**
     * Show passenger finding menu via text in console.
     */
    @Override
    public void showSubFindMenuByPassengerNumber() {
        System.out.println("Please, input the passenger quantity.");
        System.out.println("Note: the value must be lower than"
                + SUB_FIND_MENU_BOUNDARY_VALUES[1]/**MAX PASSENGER QUANTITY*/);
    }

    /**
     * Show exit menu when program execution
     * is finished via text in console.
     */
    @Override
    public void showExitMenu() {
        System.out.println("Thank you for the attention!!!");
    }

    /**
     * Show data.
     */
    public void showData(Object obj) {
        System.out.println(obj.toString() + "\r\n");
    }
}