package org.threads;

public class TestThread extends Thread {

    public static void main(String[] args) {

        TestThread myTest = new TestThread();

        myTest.start();

    }

    public void go() {
        System.out.println("Go!");
    }

    @Override
    public void run() {
        System.out.println("Run!");
    }

    public void begin() {
        System.out.println("Begin!");
    }

    public void execute() {
        System.out.println("Execute!");
    }
}
