
@XmlObject
public class Address {
    @XmlTag(name = "Russia")
    private String city;

    @XmlTag(name = "Uliza")
    private String street;

    @XmlTag(name = "LeftSide")
    private String homeNumber;

    Address(String city, String street, String homeNumber) {
        this.city = city;
        this.street = street;
        this.homeNumber = homeNumber;
    }
}
