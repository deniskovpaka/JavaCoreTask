package io.input;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static io.FilePaths.DATA_READER_PATH;

/**
 * The TxtDataReader class is responsible
 * for reading data from TXT file.
 *
 * @author deniskovpaka
 */
public class TxtDataReader implements DataReader {
    private final Path filePath;
    private final static Charset ENCODING = StandardCharsets.UTF_8;
    private List<String> initialParameters;

    /**
     * Constructor
     * @param inputFileName full name of an existing, readable file.
     */
    public TxtDataReader(String inputFileName) {
        filePath = Paths.get(DATA_READER_PATH + inputFileName);
        initialParameters = new LinkedList<>();
    }

    /**
     * Reads initial train parameters from TXT file.
     * @return train parameters as string array.
     * @throws IOException in case of exception during
     * reading data from a file.
     */
    @Override
    public String[] readInitialParameters() throws IOException {
        try (Scanner scanner = new Scanner(filePath, ENCODING.name())) {
            while (scanner.hasNextLine()) {
                String[] parameters = scanner.nextLine().split(",");
                initialParameters.addAll(Arrays.asList(parameters));
            }
        }
        return initialParameters.toArray(new String[initialParameters.size()]);
    }
}