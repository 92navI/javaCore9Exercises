package com.navi.unit3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.navi.unit3.classes.Employee;
import com.navi.unit3.classes.Files;
import com.navi.unit3.classes.Greeter;
import com.navi.unit3.classes.Measures;
import com.navi.unit3.classes.Threads;
import com.navi.unit3.classes.interfaces.IntSequence;
import com.navi.unit3.classes.interfaces.SquareSequence;

public class Main {

    static List<Greeter> greeters = List.of(
            new Greeter("Ivan", 11),
            new Greeter("Polina", 13),
            new Greeter("Arthut", 9),
            new Greeter("Tatalyalya", 14));

    static List<Employee> employees = List.of(
            new Employee("Remi", 750),
            new Employee("Alex", 569),
            new Employee("Steven", 750),
            new Employee("Kate", 500));

    static File file = new File("javacore9exercises/src/main/java/com/navi/unit3/classes");

    static List<File> fileList = List.of(
            new File("javacore9exercises/src/main/java/com/navi/unit3/classes"),
            new File("javacore9exercises/src/main/java/com/navi/unit3/Files.java"),
            new File("javacore9exercises/src/main/java/com/navi/unit3/classes/Employees.java"),
            new File("javacore9exercises/src/main/java/com/navi/unit3/classes/interfaces"));

    static Comparator<File> fileComparator = (f1, f2) -> {
        if (f1.isDirectory() && f2.isDirectory()) {
            return -f1.getPath().compareTo(f2.getPath());
        } else if (f1.isDirectory() && !f2.isDirectory()) {
            return -1;
        } else if (f2.isDirectory() && !f1.isDirectory()) {
            return 1;
        } else {
            return -f1.getPath().compareTo(f2.getPath());
        }
    };

    public static void main(String[] args) {

        // Task 1
        System.out.println("Avarage salary: " + Measures.avarage(employees));

        // Task 2
        System.out.println(Measures.largest(employees).toString());

        // Task 4
        var sequence = IntSequence.of(2, 34345, 45346, 5, 6767, 8, 9, 654564567);
        while (sequence.hasNext()) {
            System.out.println(sequence.next());
        }

        // Task 5
        var sequence1 = IntSequence.constant(5);
        while (sequence1.hasNext()) {
            System.out.println(sequence1.next());
        }

        // Task 6
        var sequence2 = new SquareSequence();
        int num = 0;
        while (sequence2.hasNext() && num <= 40) {
            System.out.println(sequence2.next());
            num++;
        }

        // Task 8
        var list = List.of("Helo", "HEllo", "a", "LALA888L");
        Measures.luckySort(list, (s1, s2) -> s1.length() - s2.length());

        // Task 9
        List<Thread> threads = greeters.stream().map((g) -> new Thread(g)).toList();
        for (Thread t : threads)
            t.start();

        // Task 10.1
        Threads.runTogether(greeters.get(0), greeters.get(1),
                greeters.get(2), greeters.get(3));
        // Task 10.2
        Threads.runInOrder(greeters.get(0), greeters.get(1),
                greeters.get(2), greeters.get(3));

        // Task 11
        try {

            // lists all files in this directiry
            for (File f : Files.subDirAll(file)) {
                System.out.println(f.getName());
            }

            // lists all files that pass the filter
            for (File f : Files.subDir(file, f -> f.isFile())) {
                System.out.println(f.getName());
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // Task 12
        try {

            // lists names of files that contails a string
            for (String f : Files.listIncluding(file, "es")) {
                System.out.println(f);
            }
            System.out.println();

            // lists names of files that pass the filter
            for (String f : Files.listIncluding(file, (f, name) -> {
                return name.endsWith(".java") && name.contains("es");
            })) {
                System.out.println(f);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // Task 13
        var sortedFileList = new ArrayList<File>(fileList);
        sortedFileList.sort(fileComparator);
        sortedFileList.stream().forEach(System.out::println);

        // Task 14
        Runnable runnablePool = Threads.joinTasks(greeters.get(0), greeters.get(1),
                greeters.get(2), greeters.get(3));
        runnablePool.run();

        // Task 15
        var sortedEmployees = new ArrayList<Employee>(employees);
        sortedEmployees.sort(Comparator
                .comparing((Employee e) -> e.getSalary())
                .thenComparing((Employee e) -> e.getName()));
        System.out.println(sortedEmployees);

        // Task 16
        var sequence3 = IntSequence.randomInts(0, 20);
        for (int i = 0; i <= 10; i++) {
            System.out.println(sequence3.next());
        }

        // Task 13 (Edit)
        System.out.println();
        var sortedFileList1 = new ArrayList<File>(fileList);
        sortedFileList1.sort(Comparator
                .comparing(File::isDirectory, Comparator.reverseOrder())
                .thenComparing(File::getPath, Comparator.reverseOrder()));
        sortedFileList1.stream().forEach(System.out::println);
    }

}
