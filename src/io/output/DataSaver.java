package io.output;

import model.trains.Train;

import java.io.IOException;

/**
 * The DataSaver class is responsible
 * for saving data into file.
 *
 * @author deniskovpaka
 */
public abstract class DataSaver {
    private static long uniqueIDCounter = 0;

    /**
     * Save train parameters into file.
     * @param train
     * @throws IOException in case of exception during
     * saving data into file.
     */
    public abstract void saveDataToFile(Train train) throws IOException;

    /**
     * This method is used to apply unique
     * naming file when train saving executes.
     * @return string in SimpleDateFormat.
     */
    public static String createUniqueString() {
        return String.valueOf(uniqueIDCounter++);
    }
}