package org.threads;

public class DeadlockDemo {
    private static final Object lockA = new Object();
    private static final Object lockB = new Object();

    public static void main(String[] args) {
        // Поток 1: берет A, затем B
        Thread t1 = new Thread(() -> {
            synchronized (lockA) {
                sleep(50); // Даем второму потоку время схватить свой первый лок
                synchronized (lockB) {
                    System.out.println("T1 получил оба лока");
                }
            }
        });

        // Поток 2: берет B, затем A
        Thread t2 = new Thread(() -> {
            synchronized (lockB) {
                sleep(50);
                synchronized (lockA) {
                    System.out.println("T2 получил оба лока");
                }
            }
        });

        t1.start();
        t2.start();
    }

    private static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ignored) {
        }
    }
}
