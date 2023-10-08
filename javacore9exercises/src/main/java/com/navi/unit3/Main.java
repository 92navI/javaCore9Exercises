package com.navi.unit3;

import java.io.File;
import java.io.IOException;
// import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.navi.unit3.classes.Employee;
import com.navi.unit3.classes.Greeter;
// import com.navi.unit3.classes.Measures;
import com.navi.unit3.classes.Files;
// import com.navi.unit3.classes.interfaces.IntSequence;
// import com.navi.unit3.classes.interfaces.SquareSequence;
// import com.navi.unit3.classes.Threads;

public class Main {

    static Greeter greeter1 = new Greeter("Ivan", 11);
    static Greeter greeter2 = new Greeter("Polina", 13);
    static Greeter greeter3 = new Greeter("Arthut", 9);
    static Greeter greeter4 = new Greeter("Tatalyalya", 14);

    static List<Employee> employees = List.of(
            new Employee("Alex", 569),
            new Employee("Steven", 750),
            new Employee("Kate", 500));

    public static void main(String[] args) {

        // // Task 1
        // System.out.println("Avarage salary: " + Measures.avarage(employees));

        // // Task 2
        // System.out.println(Measures.largest(employees).toString());

        // // Task 4
        // var sequence = IntSequence.of(2, 34345, 45346, 5, 6767, 8, 9, 654564567);
        // while(sequence.hasNext()) {
        // System.out.println(sequence.next());
        // }

        // // Task 5
        // var sequence1 = IntSequence.constant(5);
        // while (sequence1.hasNext()) {
        // System.out.println(sequence1.next());
        // }

        // // Task 6
        // var sequence2 = new SquareSequence();
        // int num = 0;
        // while (sequence2.hasNext() && num <= 40) {
        // System.out.println(sequence2.next());
        // num++;
        // }

        // // Task 8
        // var list = List.of("Helo", "HEllo", "a", "LALA888L");
        // Measures.luckySort(list, (s1, s2) -> s1.length()-s2.length());

        // // Task 9
        // var threads = new ArrayList<Thread>();
        // threads.add(new Thread(greeter1));
        // threads.add(new Thread(greeter2));
        // threads.add(new Thread(greeter3));
        // threads.add(new Thread(greeter4));
        // for (Thread t : threads) t.start();

        // // Task 10.1
        // Threads.runTogether(greeter1, greeter2, greeter3, greeter4);
        // // Task 10.2
        // Threads.runInOrder(greeter1, greeter2, greeter3, greeter4);

        // // Task 11
        var file = new File("javacore9exercises/src/main/java/com/navi/unit3/classes");
        // try {
        //     for (File f : Files.subdir(file, (f) -> f.isDirectory())) {
        //         System.out.println(f.toString());
        //     }
        // } catch (IOException e) {
        //     System.out.println(e.getMessage());
        // }

        // Task 12
        try {
        Files.listIncluding(file, "reads");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
