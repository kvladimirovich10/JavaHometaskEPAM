package hometask3.task1;import java.text.SimpleDateFormat;import java.util.Date;public class Main {    public static void main(String[] args) {        CrazyLogger crazyLogger = new CrazyLogger();        String msg;        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy : hh-mm ");        for (int i = 0 ; i < 10 ; i++) {            String string = dateFormat.format(new Date()) + "- Message #"+i+";";            crazyLogger.getLogger().append(string);        }        System.out.println(crazyLogger.getDate("Message #2",crazyLogger.getLogger()));        System.out.println(crazyLogger.getMsg("11-11-2017 : 12-51",crazyLogger.getLogger()));    }}