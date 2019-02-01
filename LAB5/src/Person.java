
@XmlObject
public class Person {

    @XmlTag(name = "fullname")
    private final String name;

    @XmlAttribute(tag = "fullname")
    private final String lang;

    @XmlTag(name = "Address")
    private Address address;

    private final int age;

    public Person(String name, String lang, int age, Address address) {
        this.name = name;
        this.lang = lang;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    @XmlTag
    public int getAge() {
        return age;
    }
}
