package exercise_3;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class ReadXmlSAXParser {

    public static void main(String[] args) {

        String file = "C:\\Users\\LapTopUSA\\IdeaProjects\\ADV7\\src\\main\\java\\exercise_3\\catalog.xml";


        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {

                boolean city = false;
                boolean street = false;
                boolean building = false;

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes)  {

                    if (qName.equalsIgnoreCase("city")) {
                        String size =attributes.getValue("size");
                        System.out.printf("City size : %s%n", size);
                        city = true;
                    } else if (qName.equalsIgnoreCase("street")) {
                        street = true;
                    } else if (qName.equalsIgnoreCase("building")) {
                        building = true;
                    }
                }

                @Override
                public void characters(char[] ch, int start, int length)  {
                    if (city) {
                        String strCity = new String(ch, start, length);
                        if (strCity.trim().length() > 0) {
                            System.out.println("City : " + strCity.trim());
                        }

                        city = false;
                    } else if (street) {
                        String strStreet = new String(ch, start, length);
                        if (strStreet.trim().length() > 0) {
                            System.out.println("Street : " + strStreet.trim());
                        }

                        street = false;
                    } else if (building) {
                        System.out.println("Building : " + new String(ch, start, length));
                        building = false;
                    }
                }

            };

            saxParser.parse(file, handler);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }

    }
}
