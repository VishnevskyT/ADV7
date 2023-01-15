package exercise_4;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Завдання 4
 * Використовуючи JAXB, виконати завдання №3.
 * @author Vishnevsky
 * @since Jan 2023
 * @version 1.0 beta
 */

public class JAXBtesting {

    public static void main(String[] args) throws JAXBException {
        Catalog catalog = new Catalog();
        catalog.add(new City("big", "Kyiv","Honoré de Balzac","10"));
        catalog.add(new City("big", "Kharkiv","Azovstalska","13"));

        File file = new File("C:\\Users\\LapTopUSA\\IdeaProjects\\ADV7\\src\\main\\java\\exercise_4\\output.xml");

            JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(catalog, file);
            marshaller.marshal(catalog,System.out);

        System.out.println("=====================================================");

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        catalog = (Catalog) unmarshaller.unmarshal(file);
        System.out.println(catalog);


    }

}
