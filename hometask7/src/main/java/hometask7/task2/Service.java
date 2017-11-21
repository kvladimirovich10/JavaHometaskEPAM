package hometask7.task2;import hometask7.task1.PropertiesFileNotFoundException;import hometask7.task1.PropertyKeyNotFoundException;import java.util.ArrayList;public class Service {    private static int poolSize;    static ArrayList<String> getPropValue() {        ArrayList<String> stringArrayList = null;        try {            hometask7.task1.Service service = hometask7.task1.Service.getInstance("hometask7/src/main/resources/connInfo.properties");            new ArrayList<String>();            stringArrayList.add(1,service.getProperty("DB_DRIVER"));            stringArrayList.add(2,service.getProperty("DB_CONNECTION"));            stringArrayList.add(3,service.getProperty("DB_USER"));            stringArrayList.add(4,service.getProperty("DB_PASSWORD"));            try {                poolSize = Integer.parseInt(service.getProperty("DB_POOLSIZE"));            } catch (NumberFormatException e) {                poolSize = 5;            }            stringArrayList.add(5,String.valueOf(poolSize));        } catch (PropertyKeyNotFoundException | PropertiesFileNotFoundException e) {            System.out.println(e.getMessage());        }        return stringArrayList;    }}