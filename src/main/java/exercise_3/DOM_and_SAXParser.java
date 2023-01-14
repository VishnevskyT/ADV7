package exercise_3;

/**
 * Завдання 3
 * Створіть клас, використовуючи SAXParser, де опишіть ієрархію XML файлу. Необхідно,
 * щоб проект створював XML-файл і будував дерево (місто, назва вулиці, будинок).
 * У місті використовуйте аттрибут (наприклад, <city size=”big>Kiev</city>).
 * @autor Vishnevsky
 * @since Jan, 2023
 * @version 1.0 beta
 */

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
import java.io.OutputStream;

public class DOM_and_SAXParser {
    public static void main(String[] args) throws ParserConfigurationException {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();

        Document document = builder.newDocument();

        Element root = document.createElement("catalog");
        document.setXmlVersion("1.1");
        document.appendChild(root);

        Element city = document.createElement("city");
        root.appendChild(city);
        city.setTextContent("Kyiv");
        city.setAttribute("size", "big");

        Element street = document.createElement("street");
        city.appendChild(street);
        street.setTextContent("Honoré de Balzac");

        Element building = document.createElement("building");
        street.appendChild(building);
        building.setTextContent("10");

        Element city2 = document.createElement("city");
        root.appendChild(city2);
        city2.setAttribute("size", "big");
        city2.setTextContent("Kharkiv");

        Element street2 = document.createElement("street");
        city2.appendChild(street2);
        street2.setTextContent("Azovstalska");

        Element building2 = document.createElement("building");
        street2.appendChild(building2);
        building2.setTextContent("13");

        try (FileOutputStream outputStream = new FileOutputStream("C:\\Users\\LapTopUSA\\IdeaProjects\\ADV7\\src\\main\\java\\exercise_3\\catalog.xml")) {
        writeXml(document, outputStream);
        writeXml(document,System.out);

        } catch (IOException | TransformerException e) {
            throw new RuntimeException(e);
        }

    }

    public static void writeXml (Document document, OutputStream outStream) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(outStream);

        //pretty print
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        transformer.transform(source, result);
    }

}
