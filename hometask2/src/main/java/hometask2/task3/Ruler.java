package hometask2.task3;enum RulerType {}enum MeasuringSystem {}public class Ruler extends Item {    RulerType type;    MeasuringSystem measuringSystem;    public Ruler(RulerType type, MeasuringSystem measuringSystem, double price) {        this.type = type;        this.measuringSystem = measuringSystem;        this.price = price;    }}