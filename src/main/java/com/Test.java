package com;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>(List.of(5, 12, 15, 8, 3, 20));
        System.out.println(integers);
        removeMoreTen(integers);
        System.out.println(integers);
    }

    static void removeMoreTen(List<Integer> integers) {
        for (int i = 0; i < integers.size(); i++) {
            if (integers.get(i) > 10) {
                integers.remove(i);
            }
        }
    }

}
