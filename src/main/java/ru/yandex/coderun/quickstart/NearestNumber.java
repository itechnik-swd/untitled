package ru.yandex.coderun.quickstart;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 12. Ближайшее число
 */
public class NearestNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int[] numbers = readArray(reader, n);
        int x = Integer.parseInt(reader.readLine());

        writer.write(String.valueOf(findNearest(numbers, x)));

        reader.close();
        writer.close();
    }

    private static int[] readArray(BufferedReader reader, int n) throws IOException {
        String[] input = reader.readLine().split(" ");
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }
        return numbers;
    }

    private static int findNearest(int[] numbers, int x) {
        int nearest = numbers[0];
        int minDiff = Math.abs(numbers[0] - x);

        for (int i = 1; i < numbers.length; i++) {
            int diff = Math.abs(numbers[i] - x);
            if (diff < minDiff) {
                minDiff = diff;
                nearest = numbers[i];
            }
        }

        return nearest;
    }
}
