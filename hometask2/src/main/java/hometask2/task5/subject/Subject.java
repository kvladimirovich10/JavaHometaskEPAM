package hometask2.task5.subject;import hometask2.task5.student.Student;//import lombok.Data;import java.util.ArrayList;import java.util.List;//@Datapublic class Subject {    private SubjectName subjectName;    private List<Student> studentSubjectList;    private boolean isDoubleMark;    private int maxMark;    private int minMark;    public Subject(SubjectName subjectName,                   boolean isDoubleMark,                   int minMark,                   int maxMark) {        this.subjectName = subjectName;        this.studentSubjectList = new ArrayList<>();        this.isDoubleMark = isDoubleMark;        this.maxMark = maxMark;        this.minMark = minMark;    }    public boolean getIsDoubleMark() {        return isDoubleMark;    }    public SubjectName getSubjectName() {        return subjectName;    }    public List<Student> getStudentSubjectList() {        return studentSubjectList;    }    public boolean isDoubleMark() {        return isDoubleMark;    }    public int getMaxMark() {        return maxMark;    }    public int getMinMark() {        return minMark;    }}