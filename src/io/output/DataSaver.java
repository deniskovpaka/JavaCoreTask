package io.output;

import model.train.Train;

public interface DataSaver {
    void saveDataToFile(Train train);
}
