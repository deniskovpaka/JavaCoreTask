package io;

import io.input.DataReader;
import io.input.TxtDataReader;
import io.output.DataSaver;
import io.output.TxtDataSaver;

public class TxtReadWriteFactory implements ReadWriteFactory {
    @Override
    public DataReader createDateReader() {
        return new TxtDataReader();
    }

    @Override
    public DataSaver createDataSaver() {
        return new TxtDataSaver();
    }
}