package io;

/**
 * The FilePaths class is responsible
 * for storing and reading file paths.
 *
 * @author deniskovpaka
 */
public class FilePaths {
    public static final String DATA_READER_PATH;
    public static final String DATA_SAVER_PATH;

    /**
     * Simple detection Windows or Unix operation
     * system.
     */
    static {
        String OS = System.getProperty("os.name").toLowerCase();
        if (OS.indexOf("win") >= 0) {
            DATA_READER_PATH = "src\\io\\input\\inputdata\\";
            DATA_SAVER_PATH = "src\\io\\output\\outputdata\\";
        } else {
            DATA_READER_PATH = "src/io/input/inputdata/";
            DATA_SAVER_PATH = "src/io/output/outputdata/";
        }
    }
}