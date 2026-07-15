package org.threads;

public class DeadlockExample {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (lock1) {                 // Поток 1 захватил lock1
                System.out.println("T1: locked lock1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
                synchronized (lock2) {             // и ждёт lock2
                    System.out.println("T1: locked lock2");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock2) {                 // Поток 2 захватил lock2
                System.out.println("T2: locked lock2");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
                synchronized (lock1) {             // и ждёт lock1
                    System.out.println("T2: locked lock1");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
