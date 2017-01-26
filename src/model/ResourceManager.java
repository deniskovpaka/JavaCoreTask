package model;

import io.FactoryProducer;
import io.ReadWriteFactory;
import io.input.DataReader;
import io.output.DataSaver;
import model.builders.BuilderFactory;
import model.builders.TrainBuilder;
import model.train.Train;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * The ResourceManager manage process of creation
 * and saving train instance from/into file.
 */
public class ResourceManager {
    /**
     * Use createTrainFromFile method to build a new train
     * from file. This method makes train creation process easier.
     * @param fileName path to file that contains train data.
     * @return new train instance if all data were parsed correctly.
     * @throws IOException during parsing file.
     */
    public Train createTrainFromFile(String fileName) throws IOException {
        ReadWriteFactory readWriteFactory = FactoryProducer.
                                        createReadWriteFactory(fileName);
        checkObjectForNull(readWriteFactory, "The fileName extension is UNKNOWN.");

        DataReader dataReader = readWriteFactory.createDataReader(fileName);
        checkObjectForNull(dataReader, "DataReader creation FAILED.");

        String[] trainParameters = dataReader.readInitialParameters();
        /**
         * First parameter should always describe the specific train type.
         * For more detail please see *DataInputFormat.txt* file.
         */
        String trainName = trainParameters[0];
        TrainBuilder trainBuilder = BuilderFactory.createTrainBuilder(trainName);
        checkObjectForNull(trainBuilder, "The builderName is UNKNOWN.");
        Train train = trainBuilder.buildTrain(trainParameters);
        return train;
    }

    /**
     * Use saveTrainToFile method to save a train into file.
     * It may be saved in {XML and TXT} formats.
     * @param newFileName fileName with {XML or TXT} extension.
     * @param train
     * @throws IOException during saving train into file.
     */
    public void saveTrainToFile(String newFileName, Train train) throws IOException {
        ReadWriteFactory readWriteFactory = FactoryProducer.
                                        createReadWriteFactory(newFileName);
        checkObjectForNull(readWriteFactory, "The fileName extension is UNKNOWN.");

        DataSaver dataSaver = readWriteFactory.createDataSaver(newFileName);
        dataSaver.saveDataToFile(train);
    }

    private void checkObjectForNull(Object object, String exceptionMessage)
            throws FileNotFoundException {
        if (object == null) throw new FileNotFoundException(exceptionMessage);
    }
}