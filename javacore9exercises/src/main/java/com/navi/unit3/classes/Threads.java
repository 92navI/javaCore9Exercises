package com.navi.unit3.classes;

public class Threads {
    public static void runTogether(Runnable... tasks) {
        for (Runnable i : tasks) {
            var thread = new Thread(i);
            thread.start();
        }
    }

    public static void runInOrder(Runnable... tasks) {
        for (Runnable i : tasks) {
            i.run();
        }
    }
}
