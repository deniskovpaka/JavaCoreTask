package io;

import io.input.DataReader;
import io.input.XmlDataReader;
import io.output.DataSaver;
import io.output.XmlDataSaver;

public class XmlReadWriteFactory implements ReadWriteFactory {
    @Override
    public DataReader createDataReader(String inputFileName) {
        return new XmlDataReader(inputFileName);
    }

    @Override
    public DataSaver createDataSaver(String outputFileName) {
        return new XmlDataSaver(outputFileName);
    }
}
