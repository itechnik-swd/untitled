package org.example;

class Counter {
    private int count = 0;

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
// Два потока одновременно вызывают increment() 1000 раз каждый
