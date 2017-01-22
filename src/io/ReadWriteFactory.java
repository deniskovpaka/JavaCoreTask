package io;

import io.input.DataReader;
import io.output.DataSaver;

public interface ReadWriteFactory {
    DataReader createDataReader(String inputFileName);
    DataSaver createDataSaver(String outputFileName);
}
