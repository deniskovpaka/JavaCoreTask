package model;

import io.FactoryProducer;
import io.ReadWriteFactory;
import io.input.DataReader;
import io.output.DataSaver;
import model.builders.BuilderFactory;
import model.builders.TrainBuilder;
import model.train.Train;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ResourceManager {
    final static Logger logger = Logger.getLogger(ResourceManager.class.getName());

    public Train createTrainFromFile(String fileName) {
        ReadWriteFactory readWriteFactory = FactoryProducer.
                                            createReadWriteFactory(fileName); // TODO try catch???
        DataReader dataReader = readWriteFactory.createDataReader(fileName);
        Train train = null;
        try {
            String[] trainParameters = dataReader.readInitialParameters();
            /**
             * First parameter should always describe the specific train type.
             * For more detail please see *DataInputFormat.txt* file.
             */
            String trainName = trainParameters[0];
            TrainBuilder trainBuilder = BuilderFactory.createTrainBuilder(trainName);
            train = trainBuilder.buildTrain(trainParameters);
        } catch (IOException e) {
            logger.log(Level.WARNING, "Train creation from file is FAILED!!!");
            e.printStackTrace();
        }
        return train;
    }

    public void saveTrainToFile(String newFileName, Train train) {
        ReadWriteFactory readWriteFactory = FactoryProducer.
                                            createReadWriteFactory(newFileName);
        DataSaver dataSaver = readWriteFactory.createDataSaver(newFileName);
        try {
            dataSaver.saveDataToFile(train);
        } catch (IOException e) {
            logger.log(Level.WARNING, "Train saving into file is FAILED!!!");
            e.printStackTrace();
        }
    }
}