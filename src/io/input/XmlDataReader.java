package io.input;

import io.XmlReadWriteFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static io.FilePaths.DATA_READER_PATH;

/**
 * The XmlDataReader class is responsible
 * for reading data from XML file.
 *
 * @author deniskovpaka
 */
public class XmlDataReader implements DataReader {
    private Document doc;
    private List<String> initialParameters;
    final static Logger logger = Logger.getLogger(XmlDataReader.class.getName());

    /**
     * Constructor
     * @param inputFileName full name of an existing, readable file.
     */
    public XmlDataReader(String inputFileName) {
        File filePath = new File(DATA_READER_PATH + inputFileName);
        try {
            DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance()
                                        .newDocumentBuilder();
            doc = dBuilder.parse(filePath);
            doc.getDocumentElement().normalize();
            initialParameters = new LinkedList<>();
        } catch (Exception e) {
            e.printStackTrace();
            logger.log(Level.WARNING, "The XmlDataReader creation FAILED!!!");
        }
    }

    /**
     * Reads initial train parameters from XML file.
     * @return train parameters as string array.
     * @throws IOException in case of exception during
     * reading data from a file.
     */
    @Override
    public String[] readInitialParameters() throws IOException {
        readParametersByTagName(XmlReadWriteFactory.TRAINPARAMETERS_TAG);
        readParametersByTagName(XmlReadWriteFactory.QUANTITY_TAG);
        readParametersByTagName(XmlReadWriteFactory.CARRIAGEPARAMETERS_TAG);
        return initialParameters.toArray(new String[initialParameters.size()]);
    }

    /**
     * Read parameters from XML file by tag name.
     * @param tagName
     */
    private void readParametersByTagName(String tagName) {
        NodeList currentNode = doc.getElementsByTagName(tagName);
        String[] parameters = currentNode.item(0).getTextContent().split(" ");
        initialParameters.addAll(Arrays.asList(parameters));
    }
}