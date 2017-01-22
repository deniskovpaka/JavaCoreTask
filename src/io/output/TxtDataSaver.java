package io.output;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import model.train.Train;

public class TxtDataSaver implements DataSaver {
    private final Path filePath;
    final static Charset ENCODING = StandardCharsets.UTF_8;

    /**
     * Constructor
     * @param outputFileName a file that will be created.
     */
    public TxtDataSaver(String outputFileName) {
        filePath = Paths.get(outputFileName);
    }

    @Override
    public void saveDataToFile(Train train) throws IOException {
        String trainParameters = train.toString();
        try (BufferedWriter writer = Files.newBufferedWriter(filePath, ENCODING)) {
            for (String line : trainParameters.split(",")) {
                writer.write(line);
                writer.newLine();
            }
        }
    }
}