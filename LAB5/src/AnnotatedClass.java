
public class AnnotatedClass {
    @MyAnnotation("megafield")
    private String annotatedFieldl;

    @MyAnnotation(value = "megamethod", description = "Method for say Hello")
    public String annotatedMethod() {
        return "Hello!";
    }
}
