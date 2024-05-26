package com.navi.unit10.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class Incrementer {

    public static List<Callable<Boolean>> createIncrementationPool(AtomicLong adder) {
        var tasks = new ArrayList<Callable<Boolean>>();
        for (int i = 0; i <= 1_000; i++) {
            tasks.add(() -> {
                for (int y = 0; y <= 1_000; y++) {
                    if (Thread.interrupted())
                        return false;
                    adder.incrementAndGet();
                }
                return true;
            });
        }
        return tasks;
    }

    public static List<Callable<Boolean>> createIncrementationPool(LongAdder adder) {
        var tasks = new ArrayList<Callable<Boolean>>();
        for (int i = 0; i <= 1_000; i++) {
            tasks.add(() -> {
                for (int y = 0; y <= 1_000; y++) {
                    if (Thread.interrupted())
                        return false;
                    adder.increment();
                }
                return true;
            });
        }
        return tasks;
    }
}