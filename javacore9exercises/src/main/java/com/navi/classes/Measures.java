package com.navi.classes;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
}
