package com.navi.unit10;

import java.io.File;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.navi.unit10.classes.DirReader;
import com.navi.unit10.classes.Matrix;

class Main {

    private static String path = "javacore9exercises/src/main/java/com/navi/unit10/dir";

    private static String word = "hello";

    public static void main(String[] args) {

        // Task 1

        List<File> result = new ArrayList<File>();

        try {
            result = DirReader.parallelSearch(path, word);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Results:");
        System.out.println("The word \'" + word + "\' was found in: \n" + result);

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
        System.out.println(Arrays.toString(Arrays.stream(fibonacci).map(m -> m.matrix[0][0]).toArray()));

        // Task 6

        try {
            HashMap<String, List<File>> mapping = DirReader.parallelSearchAll(path);
            System.out.println(new ObjectMapper()
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}