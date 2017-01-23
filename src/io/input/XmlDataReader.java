package io.input;

import io.XmlReadWriteFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XmlDataReader implements DataReader {
    private Document doc;
    private List<String> initialParameters;
    final static Logger logger = Logger.getLogger(XmlDataReader.class.getName());

    /**
     * Constructor
     * @param inputFileName full name of an existing, readable file.
     */
    public XmlDataReader(String inputFileName) {
        File filePath = new File(inputFileName);
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

    private void readParametersByTagName(String tagName) {
        NodeList currentNode = doc.getElementsByTagName(tagName);
        String[] parameters = currentNode.item(0).getTextContent().split(" ");
        initialParameters.addAll(Arrays.asList(parameters));
    }

    @Override
    public String[] readInitialParameters() {
        readParametersByTagName(XmlReadWriteFactory.TRAINPARAMETERS_TAG);
        readParametersByTagName(XmlReadWriteFactory.QUANTITY_TAG);
        readParametersByTagName(XmlReadWriteFactory.CARRIAGEPARAMETERS_TAG);
        return initialParameters.toArray(new String[initialParameters.size()]);
    }
}