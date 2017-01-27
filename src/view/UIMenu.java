package view;

/**
 * The Menu interface represents
 * common menu items.
 *
 * @author deniskovpaka
 */
public interface UIMenu {
    /**
     * Input borders in main menu loop.
     */
    int LOWER_INPUT_MAIN_MENU = 1;
    int UPPER_INPUT_MAIN_MENU = 5;

    /**
     * Input borders in sort menu.
     */
    int LOWER_INPUT_SORT_MENU = 1;
    int UPPER_INPUT_SORT_MENU = 2;

    /**
     * Input borders in calculation menu.
     */
    int LOWER_INPUT_CALCULATION_MENU = 1;
    int UPPER_INPUT_CALCULATION_MENU = 2;

    /**
     * Input borders in finding menu.
     */
    int LOWER_INPUT_FIND_MENU = 1;
    int UPPER_INPUT_FIND_MENU = 2;

    /**
     * Shows common UI interface for clients.
     */
    void showUserInterfaceMenu();

    /**
     * Show sorting menu.
     */
    void showSortMenu();

    /**
     * Show calculation menu.
     */
    void showCalculationMenu();

    /**
     * Show finding menu.
     */
    void showFindMenu();

    /**
     * Show exit menu when program execution
     * is finished.
     */
    void showExitMenu();

    /**
     * Show data.
     */
    void showData(Object obj);
}