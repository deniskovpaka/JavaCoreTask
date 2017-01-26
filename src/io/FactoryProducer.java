package io;

import java.util.logging.Level;
import java.util.logging.Logger;

public class FactoryProducer {
    final static Logger logger = Logger.getLogger(FactoryProducer.class.getName());
    /**
     * Use createReadWriteFactory method to get
     * object of type ReadWriteFactory.
     * @param fileName
     * @return specific ReadWriteFactory.
     */
    public static ReadWriteFactory createReadWriteFactory(String fileName) {
        if (fileName == null) {
            logger.log(Level.WARNING, "The ReadWriteFactory creation FAILED!!!" +
                    " The fileName is NULL.");
            return null;
        }
        String extension = getFileNameExtension(fileName);
        if (extension.equalsIgnoreCase("TXT")){
            return new TxtReadWriteFactory();
        } else if (extension.equalsIgnoreCase("XML")) {
            return new XmlReadWriteFactory();
        }
        logger.log(Level.WARNING, "The ReadWriteFactory creation FAILED!!! " +
                "The fileName extension is UNKNOWN.");
        return null;
    }

    private static String getFileNameExtension(String fileName) {
        String extension = "";
        int i = fileName.lastIndexOf('.');
        if (i >= 0) {
            extension = fileName.substring(i + 1);
        }
        return extension;
    }
}