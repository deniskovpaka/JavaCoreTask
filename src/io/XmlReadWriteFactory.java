package io;

import io.input.DataReader;
import io.input.XmlDataReader;
import io.output.DataSaver;
import io.output.XmlDataSaver;

public class XmlReadWriteFactory implements ReadWriteFactory {
    @Override
    public DataReader createDateReader() {
        return new XmlDataReader();
    }

    @Override
    public DataSaver createDataSaver() {
        return new XmlDataSaver();
    }
}
