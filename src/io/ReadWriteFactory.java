package io;

import io.input.DataReader;
import io.output.DataSaver;

public interface ReadWriteFactory {
    DataReader createDateReader();
    DataSaver createDataSaver();
}
