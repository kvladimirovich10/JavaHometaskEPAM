package hometask5.task2;import java.io.File;import java.io.FileInputStream;import java.io.FileNotFoundException;import java.io.IOException;import java.util.Properties;public class Service {    private static Service instance = null;    private Properties properties = null;    private Service(String nameOfProperties) throws PropertiesFileNotFoundException {        properties = new Properties();        try (FileInputStream fis =                     new FileInputStream(new File(nameOfProperties))) {            properties.load(fis);        } catch (FileNotFoundException e) {            throw new PropertiesFileNotFoundException                    ("File: " + nameOfProperties + ", not found");        } catch (IOException e) {            e.printStackTrace();        }    }    public static Service getInstance(String nameOfProperties) throws PropertiesFileNotFoundException {        if (instance == null) {            instance = new Service(nameOfProperties);        }        return instance;    }    public String getProperty(String propKey) throws PropertyKeyNotFoundException, NullPointerException {        String propValue;        if (properties.containsKey(propKey)) {            propValue = (String) properties.get(propKey);        } else {            throw new PropertyKeyNotFoundException                    ("Property with key: " + propKey + ", not found");        }        return propValue;    }}