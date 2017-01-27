package view;

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
}
