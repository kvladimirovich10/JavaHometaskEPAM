package hometask6.task2;import java.util.HashMap;import java.util.Map;public class Main {    static Map map = new HashMap<String,String>();    public static void main(String[] args) {        try {            Service service = Service.getInstance("hometask6/src/main/resources/demoTextFileWRONG.properties");            System.out.println(service.getProperty("key4", map));        } catch (PropertyKeyNotFoundException | PropertiesFileNotFoundException e) {            System.out.println(e.getMessage());        }        try {            Service service = Service.getInstance("hometask6/src/main/resources/demoTextFile.properties");            System.out.println(service.getProperty("key1", map));        } catch (PropertyKeyNotFoundException | PropertiesFileNotFoundException e) {            System.out.println(e.getMessage());        }        try {            Service service = Service.getInstance("hometask6/src/main/resources/demoTextFile.properties");            System.out.println(service.getProperty("key2", map));        } catch (PropertyKeyNotFoundException | PropertiesFileNotFoundException e) {            System.out.println(e.getMessage());        }        try {            Service service = Service.getInstance("hometask6/src/main/resources/demoTextFile.properties");            System.out.println(service.getProperty("key3", map));        } catch (PropertyKeyNotFoundException | PropertiesFileNotFoundException e) {            System.out.println(e.getMessage());        }        map.forEach((key, value) -> System.out.println(key + "/" + value));    }}