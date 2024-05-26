package com.navi.unit10;

import java.io.File;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.navi.unit10.classes.DirReader;
import com.navi.unit10.classes.Incrementer;
import com.navi.unit10.classes.Matrix;

class Main {

    private static String path = "javacore9exercises/src/main/java/com/navi/unit10/dir";

    private static String word = "hello";

    private static ConcurrentHashMap<String, Long> map = new ConcurrentHashMap<String, Long>(
            Map.of("askdjfasl", 1293767l, "a", 129083678125631l, "b", 1l));

    public static void main(String[] args) {

        // Task 1

        List<File> result0 = new ArrayList<File>();

        try {
        result0 = DirReader.parallelSearch(path, word);
        } catch (Exception e) {
        e.printStackTrace();
        }

        System.out.println("Results:");
        System.out.println("The word \'" + word + "\' was found in: \n" + result0);

        // Task 2

        double[] array = new double[10000000];

        for (int i = 0; i <= 9999999; i++) {
        var num = new Random().nextInt(1000, 9999);
        array[i] = num;
        System.out.println(num);
        }

        var time1 = Instant.now();
        Arrays.sort(array);
        var time2 = Instant.now();
        var diff1 = Duration.between(time1, time2);

        System.out.println("Arrays.sort() done in: " + diff1.toNanos());

        var time3 = Instant.now();
        Arrays.parallelSort(array);
        var time4 = Instant.now();
        var diff2 = Duration.between(time3, time4);

        System.out.println("Arrays.parralelSort() done in: " + diff2.toNanos());

        // Task 3

        File result1 = new File("");

        try {
        result1 = DirReader.threadSearch(path, word);
        } catch (Exception e) {
        e.printStackTrace();
        }

        System.out.println("Results:");
        System.out.println("The word \'" + word + "\' was found in: \n" + result1);

        // Task 4

        Matrix[] fibonacci = new Matrix[100];
        Arrays.fill(fibonacci, new Matrix(1, 1, 1, 0));
        Arrays.parallelPrefix(fibonacci, (x, y) -> x.multiply(y));
        System.out.println(Arrays.toString(Arrays.stream(fibonacci).map(m ->
        m.matrix[0][0]).toArray()));

        // Task 6

        try {
        HashMap<String, List<File>> mapping = DirReader.parallelSearchAll(path);
        System.out.println(new ObjectMapper()
        .writerWithDefaultPrettyPrinter()
        .writeValueAsString(mapping));
        } catch (Exception e) {
        e.printStackTrace();
        }

        // Task 8

        System.out.println(
        map.reduceEntries(10,
        (e1, e2) -> {
        var code = e1.getValue().compareTo(e2.getValue());
        if (code < 0) {
        return e2;
        } else if (code > 0) {
        return e1;
        } else {
        return e1;
        }
        }));

        // Task 9

        var exec = Executors.newCachedThreadPool();


        var time10 = Instant.now();
        var adder1 = new AtomicLong();
        try {
            var result = exec.invokeAll(Incrementer.createIncrementationPool(adder1));
            System.out.println(result);
        } catch (Exception ignored) {
        }

        var time30 = Instant.now();
        var adder2 = new LongAdder();
        try {
            var result = exec.invokeAll(Incrementer.createIncrementationPool(adder2));
            System.out.println(result);
        } catch (Exception ignored) {
        }

        System.out.println(adder1);
        System.out.println(adder2);

        var time20 = Instant.now();
        var diff10 = Duration.between(time10, time20);
        System.out.println("Operation with AtomicLong was done in: " + diff1.toNanos());

        var time40 = Instant.now();
        var diff20 = Duration.between(time30, time40);
        System.out.println("Operation with LongAdder was done in: " + diff2.toNanos());

        // Cleanup
        System.exit(0);
    }
}