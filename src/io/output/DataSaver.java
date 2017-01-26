package io.output;

import model.train.Train;

import java.io.IOException;

/**
 * The DataSaver class is responsible
 * for saving data to file.
 *
 * @author deniskovpaka
 */
public interface DataSaver {
    /**
     * Save train parameters into file.
     * @param train
     * @throws IOException in case of exception during
     * saving data into file.
     */
    void saveDataToFile(Train train) throws IOException;
}