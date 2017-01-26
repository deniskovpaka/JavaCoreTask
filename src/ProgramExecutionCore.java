import model.ResourceManager;
import model.trains.Train;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProgramExecutionCore {
    final static Logger logger = Logger.getLogger(ProgramExecutionCore.class.getName());
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
                while (isProgramExecutes) {
                    /**
                     * Show interface menu.
                     */
                    showInterfaceMenu();
                    userInput = parseUserInput();
                    switch (userInput) {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            resourceManager.saveTrainToFile(createUniqueString()
                                    + fileNameWithTrainParameters, train);
                            break;
                        case 5:
                            isProgramExecutes = false;
                            break;
                    }
                }
            } catch (IOException e) {
                logger.log(Level.WARNING, "The create train from file "
                        + fileNameWithTrainParameters + " is FAILED!!!");
                e.printStackTrace();
            }


//            // TODO This execution method will be completely reworked later
//            Train train = new PassengerTrain();
//            train.setEngineType(EngineType.COAL);
//            train.addCarrage(new PassengerCarriage(ComfortLevel.COMFORT, 5.0));
//            train.addCarrage(new PassengerCarriage(ComfortLevel.LUXURY, 10.0));
//            train.addCarrage(new PassengerCarriage(ComfortLevel.LUXURY, 10.0));
//            train.addCarrage(new PassengerCarriage(ComfortLevel.STANDART, 20.0));
//            train.addCarrage(new PassengerCarriage(ComfortLevel.LUXURY, 30.0));
//            train.addCarrage(new PassengerCarriage(ComfortLevel.LUXURY, 30.0));
//
//            int passengers = 10;
//            for (Carriage passengerCarriage : train.getCarriagesCopy()) {
//                passengers += passengers;
//                ((PassengerCarriage) passengerCarriage).setNumberOfPassengers(passengers);
//            }
//        System.out.println("Passengers=" + passengers);
//        System.out.println("------BEFORE------");
//        System.out.println(train.getCarriagesCopy());
//
//        System.out.println("------AFTER------");
//        Context context = new Context();
//        context.setComparator(new CarriageComparators.SortPassengersByAscendingOrder());
//
//        System.out.println(CarriageComparators.sortingCarriages(train.getCarriagesCopy(),
//                context.getComparator()));
//        System.out.println("------AFTER2------");
//        Calculation calculation = new Calculation(new Calculation.PassengerCalculator());
//        System.out.println(Calculation.calculate(train.getCarriagesCopy(),
//                calculation.getFunction()));
//        System.out.println("------AFTER3------");
//        System.out.println(Calculation.calculate(train.getCarriagesCopy(),
//                new Calculation.BaggageCalculator()));
//        TxtDataReader reader = new TxtDataReader(DATA_READER_PATH + "PassengerTrain.txt");
//        TxtDataSaver saver = new TxtDataSaver(DATA_SAVER_PATH + "PassengerTrainOut.txt");
//        XmlDataReader reader = new XmlDataReader(DATA_READER_PATH + "PassengerTrain.xml");
            // XmlDataSaver saver = new XmlDataSaver(DATA_SAVER_PATH + "PassengerTrainOut.xml");
            //saver.saveDataToFile(train);
            //saver.saveDataToFile(train);
//        String[] str = reader.readInitialParameters();
//        for (String s : str)
//            System.out.println(s);
//            System.out.println(DATA_SAVER_PATH);
//            System.out.println(DATA_READER_PATH);
            // TODO This execution method will be completely reworked later
        }
    }

    private static void showInterfaceMenu() {
        System.out.println("What would you like to do with train:");
        System.out.println("1. Sort by specific parameter in carriages");
        System.out.println("2. Calculate by specific parameter in carriages");
        System.out.println("3. Find/Filtered Out by specific parameter in carriages");
        System.out.println("4. Save train to file");
        System.out.println("5. Exit from program");
    }

    private static int parseUserInput() {
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
        } while (input < 1 || input > 5);
        System.out.println("The client input is " + input);
        return input;
    }

    private static String createUniqueString() {
        Calendar cal = Calendar.getInstance();
        return new SimpleDateFormat("EEEE, dd/MM/yyyy/hh:mm:ss")
                                    .format(cal.getTime());
    }
}