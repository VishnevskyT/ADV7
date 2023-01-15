package exercise_4;


import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@XmlRootElement(name = "catalog")
public class Catalog {

    @XmlElementRef(name = "city")
        List<City> cities = new ArrayList<>();

    public void add (City city) {
        cities.add(city);
    }

    @Override
    public String toString() {
        return Arrays.deepToString(cities.toArray());
    }
}
