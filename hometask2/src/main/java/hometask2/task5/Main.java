package hometask2.task5;import hometask2.task5.student.Student;import hometask2.task5.subject.Subject;import java.io.BufferedReader;import java.io.IOException;import java.io.InputStreamReader;import java.util.ArrayList;import java.util.Collections;public class Main {    public static void main(String[] args) {        ArrayList<Subject> subjectList = new ArrayList<>();        ArrayList<Student> studentList = new ArrayList<>();        ProjectService.createDemo(studentList, subjectList);        ProjectService.sortMarks(studentList);        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));        try {            while (true) {                int i = 1;                System.out.format("%n* what would you like to do? Type command 1,2 or 3");                System.out.format("%n%d  Show the list of groups", i++);                System.out.format("%n%d  Show the list of students", i++);                System.out.format("%n%d  Exit%n%n", i);                int n = ProjectService.enterInt(reader);                while (n < 1 || n > 4) {                    System.out.format("%n* Type command 1,2,3 or 4...%n");                    n = ProjectService.enterInt(reader);                }                switch (n) {                    case 1: {                        ProjectService.printGroupList(subjectList, reader);                        continue;                    }                    case 2: {                        ProjectService.printStudentList(studentList, reader,subjectList);                        continue;                    }                    case 3: {                        System.out.println("* Goodbye!");                        reader.close();                        return;                    }                }            }        } catch (IOException e) {            System.out.println(e.getMessage());        }    }}