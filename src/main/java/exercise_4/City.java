package exercise_4;

import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "city")
public class City {
    @XmlAnyAttribute
    private String size;

    @XmlElement(name = "city1")
    private String name;
    @XmlElement
    private String street;
    @XmlElement
    private String building;

    public City() {
    }

    public City(String size, String name, String street, String building) {
        this.size = size;
        this.name = name;
        this.street = street;
        this.building = building;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "City{" +
                "size='" + size + '\'' +
                ", name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", building='" + building + '\'' +
                '}';
    }
}
