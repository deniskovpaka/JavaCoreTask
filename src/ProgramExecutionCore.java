import algorithms.Calculation;
import algorithms.CarriageComparators;
import algorithms.Context;
import model.carriage.Carriage;
import model.carriage.PassengerCarriage;
import model.characteristics.ComfortLevel;
import model.characteristics.EngineType;
import model.train.PassengerTrain;
import model.train.Train;

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

        int passengers = 10;
        for (Carriage passengerCarriage : train.getCarriagesCopy()) {
            passengers += passengers;
            ((PassengerCarriage)passengerCarriage).setNumberOfPassengers(passengers);
        }
        System.out.println("Passengers=" + passengers);
        System.out.println("------BEFORE------");
        System.out.println(train.getCarriagesCopy());

        System.out.println("------AFTER------");
        Context context = new Context();
        context.setComparator(new CarriageComparators.SortPassengersByAscendingOrder());

        System.out.println(CarriageComparators.sortingCarriages(train.getCarriagesCopy(),
                context.getComparator()));
        System.out.println("------AFTER2------");
        System.out.println(Calculation.calculate(train.getCarriagesCopy(),
                new Calculation.PassengerCalculator()));
        System.out.println("------AFTER3------");
        System.out.println(Calculation.calculate(train.getCarriagesCopy(),
                new Calculation.BaggageCalculator()));
        // TODO This execution method will be completely reworked later
    }
}
