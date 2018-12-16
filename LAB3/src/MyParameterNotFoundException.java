public class MyParameterNotFoundException extends Exception{
    private String parameterName;

    public MyParameterNotFoundException(String parameterName) {
        this.parameterName = parameterName;
    }

    public String get() {
        return parameterName;
    }
}
