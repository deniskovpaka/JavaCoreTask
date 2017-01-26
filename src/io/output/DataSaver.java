package io.output;

import model.train.Train;

import java.io.IOException;

public interface DataSaver {
    void saveDataToFile(Train train) throws IOException;
}