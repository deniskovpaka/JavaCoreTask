package io;

import io.input.DataReader;
import io.output.DataSaver;

/**
 * The ReadWriteFactory interface is responsible
 * for creation specific reader and saver.
 *
 * @author deniskovpaka
 */
public interface ReadWriteFactory {
    DataReader createDataReader(String inputFileName);
    DataSaver createDataSaver(String outputFileName);
}