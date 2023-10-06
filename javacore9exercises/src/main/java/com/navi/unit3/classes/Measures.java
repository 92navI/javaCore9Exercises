package com.navi.unit3.classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.navi.unit3.classes.interfaces.Measurable;

public class Measures {

    public static Double avarage(List<? extends Measurable<Double>> objects) {
        Double avarage = 0.0;
        var values = objects.stream()
                .map(obj -> {
                    System.out.println(obj.toString());
                    return obj.getMeasure();
                })
                .collect(Collectors.toList());
        for (Double i : values)
            avarage += i;
        return avarage / values.size();
    }

    public static Measurable<Double> largest(List<? extends Measurable<Double>> objects) {
        var values = objects.stream()
                .map(obj -> obj.getMeasure())
                .collect(Collectors.toList());
        Double maxValue = Collections.max(values);
        return objects.get(values.indexOf(maxValue));
    }

    public static void luckySort(List<String> list, Comparator<String> comparator) {

        var sorted = new ArrayList<String>(list);
        sorted.sort(comparator);
        var shuffled = new ArrayList<String>(list);

        System.out.println("Sorted: " + sorted.toString() + "\n");

        while (true) {
            Collections.shuffle(shuffled);
            System.out.println(shuffled.toString());
            if (sorted.equals(shuffled)) {
                System.out.println("Sorted!!!");
                return;
            }
            System.out.println("Nope!\n");
        }
    }
}
