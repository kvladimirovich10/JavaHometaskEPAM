package hometask2.task2;import java.util.ArrayList;import java.util.List;public class Employee {    private List<Item> emplStationary;    private Enum name;    private Enum lastName;    private int emplId;    public Employee(int emplId, Enum name, Enum lastName) {        this.emplStationary = new ArrayList<>();        this.name = name;        this.lastName = lastName;        this.emplId = emplId;    }    public List<Item> getEmplStationary() {        return emplStationary;    }    public int getEmplId() {        return emplId;    }    public Enum getName() {        return name;    }    public Enum getLastName() {        return lastName;    }}