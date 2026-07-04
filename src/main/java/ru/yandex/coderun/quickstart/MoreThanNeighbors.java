package ru.yandex.coderun.quickstart;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 3. Больше своих соседей
 */
public class MoreThanNeighbors {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
        Пример ввода и вывода числа n, где -10^9 < n < 10^9:
        int n = Integer.parseInt(reader.readLine());
        writer.write(String.valueOf(n));
        */

        int[] input = java.util.Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int count = 0;
        for (int i = 1; i < input.length - 1; i++) {
            if (input[i] > input[i - 1] && input[i] > input[i + 1]) {
                count++;
            }
        }

        writer.write(String.valueOf(count));

        reader.close();
        writer.close();
    }
}
