package io.output;

import model.train.Train;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.IOException;

public class XmlDataSaver implements DataSaver {
    private String outputFileName;

    public XmlDataSaver(String outputFileName) {
        this.outputFileName = outputFileName;
    }

    @Override
    public void saveDataToFile(Train train) {
        String trainParameters = "22 33 44 ";//train.toString();
        //String carriagesParameters = train.getCarriagesParameters(); // TODO add getCarria .. method
        Document doc;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.newDocument();

            Element rootElement = doc.createElement("model");
            doc.appendChild(rootElement);

            Element trainElement = doc.createElement("train");
            rootElement.appendChild(trainElement);

            Element trainParametersElement = doc.createElement("trainparameters");
            trainParametersElement.appendChild(doc.createTextNode(trainParameters));
            trainElement.appendChild(trainParametersElement);

            Element carriagesElement = doc.createElement("carriages");
            rootElement.appendChild(carriagesElement);

            Element quantityElement = doc.createElement("quantity");
            quantityElement.appendChild(doc.createTextNode("2"));
            carriagesElement.appendChild(quantityElement);

            Element carriagesParametersElement = doc.createElement("carriagesparameters");
            carriagesParametersElement.appendChild(doc.createTextNode("carriagesparameters 22 33 44"));
            carriagesElement.appendChild(carriagesParametersElement);

            try {
                Transformer tr = TransformerFactory.newInstance().newTransformer();
                tr.transform(new DOMSource(doc),
                        new StreamResult(new FileOutputStream(outputFileName)));
            } catch (TransformerException te) {
                System.out.println(te.getMessage());
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }
        } catch (ParserConfigurationException pce) {
            System.out.println("UsersXML: Error trying to instantiate DocumentBuilder " + pce);
        }
    }
}