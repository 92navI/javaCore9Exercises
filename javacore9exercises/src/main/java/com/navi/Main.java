package com.navi;

import java.util.List;

import com.navi.classes.Employee;
import com.navi.classes.IntSequence;
import com.navi.classes.Measures;
import com.navi.classes.SquareSequence;

public class Main {

    static List<Employee> employees = List.of(
            new Employee("Alex", 569),
            new Employee("Steven", 750),
            new Employee("Kate", 500));

    public static void main(String[] args) {

        // Task 1
        System.out.println("Avarage salary: " + Measures.avarage(employees));

        // Task 2
        System.out.println(Measures.largest(employees).toString());

        // Task 4
        var sequence = IntSequence.of(2, 34345, 45346, 5, 6767, 8, 9, 654564567);
        while(sequence.hasNext()) {
        System.out.println(sequence.next());
        }

        // Task 5
        var sequence1 = IntSequence.constant(5);
        while (sequence1.hasNext()) {
            System.out.println(sequence1.next());
        }

        // Task 6
        var sequence2 = new SquareSequence();
        int i = 0;
        while (sequence2.hasNext() && i <= 40) {
            System.out.println(sequence2.next());
            i++;
        }
    }

}
