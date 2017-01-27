package io.output;

import io.XmlReadWriteFactory;
import model.carriages.Carriage;
import model.trains.Train;
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

import static io.FilePaths.DATA_SAVER_PATH;

/**
 * The XmlDataSaver class is responsible
 * for saving data to file in XML format.
 * XML format is described in *DataInputFormat.txt*
 * file.
 *
 * @author deniskovpaka
 */
public class XmlDataSaver extends DataSaver {
    private String outputFileName;

    /**
     * XmlDataSaver constructor.
     * @param outputFileName a file that will be created.
     * Note: The outputFileName will be also contains
     * the SimpleDataFormat.
     */
    public XmlDataSaver(String outputFileName) {
        this.outputFileName = DATA_SAVER_PATH
                            + DataSaver.createUniqueString()
                            + "_"
                            + outputFileName;
    }

    /**
     * Save train parameters into XML file.
     * @param train
     * @throws IOException in case of exception during
     * saving data into file.
     */
    @Override
    public void saveDataToFile(Train train) throws IOException {
        String[] parameters = train.getTrainParameters().split(",");
        int trainParametersQuantity = train.getTrainParameterQuantity();
        StringBuilder trainParameters = new StringBuilder();
        for (int i = 0; i < trainParametersQuantity; i++) {
            trainParameters.append(parameters[i]);
        }

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
        trainParametersElement.appendChild(doc.createTextNode(trainParameters.toString().trim()));
        trainElement.appendChild(trainParametersElement);

        Element carriagesElement = doc.createElement(XmlReadWriteFactory.CARRIAGES_TAG);
        rootElement.appendChild(carriagesElement);

        Element quantityElement = doc.createElement(XmlReadWriteFactory.QUANTITY_TAG);
        quantityElement.appendChild(doc.createTextNode(String.valueOf(train.getCarriagesQuantity())));
        carriagesElement.appendChild(quantityElement);

        Element carriagesParametersElement = doc.createElement(XmlReadWriteFactory.CARRIAGEPARAMETERS_TAG);
        trainParametersQuantity++; /**skip carriages quantity*/
        trainParameters = new StringBuilder();
        for (int i = trainParametersQuantity; i < parameters.length; i++) {
            trainParameters.append(parameters[i]);
        }
        carriagesParametersElement.appendChild(doc.createTextNode(trainParameters.toString().trim()));
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