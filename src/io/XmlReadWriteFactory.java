package io;

import io.input.DataReader;
import io.input.XmlDataReader;
import io.output.DataSaver;
import io.output.XmlDataSaver;

/**
 * The XmlReadWriteFactory class is responsible
 * for creation XML reader and saver.
 *
 * @author deniskovpaka
 */
public class XmlReadWriteFactory implements ReadWriteFactory {
    /**
     * Read/Write tags
     */
    public static String CARRIAGEPARAMETERS_TAG     = "carriageparameters";
    public static String CARRIAGES_TAG              = "carriages";
    public static String MODEL_TAG                  = "model";
    public static String QUANTITY_TAG               = "quantity";
    public static String TRAIN_TAG                  = "train";
    public static String TRAINPARAMETERS_TAG        = "trainparameters";

    @Override
    public DataReader createDataReader(String inputFileName) {
        return new XmlDataReader(inputFileName);
    }

    @Override
    public DataSaver createDataSaver(String outputFileName) {
        return new XmlDataSaver(outputFileName);
    }
}