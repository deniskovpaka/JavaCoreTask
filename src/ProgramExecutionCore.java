import algorithms.*;
import model.ResourceManager;
import model.trains.Train;
import view.TUIMenu;
import view.UIMenu;

import java.io.IOException;
import java.util.Scanner;

import static view.UIMenu.*;

public class ProgramExecutionCore {
    public static void main(String[] args) {
        /**
         * The args[0] argument should contain the name of
         * file with train parameters.
         */
        if (args.length > 0) {
            String fileNameWithTrainParameters = args[0];
            ResourceManager resourceManager = new ResourceManager();
            Train train = null;
            try {
                /**
                 * Create specific train from file.
                 */
                train = resourceManager.createTrainFromFile(fileNameWithTrainParameters);

                /**
                 * Execute program till a client won't stop it.
                 */
                boolean isProgramExecutes = true;
                int userInput;
                Context context = new Context();
                UIMenu menu = new TUIMenu();
                while (isProgramExecutes) {
                    /**
                     * Show interface menu.
                     */
                    menu.showUserInterfaceMenu();
                    userInput = parseUserInput(LOWER_INPUT_MAIN_MENU,
                                                UPPER_INPUT_MAIN_MENU);
                    switch (userInput) {
                        case 1:
                            menu.showSortMenu();
                            int sortInput = parseUserInput(LOWER_INPUT_SORT_MENU,
                                                            UPPER_INPUT_SORT_MENU);
                            context.setSortingComparator(AlgorithmProducer.produceComparator(sortInput),
                                                        train);
                            menu.showData(context.executeSorting());
                            break;
                        case 2:
                            menu.showCalculationMenu();
                            int calculateInput = parseUserInput(LOWER_INPUT_CALCULATION_MENU,
                                                                UPPER_INPUT_CALCULATION_MENU);
                            context.setCalculationFunction(AlgorithmProducer.produceCalculation(calculateInput),
                                                            train);
                            menu.showData(context.executeCalculation());
                            break;
                        case 3:
                            menu.showFindMenu(); // TODO Ploblem with additional data setting
//                            int findInput = parseUserInput(LOWER_INPUT_FIND_MENU,
//                                                            UPPER_INPUT_FIND_MENU);
//                            context.setFinderPredicate(AlgorithmProducer.producePredicate(findInput),
//                                                        train);
//                            context.executeFinding();
                            break;
                        case 4:
                            resourceManager.saveTrainToFile(fileNameWithTrainParameters, train);
                            break;
                        case 5:
                            isProgramExecutes = false;
                            menu.showExitMenu();
                            break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private static int parseUserInput(int lowerInput, int upperInput) {
        Scanner scanner = new Scanner(System.in);
        String userInput;
        int input;
        do {
            System.out.println("Please make your choice)))");
            userInput = scanner.nextLine();
            try {
                input = Integer.parseInt(userInput);
            } catch (NumberFormatException nfe) {
                System.out.println("Your input is INCORRECT!!!\r\n");
                input = 0;
            }
        } while (input < lowerInput || input > upperInput);
        System.out.println("The client input is " + input);
        return input;
    }
}