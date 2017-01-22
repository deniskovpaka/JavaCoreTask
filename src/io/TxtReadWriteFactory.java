package io;

import io.input.DataReader;
import io.input.TxtDataReader;
import io.output.DataSaver;
import io.output.TxtDataSaver;

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