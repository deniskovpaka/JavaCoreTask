package io.output;

import model.trains.Train;

import java.io.IOException;

public interface DataSaver {
    // String DATA_SAVER_PATH = "src\\io\\output\\outputdata\\"; // TODO It would be wonderful to set this in Config.file
    void saveDataToFile(Train train) throws IOException;
}