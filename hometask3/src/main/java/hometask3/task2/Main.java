package hometask3.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            String country = "", language = "";

            System.out.println("1 - English");
            System.out.println("2 - ???????");

            int n = Service.enterInt(reader);

            while (n < 1 || n > 2) {
                System.out.format("%n* Type command 1 or 2...%n");
                n = Service.enterInt(reader);
            }

            switch (n) {
                case 1:
                    country = "US";
                    language = "EN";
                    break;
                case 2:
                    country = "RU";
                    language = "RU";
                    break;
            }

            Locale current = new Locale(language, country);
            ResourceBundle rb = ResourceBundle.getBundle("text", current);


            try {


                String st = rb.getString("str7");
                String s = new String(st.getBytes("ISO-8859-1"), "UTF-8");
                System.out.println("\n* "+ s + "\n");

                st = rb.getString("str1");
                String s1 = new String(st.getBytes("ISO-8859-1"), "UTF-8");
                System.out.println(1 + " - " + s1);

                st = rb.getString("str2");
                String s2 = new String(st.getBytes("ISO-8859-1"), "UTF-8");
                System.out.println(2 + " - " + s2);

                st = rb.getString("str3");
                String s3 = new String(st.getBytes("ISO-8859-1"), "UTF-8");
                System.out.println(3 + " - " + s3);

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            n = Service.enterInt(reader);

            while (n < 1 || n > 3) {
                n = Service.enterInt(reader);
            }

            switch (n) {
                case 1: {
                    String st = rb.getString("str4");
                    String s1 = new String(st.getBytes("ISO-8859-1"), "UTF-8");
                    System.out.println(s1);
                    continue;
                }
                case 2: {
                    String st = rb.getString("str5");
                    String s1 = new String(st.getBytes("ISO-8859-1"), "UTF-8");
                    System.out.println(s1);
                    continue;
                }
                case 3: {
                    String st = rb.getString("str6");
                    String s1 = new String(st.getBytes("ISO-8859-1"), "UTF-8");
                    System.out.println(s1);
                    continue;
                }
                case 4: {
                    reader.close();
                    return;
                }
            }
            System.out.format("%n%n");
        }
    }
}

