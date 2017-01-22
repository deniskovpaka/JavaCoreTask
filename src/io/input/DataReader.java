package io.input;

import java.io.IOException;

public interface DataReader {
    String DATA_READER_PATH = "src\\io\\input\\inputdata\\"; // TODO It would be wonderful to set this in Config.file
    String[] readInitialParameters() throws IOException;
}
