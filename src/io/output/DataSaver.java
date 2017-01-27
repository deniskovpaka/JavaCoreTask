package io.output;

import model.trains.Train;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * The DataSaver class is responsible
 * for saving data into file.
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

    /**
     * This method is used to apply unique
     * naming file when train saving executes.
     * @return string in SimpleDateFormat.
     */
    static String createUniqueString() {
        Calendar cal = Calendar.getInstance();
        return new SimpleDateFormat("EEEE, dd/MM/yyyy/hh:mm:ss")
                .format(cal.getTime());
    }
}