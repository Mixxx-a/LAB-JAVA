public class MySectionNotFoundException extends Exception{
    private final static String DEFAULT_MESSAGE = "There is no such section in this file";

    public MySectionNotFoundException() {
        super(DEFAULT_MESSAGE);
    }
}
