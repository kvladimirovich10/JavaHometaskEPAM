package hometask3.task1;import java.util.List;public interface CrazyLoggerImpl {    String getDate(String date);    String getMsg(String msg);    List<String> getMsgsInInterval(String date1, String date2);}