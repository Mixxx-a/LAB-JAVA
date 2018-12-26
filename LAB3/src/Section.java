import java.util.ArrayList;
import java.util.List;

public class Section {
    private String name;
    private List<Parameter> parameterList = new ArrayList<Parameter>();

    public Section(String name) {
        this.name = name;
    }

    public void add(Parameter p) {
        parameterList.add(p);
    }

    public String getName() {
        return this.name;
    }

    protected Parameter getParameter(String parameterName) throws MyParameterNotFoundException {
        Parameter necParameter = null;
        for (Parameter item : parameterList) {
            if (item.getName().equals(parameterName)) {
                necParameter = item;
            }
        }
        // если не нашлось
        if (necParameter == null) {
            throw new MyParameterNotFoundException(parameterName);
        }
        return necParameter;
    }
}
