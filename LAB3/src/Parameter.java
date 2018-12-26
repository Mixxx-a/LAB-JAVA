import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class Parameter {
    private String name;
    private String value;

    public Parameter(String pName, String pValue) {
        this.name = pName;
        this.value = pValue;
    }

    public String getName() {
        return this.name;
    }

    protected int getIntValue() throws MyTypeConvertingException {
        // использование регулярного выражений
        Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(this.value);
        if (m.matches()) {
            int result = Integer.parseInt(value);
            return result;
        }
        else {
            throw new MyTypeConvertingException("int");
        }
    }

    protected float getFloatValue() throws MyTypeConvertingException {
        // использование регулярного выражений
        Pattern p = Pattern.compile("[0-9.]+");
        Matcher m = p.matcher(this.value);
        if (m.matches()) {
            float result = Float.parseFloat(value);
            return result;
        }
        else {
            throw new MyTypeConvertingException("int");
        }
    }

    protected String getValue() {
        return this.value;
    }
}
