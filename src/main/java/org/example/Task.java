package org.example;

import java.util.concurrent.atomic.AtomicInteger;

public class Task {
    public static void main(String[] args) {
        int x = 0;
        Integer y = 0;
//        AtomicInteger z = 0;
        AtomicInteger z = new AtomicInteger(0);

        increment(x);
        increment(y);
        increment(z);

        System.out.println("x = " + x); // ?
        System.out.println("y = " + y); // ?
        System.out.println("z = " + z); // ?
    }

    public static void increment(int value) {
        value++;
    }

    public static void increment(Integer value) {
        value++;
    }

    public static void increment(AtomicInteger value) {
//        value.increment();
        value.incrementAndGet();
    }
}
