package com.navi.unit3.classes;

public class Greeter implements Runnable {

    String target;

    int n;

    public Greeter(String target, int n) {
        this.n = n;
        this.target = target;
    }

    public void run() {
        for (; n >= 0; n--)
            System.out.println("Hello, " + target);
    }
}
