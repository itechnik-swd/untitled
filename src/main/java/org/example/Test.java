package org.example;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static java.util.Arrays.sort;

public class Test {
    public static void main(String[] args) {
        int[] data = {5, 3, 1, 7, 2, 4, 6};

        sort(data);

        System.out.println(Arrays.toString(data));


        System.out.println(new String(new byte[]{
                72, 101, 108, 108, 111, 32, 87, 111, 114, 108, 100, 33
        }, StandardCharsets.UTF_8));
        System.out.println(Arrays.toString(
                "Hello World!".getBytes(StandardCharsets.UTF_8)));
    }
}
