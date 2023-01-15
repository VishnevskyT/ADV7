package exercise_4;

import javax.xml.bind.annotation.*;

@XmlType(propOrder = {"name","street", "building"})
@XmlRootElement(name = "city")
public class City {

    private String size;
    private String name;
    private String street;
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
    @XmlAttribute
    public void setSize(String size) {
        this.size = size;
    }

    public String getStreet() {
        return street;
    }
    @XmlElement
    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }
    @XmlElement
    public void setBuilding(String building) {
        this.building = building;
    }

    public String getName() {
        return name;
    }
    @XmlElement(name = "city")
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
