package io;

public class FactoryProducer {
    /**
     * Use getFactory method to get
     * object of type ReadWriteFactory.
     * @param fileName
     * @return specific ReadWriteFactory.
     */
    public static ReadWriteFactory getFactory(String fileName) {
        if (fileName == null) {
            return null;
        }
        String extension = getFileNameExtension(fileName);
        if (extension.equalsIgnoreCase("TXT")){
            return new TxtReadWriteFactory();
        } else if (extension.equalsIgnoreCase("XML")) {
            return new XmlReadWriteFactory();
        }
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