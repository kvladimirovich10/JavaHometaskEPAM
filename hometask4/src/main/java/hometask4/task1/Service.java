package hometask4.task1;import java.util.ArrayList;public class Service {    static ArrayList<String> readKeyWords(String fileName) {        ArrayList<String> keyWords = new ArrayList<>();        return keyWords;    }    static StringBuilder readCode(String fileName){        StringBuilder code = new StringBuilder();        return code;    }    static void writeResult(String fileName,                            ArrayList<String> keyWords,                            Integer[] matches){    }    static Integer[] matcher(ArrayList<String> kewWords, StringBuilder code) {        Integer[] matches = new Integer[kewWords.size()];        for (int i = 0 ; i < matches.length ; i++) {            matches[i] = 0;        }        return matches;    }}