package com.navi.classes;

import java.util.Random;

public class Employee implements Measurable <Double> {
    public static Double MIN_SALARY = 100.0;
    private String name;
    private Double salary;
    private long uid = new Random ().nextLong(100000, 999999);


    public Employee (String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public Employee (String name) {
        this(name, MIN_SALARY);
    }


    public Double getMeasure () {
        return this.salary;
    }
     public String toString () {
        return String.format("""
Employee %s:
    name: %s
    salary: %s
    """, uid, name, salary);
    }

    public void raiseSalary (double byPercent) {
        double raise = salary * byPercent / 100;
        this.salary += raise;
    }

    public String getName () {
        return this.name;
    }


}
