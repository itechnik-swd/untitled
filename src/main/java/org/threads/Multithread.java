package org.threads;

public class Multithread {
    public static void main(String[] args) {
        Thread thread = new ThreadCustom("ThreadCustom");

        thread.start(); // "ThreadCustom"
        thread.run(); // "main"
        thread.run(); // "main"
        thread.run(); // "main"
        thread.run(); // "main"
        thread.run(); // "main"
        // порядок не гарантирован
    }
}
