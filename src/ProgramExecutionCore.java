import model.carriages.Carriage;
import model.carriages.PassengerCarriage;
import model.characteristics.ComfortLevel;
import model.characteristics.EngineType;
import model.trains.PassengerTrain;
import model.trains.Train;

import static io.FilePaths.DATA_READER_PATH;
import static io.FilePaths.DATA_SAVER_PATH;

public class ProgramExecutionCore {
    public static void main(String[] args) {
        // TODO This execution method will be completely reworked later
        Train train = new PassengerTrain();
        train.setEngineType(EngineType.COAL);
        train.addCarrage(new PassengerCarriage(ComfortLevel.COMFORT, 5.0));
        train.addCarrage(new PassengerCarriage(ComfortLevel.LUXURY, 10.0));
        train.addCarrage(new PassengerCarriage(ComfortLevel.LUXURY, 10.0));
        train.addCarrage(new PassengerCarriage(ComfortLevel.STANDART, 20.0));
        train.addCarrage(new PassengerCarriage(ComfortLevel.LUXURY, 30.0));
        train.addCarrage(new PassengerCarriage(ComfortLevel.LUXURY, 30.0));

        int passengers = 10;
        for (Carriage passengerCarriage : train.getCarriagesCopy()) {
            passengers += passengers;
            ((PassengerCarriage)passengerCarriage).setNumberOfPassengers(passengers);
        }
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
        System.out.println(DATA_SAVER_PATH);
        System.out.println(DATA_READER_PATH);
        // TODO This execution method will be completely reworked later
    }
}