import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IniFile {
    private List<Section> sections = new ArrayList<Section>();

    public IniFile(String fileName)
    {
        try {
            // проверка на формат файла
            String fileFormat = fileName.substring(fileName.indexOf('.') + 1);
            if (!fileFormat.equals("ini"))
            {
                throw new MyFileFormatException();
            }

            // использую Scanner для парсинга файла
            Scanner scanner = new Scanner(new FileReader(fileName));
            String line = scanner.nextLine();
            while (!line.equals("-1exitcode") ) // проход до конца файлаа
            {
                if (!line.equals("")) {
                    // проверка на присутствие комментария вне секции
                    if (line.charAt(0) == ';') {
                        line = scanner.nextLine();
                        line = scanner.next();
                    }
                    // иначе происходит парсинг секции
                    else
                    {
                        String newSectionName = line.substring(1, line.length() - 1);
                        // в line возвращается имя новой секции
                        line = parseSection(scanner, newSectionName);
                    }
                }
            }
            scanner.close();
        }
        // исключение на ненахождение файла
        catch (FileNotFoundException exc1) {
            System.out.println("File not found: " + exc1.getMessage());
        }

        // исключение неправильного формата файла
        catch (MyFileFormatException exc2) {
            System.out.println("File's format is not .ini: " + exc2.getMessage() );
        }

        // оповещение о конце парсинга
        finally {
            System.out.println("Finished parsing");
        }
    }


    private String parseSection(Scanner scan, String sectionName)
    {
        Section section = new Section(sectionName);

        // currnext = следующее "слово", то есть последовательность символов до пробела
        String currnext = scan.next();

        // секции между собой отделяются пустыми строками (видно из примера)
        // пока не встретилась пустая строка или начало комментария
        while (!(currnext.equals("")) && !(currnext.charAt(0) == ';') && !(currnext.charAt(0) == '[')) {
            // обработка параметра
            String parameterName = currnext;
            currnext = scan.next(); // символ "="
            currnext = scan.next();
            String parameterValue = currnext;
            Parameter parameter = new Parameter(parameterName, parameterValue);
            section.add(parameter);

            // если если нет следующего слова, то возвращает код выхода
            if (!scan.hasNext()) {
                sections.add(section);
                return "-1exitcode";
            }

            currnext = scan.next();

            // если в строке еще есть комментарии
            if (currnext.equals(";")) {
                currnext = scan.nextLine();
                currnext = scan.next();
            }
        }
        sections.add(section);
        return currnext;
    }

    public int getIntValue(String sectionName, String parameterName) {
        int result = -2147483648; // начальная инициализация
        try {
            Section section = getSection(sectionName); // throws MySectionNotFoundException
            Parameter parameter = section.getParameter(parameterName); // throws MyParameterNotFoundException
            result = parameter.getIntValue(); // throws MyTypeConvertingException

            // сообщение о нахождении
            System.out.println("Found [" + section.getName() + "]: " + parameter.getName() + " = (int) " + result);
        }
        catch (MySectionNotFoundException exc1) {
            System.out.println(sectionName + ": " + exc1.getMessage());
        }
        catch (MyParameterNotFoundException exc2) {
            System.out.println("There is no such parameter: " + exc2.get() + " in section " + sectionName);
        }
        catch (MyTypeConvertingException exc3) {
            System.out.println(exc3.getMessage() + " from parameter " + parameterName + " [" + sectionName + "]" );
        }
        return result;
    }

    public float getFloatValue(String sectionName, String parameterName) {
        float result = -2147483648; // начальная инициализация
        try {
            Section section = getSection(sectionName); // throws MySectionNotFoundException
            Parameter parameter = section.getParameter(parameterName); // throws MyParameterNotFoundException
            result = parameter.getFloatValue(); // throws MyTypeConvertingException

            // сообщение о нахождении
            System.out.println("Found [" + section.getName() + "]: " + parameter.getName() + " = (float) " + result);
        }
        catch (MySectionNotFoundException exc1) {
            System.out.println(sectionName + ": " + exc1.getMessage());
        }
        catch (MyParameterNotFoundException exc2) {
            System.out.println("There is no such parameter: " + exc2.get() + " in section " + sectionName);
        }
        catch (MyTypeConvertingException exc3) {
            System.out.println(exc3.getMessage() + " from parameter " + parameterName + " [" + sectionName + "]" );
        }
        return result;
    }

    public String getStringValue(String sectionName, String parameterName) {
        String result = ""; // начальная инициализация
        try {
            Section section = getSection(sectionName); // throws MySectionNotFoundException
            Parameter parameter = section.getParameter(parameterName); // throws MyParameterNotFoundException
            result = parameter.getValue();

            // сообщение о нахождении
            System.out.println("Found [" + section.getName() + "]: " + parameter.getName() + " = (String) " + result);
        }
        catch (MySectionNotFoundException exc1) {
            System.out.println(sectionName + ": " + exc1.getMessage());
        }
        catch (MyParameterNotFoundException exc2) {
            System.out.println("There is no such parameter: " + exc2.get() + " in section " + sectionName);
        }
        return result;
    }

    private Section getSection(String sectionName) throws MySectionNotFoundException {
        Section necSection = null;
        for (Section item : this.sections) {
            if (item.getName().equals(sectionName)) {
                necSection = item;
            }
        }
        // если не нашлось секции
        if (necSection == null)
        {
            throw new MySectionNotFoundException();
        }
        return necSection;
    }
}
