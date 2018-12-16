public class MyTypeConvertingException extends Exception{
    private final static String DEFAULT_MESSAGE = "Failed to convert value to ";

    public MyTypeConvertingException(String type) {
        super(DEFAULT_MESSAGE + type);
    }
}
