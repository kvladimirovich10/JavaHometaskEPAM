package task2;import java.util.ArrayList;import java.util.List;public class Employee {    private List<Item> emplStationary;    private int emplId;    public Employee(int emplId) {        this.emplId = emplId;        this.emplStationary = new ArrayList<>();    }    public List<Item> getEmplStationary() {        return emplStationary;    }    public int getEmplId() {        return emplId;    }}