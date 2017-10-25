package hometask2.task5;import hometask2.task5.student.*;import hometask2.task5.subject.*;import java.io.BufferedReader;import java.io.IOException;import java.text.DecimalFormat;import java.util.ArrayList;import java.util.Arrays;import java.util.Collections;import java.util.Random;public class ProjectService {    private static Random random = new Random();    private static int studentsNumber = 10;    private static Double normalizedMark;    private static DecimalFormat df2 = new DecimalFormat(".##");    static void createDemo(ArrayList<Student> studentArrayList,                           ArrayList<Subject> subjectArrayList) {        for (int i = 0 ; i < studentsNumber ; i++) {            Student student = new Student(Name.values()[random.nextInt(Name.values().length)],                    LastName.values()[random.nextInt(LastName.values().length)]);            studentArrayList.add(student);        }        Subject COMPUTER_SCIENCE = new Subject(SubjectName.COMPUTER_SCIENCE, true, 0, 10);        subjectArrayList.add(COMPUTER_SCIENCE);        pairStudentSubject(studentArrayList, COMPUTER_SCIENCE);        Subject MATH = new Subject(SubjectName.MATH, true, 1, 10);        subjectArrayList.add(MATH);        pairStudentSubject(studentArrayList, MATH);        Subject ART = new Subject(SubjectName.ART, true, 1, 10);        subjectArrayList.add(ART);        pairStudentSubject(studentArrayList, ART);        Subject PHYSICS = new Subject(SubjectName.PHYSICS, false, 2, 5);        subjectArrayList.add(PHYSICS);        pairStudentSubject(studentArrayList, PHYSICS);        Subject LANGUAGE = new Subject(SubjectName.LANGUAGE, false, 2, 5);        subjectArrayList.add(LANGUAGE);        pairStudentSubject(studentArrayList, LANGUAGE);    }    private static void pairStudentSubject(ArrayList<Student> studentArrayList,                                           Subject subject) {        Integer[] arr = new Integer[studentsNumber];        for (int i = 0 ; i < studentsNumber ; i++) {            arr[i] = i;        }        Collections.shuffle(Arrays.asList(arr));        for (int i = 0 ; i < 5 ; i++) {            StudentService.pairSubjectWithStudent(studentArrayList.get(arr[i]), subject);            SubjectService.pairStudentWithSubject(subject, studentArrayList.get(arr[i]));            normalizedMark = (double) random.nextInt(subject.getMinMark() + 100 * (subject.getMaxMark() - subject.getMinMark())) / (100 * subject.getMaxMark());            StudentService.pairStudentSubjectWithMark(studentArrayList.get(arr[i]),                    subject,                    normalizedMark);        }    }    static void printGroupList(ArrayList<Subject> subjectArrayList, BufferedReader reader) throws IOException {        int i = 1;        for (Subject subject : subjectArrayList) {            System.out.println(i++ + "  " + subject.getSubjectName());        }        System.out.format("%n* type the group number to look through the student list | 0 - back to the menu%n");        i = enterInt(reader);        if (i == 0)            return;        while (i < 0 || i > subjectArrayList.size()) {            System.out.format("%n* can't find this note, try again!%n");            i = Integer.parseInt(reader.readLine());        }        printStudentsInGroup(subjectArrayList.get(i));    }    static void printStudentList(ArrayList<Student> studentArrayList, BufferedReader reader) throws IOException {        int i = 1;        for (Student student : studentArrayList) {            System.out.println(i++ + "  " + student.getName() + " " + student.getLastName());        }        System.out.format("%n* type the student number to look through groups he or she joined | 0 - back to the menu%n");        i = enterInt(reader);        if (i == 0)            return;        while (i < 0 || i > studentArrayList.size()) {            System.out.format("%n* can't find this note, try again!%n");            i = Integer.parseInt(reader.readLine());        }        printGroupsOfStudent(studentArrayList.get(i));    }    private static void printStudentsInGroup(Subject subject) {        int i = 1;        for (Student student : subject.getStudentSubjectList()) {            System.out.println(i++ + "  " + student.getName() + " " + student.getLastName());        }    }    private static void printGroupsOfStudent(Student student) {        int i = 1;        for (Subject subject : student.getSubjectList()) {            double mark = student.getStudentMarks().get(student.getSubjectList().indexOf(subject));            double builtMark = mark * subject.getMaxMark();            if (subject.getIsDoubleMark())                System.out.println(i++ + "  " + subject.getSubjectName() + " " + df2.format(builtMark) + "(" + subject.getMaxMark() + ")");            else                System.out.println(i++ + "  " + subject.getSubjectName() + " " + (int) builtMark + "(" + subject.getMaxMark() + ")");        }    }    static void sortMarks(ArrayList<Student> studentArrayList) {    }    static int enterInt(BufferedReader reader) throws IOException {        String readLine = reader.readLine();        while (!isInteger(readLine)) {            System.out.println("Enter a valid number!");            readLine = reader.readLine();        }        return Integer.parseInt(readLine);    }    private static boolean isInteger(String s) {        try {            Integer.parseInt(s);        } catch (NumberFormatException | NullPointerException e) {            return false;        }        return true;    }}