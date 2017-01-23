package model.builders;

import model.train.Train;

public interface TrainBuilder {
    Train getTrain();
    void createTrain();
    void buildTrainParameters(String[] parameters);
}
