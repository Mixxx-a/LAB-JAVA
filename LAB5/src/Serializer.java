import org.dom4j.*;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

public class Serializer {

    static <T> Element serialize(T tObject) throws Exception{
        Class<?> clazz = tObject.getClass();

        Document document = DocumentHelper.createDocument();
        Element root = null;

        XmlObject[] xmlObjects = clazz.getAnnotationsByType(XmlObject.class);
        if (xmlObjects.length > 0) {
            String name = xmlObjects[0].name();
            if (name.equals("default")) {
                name = clazz.getCanonicalName().toLowerCase();
            }
            root = document.addElement(name);
        }
        else
        {
            System.exit(0);
        }


            Field[] fields = clazz.getDeclaredFields();
            Method[] methods = clazz.getDeclaredMethods();

            // мап с информацией о именах тегов и них самих
            Map<String, XmlTag> xmlTagsMap = new HashMap<>();
            // мап с информацией о именах тегов и элементов с соответсвющими тегами
            Map<String, Element> elementsMap = new HashMap<>();

            // добавление полей в map
            for (Field field : fields) {

                field.setAccessible(true);
                XmlObject[] locXmlObj = field.getType().getAnnotationsByType(XmlObject.class);
                if (locXmlObj.length > 0) {
                    root.add(serialize(field.get(tObject)));
                }


                XmlTag[] fieldXmlTags = field.getAnnotationsByType(XmlTag.class);
                for (XmlTag xmlTag : fieldXmlTags) {
                    // проверка наличия доп. имени
                    String name = xmlTag.name();
                    if (name.equals("default")) {
                        name = field.getName();
                    }
                    // если в мапе уже есть такое поле
                    if (xmlTagsMap.containsKey(name)) {
                        throw new Exception();
                    }
                    // добавление
                    Element newFieldElem = root.addElement(name).addText(field.get(tObject).toString());
                    xmlTagsMap.put(name, xmlTag);
                    elementsMap.put(name, newFieldElem);
                }
            }

            //добавление методов в maps
            for (Method method : methods) {
                XmlTag[] methodXmlTags = method.getAnnotationsByType(XmlTag.class);
                for (XmlTag xmlTag : methodXmlTags) {
                    // проверка на количество параметров и его возвращаемое значение
                    Parameter[] parameters = method.getParameters();
                    if (parameters.length > 0 || method.getReturnType().equals(void.class)) {
                        throw new Exception();
                    }
                    String name = xmlTag.name();
                    if (name.equals("default")) {
                        name = method.getName();
                        // "отбрасывание" get
                        if (name.startsWith("get")) {
                            name = name.substring(3).toLowerCase();
                        }
                    }
                    if (xmlTagsMap.containsKey(name)) {
                        throw new Exception();
                    }
                    method.setAccessible(true);
                    Element newMethodElement = root.addElement(name).addText(method.invoke(tObject).toString());
                    xmlTagsMap.put(name, xmlTag);
                    elementsMap.put(name, newMethodElement);
                }
            }

            //добавление атрибутов к существующим полям
            for (Field field : fields) {
                XmlAttribute[] xmlAttributes = field.getAnnotationsByType(XmlAttribute.class);
                for (XmlAttribute xmlAttribute : xmlAttributes) {
                    for (Map.Entry<String, XmlTag> xmlTag : xmlTagsMap.entrySet()) {
                        String tagName = xmlTag.getKey();

                        if (tagName.equals(xmlAttribute.tag())) {
                            String attributeName = xmlAttribute.name();
                            if (attributeName.equals("default")) {
                                attributeName = field.getName();
                            }
                            field.setAccessible(true);
                            String attributeValue = field.get(tObject).toString();
                            elementsMap.put(tagName, elementsMap.get(tagName).addAttribute(attributeName, attributeValue));
                        }
                    }
                }
            }

            //тоже и с методами
            for (Method method : methods) {
                XmlAttribute[] xmlAttributes = method.getAnnotationsByType(XmlAttribute.class);
                for (XmlAttribute xmlAttribute : xmlAttributes) {
                    for (Map.Entry<String, XmlTag> xmlTag : xmlTagsMap.entrySet()) {
                        String tagName = xmlTag.getKey();

                        if (tagName.equals(xmlAttribute.tag())) {
                            Parameter[] parameters = method.getParameters();
                            if (parameters.length > 0 || method.getReturnType().equals(void.class)) {
                                throw new Exception();
                            }
                            String attributeName = xmlAttribute.name();
                            if (attributeName.equals("default")) {
                                attributeName = method.getName();
                                if (attributeName.startsWith("get")) {
                                    attributeName = attributeName.substring(3).toLowerCase();
                                }
                            }
                            method.setAccessible(true);
                            String attributeValue = method.invoke(tObject).toString();
                            elementsMap.put(tagName, elementsMap.get(tagName).addAttribute(attributeName, attributeValue));
                        }
                    }
                }
            }
        try {
            FileWriter out = new FileWriter("test.xml");
            document.write(out);
            out.close();
        }
        catch (IOException exc) {
            throw exc;
        }
        return root;
    }
}
