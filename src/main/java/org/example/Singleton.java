package org.example;

public enum Singleton {
    INSTANCE;

    public void doSomething() {
        System.out.println("Action performed by " + this);
    }
}
