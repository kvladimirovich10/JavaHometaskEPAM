package hometask2.task5.discipline;import lombok.Data;@Datapublic class DoubleDiscipline extends Discipline {    private double maxMark;    public DoubleDiscipline(DisciplineName disciplineName, double maxMark) {        this.maxMark = maxMark;        this.disciplineName = disciplineName;    }}