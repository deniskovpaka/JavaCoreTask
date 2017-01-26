package io;

import io.input.DataReader;
import io.input.TxtDataReader;
import io.output.DataSaver;
import io.output.TxtDataSaver;

/**
 * The TxtReadWriteFactory class is responsible
 * for creation TXT reader and saver.
 *
 * @author deniskovpaka
 */
public class TxtReadWriteFactory implements ReadWriteFactory {
    @Override
    public DataReader createDataReader(String inputFileName) {
        return new TxtDataReader(inputFileName);
    }

    @Override
    public DataSaver createDataSaver(String outputFileName) {
        return new TxtDataSaver(outputFileName);
    }
}