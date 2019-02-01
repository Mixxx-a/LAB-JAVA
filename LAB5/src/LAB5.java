import org.dom4j.DocumentHelper;
import org.dom4j.*;
import javax.swing.text.Document;
import java.io.FileWriter;
import java.io.IOException;

public class LAB5 {
    public static void main(String[] args) {


        Address address = new Address("SPB", "Nevskiy", "192");
        Person person = new Person("Sergey", "RUS", 32, address);
        try {
            Element root = Serializer.serialize(person);
        }
        catch (Exception exc) {
            System.out.println(exc.getMessage());
       }

    }
}
