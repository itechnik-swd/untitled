package com.leetcode.util;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        new B();

        System.out.println();

        var tpe = new ThreadPoolExecutor(2, 4, 60L, TimeUnit.SECONDS, new SynchronousQueue<>());
    }
}
