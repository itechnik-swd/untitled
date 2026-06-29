package ru.yandex.coderun.quickstart;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class NumberTheory {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] input = Arrays.stream(reader.readLine().trim().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int a = input[0];
        int b = input[1];

        reader.close();
        writer.close();
    }
}
