package model.builders;

import model.train.Train;

public interface TrainBuilder {
    Train getTrain();
    void createTrain();

    /**
     * Builds train parameters by using String array.
     * Each string parameter is parsed for specific train attribute.
     * @param parameters train attributes
     * @throws NumberFormatException in case of invalid parameter.
     */
    void buildTrainParameters(String[] parameters) throws IllegalArgumentException;
}