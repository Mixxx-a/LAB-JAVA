import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class Parameter {
    private String parameterName;
    private String parameterValue;

    public Parameter(String pName, String pValue) {
        this.parameterName = pName;
        this.parameterValue = pValue;
    }

    public String getName() {
        return this.parameterName;
    }

    protected int getIntValue() throws MyTypeConvertingException {
        // использование регулярного выражений
        Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(this.parameterValue);
        if (m.matches()) {
            int result = Integer.parseInt(parameterValue);
            return result;
        }
        else {
            throw new MyTypeConvertingException("int");
        }
    }

    protected float getFloatValue() throws MyTypeConvertingException {
        // использование регулярного выражений
        Pattern p = Pattern.compile("[0-9.]+");
        Matcher m = p.matcher(this.parameterValue);
        if (m.matches()) {
            float result = Float.parseFloat(parameterValue);
            return result;
        }
        else {
            throw new MyTypeConvertingException("int");
        }
    }

    protected String getValue() {
        return this.parameterValue;
    }
}
