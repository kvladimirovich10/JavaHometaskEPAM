package hometask2.task5.subject;import hometask2.task5.student.Student;public class SubjectService {    public static void pairStudentWithSubject(Subject subject, Student student) {        subject.studentSubjectList.add(student);    }}