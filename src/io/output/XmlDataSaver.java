package io.output;

import io.XmlReadWriteFactory;
import model.carriage.Carriage;
import model.train.Train;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XmlDataSaver implements DataSaver {
    private String outputFileName;

    public XmlDataSaver(String outputFileName) {
        this.outputFileName = outputFileName;
    }

    @Override
    public void saveDataToFile(Train train) throws IOException {
        String trainParameters = train.getTrainParameters();

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;
        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            throw new IOException("The DocumentBuilder creation FAILED!!!");
        }
        Document doc = db.newDocument();

        Element rootElement = doc.createElement(XmlReadWriteFactory.MODEL_TAG);
        doc.appendChild(rootElement);

        Element trainElement = doc.createElement(XmlReadWriteFactory.TRAIN_TAG);
        rootElement.appendChild(trainElement);

        Element trainParametersElement = doc.createElement(XmlReadWriteFactory.TRAINPARAMETERS_TAG);
        trainParametersElement.appendChild(doc.createTextNode(trainParameters));
        trainElement.appendChild(trainParametersElement);

        Element carriagesElement = doc.createElement(XmlReadWriteFactory.CARRIAGES_TAG);
        rootElement.appendChild(carriagesElement);

        Element quantityElement = doc.createElement(XmlReadWriteFactory.QUANTITY_TAG);
        quantityElement.appendChild(doc.createTextNode(String.valueOf(train.getCarriagesQuantity())));
        carriagesElement.appendChild(quantityElement);

        Element carriagesParametersElement = doc.createElement(XmlReadWriteFactory.CARRIAGEPARAMETERS_TAG);
        StringBuilder carriagesParametersAsString = new StringBuilder();
        for (Carriage carriage : train.getCarriagesCopy())
            carriagesParametersAsString.append(carriage.getCarriagesParameters());
        carriagesParametersElement.appendChild(doc.createTextNode(carriagesParametersAsString.toString()));
        carriagesElement.appendChild(carriagesParametersElement);

        try {
            Transformer tr = TransformerFactory.newInstance().newTransformer();
            tr.transform(new DOMSource(doc),
                    new StreamResult(new FileOutputStream(outputFileName)));
        } catch (TransformerException te) {
            throw new IOException("UsersXML: Error trying to instantiate Transformer!!!");
        }
    }
}