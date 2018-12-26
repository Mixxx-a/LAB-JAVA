

@XmlObject
public class Car {
    @XmlAttribute
    private final String country;

    @XmlTag
    private final String mark;

    @XmlTag
    private final String model;

    @XmlAttribute
    private final String gearType;

    @XmlTag
    private final int gearNumber;
}
