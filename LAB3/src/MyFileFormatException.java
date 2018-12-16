public class MyFileFormatException extends Exception {
    private final static String DEFAULT_MESSAGE = "Not .ini file format";

    public MyFileFormatException() {
        super(DEFAULT_MESSAGE);
    }
}
