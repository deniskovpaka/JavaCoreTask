package io.input;

import java.io.IOException;

/**
 * The DataReader class is responsible
 * for reading data from file.
 *
 * @author deniskovpaka
 */
public interface DataReader {
    /**
     * Reads initial train parameters from file.
     * @return train parameters as string array.
     * @throws IOException in case of exception during
     * reading data from a file.
     */
    String[] readInitialParameters() throws IOException;
}