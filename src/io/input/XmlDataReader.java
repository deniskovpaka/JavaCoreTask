package io.input;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class XmlDataReader implements DataReader {
    private Document doc;
    private List<String> initialParameters;

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
            e.printStackTrace(); // TODO Logggg addddd
        }
    }

    private void readParametersByTagName(String tagName) {
        NodeList currentNode = doc.getElementsByTagName(tagName);
        String[] parameters = currentNode.item(0).getTextContent().split(" ");
        initialParameters.addAll(Arrays.asList(parameters));
    }

    @Override
    public String[] readInitialParameters() {
        readParametersByTagName("trainparameters"); // TODO Move tags to separete file
        readParametersByTagName("quantity");
        readParametersByTagName("carriagesparameters");
        return initialParameters.toArray(new String[initialParameters.size()]);
    }
}