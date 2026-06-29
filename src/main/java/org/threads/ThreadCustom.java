package org.threads;

public class ThreadCustom extends Thread {

    public ThreadCustom(String name) { // конструктор
        super(name);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
