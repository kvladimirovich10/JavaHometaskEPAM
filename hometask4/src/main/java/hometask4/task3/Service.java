package hometask4.task3;import java.io.FileNotFoundException;import java.io.FileReader;import java.io.IOException;public class Service {    static String readPlainText(String fileName) {        StringBuilder stringBuilder = new StringBuilder();        int n;        try {            FileReader fileReader = new FileReader(fileName);            while ((n = fileReader.read()) != 1) {                stringBuilder.append((char)n);            }            System.out.println(stringBuilder);        } catch (FileNotFoundException e) {            e.printStackTrace();        } catch (IOException e) {            e.printStackTrace();        }        return stringBuilder.toString();    }    static void writeUTF8(String text, String fileName) {    }    static void writeUTF16(String fileNameUTF8, String fileNameUTF16) {    }}