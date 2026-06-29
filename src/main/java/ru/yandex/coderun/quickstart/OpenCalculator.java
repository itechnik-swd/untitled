package ru.yandex.coderun.quickstart;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 6. OpenCalculator
 */
public class OpenCalculator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
        Пример ввода и вывода числа n, где -10^9 < n < 10^9:
        int n = Integer.parseInt(reader.readLine());
        writer.write(String.valueOf(n));
        */

//        int[] input = Arrays.stream(reader.readLine().split(" "))
//                .mapToInt(Integer::parseInt)
//                .toArray();
//        int x = input[0];
//        int y = input[1];
//        int z = input[2];
//
//        int number = Integer.parseInt(reader.readLine());
//        Set<Integer> digits = new HashSet<>();
//        if (number == 0) {
//            if (x != 0 && y != 0 && z != 0) {
//                digits.add(0);
//            }
//        } else {
//            number = Math.abs(number);
//            while (number > 0) {
//                int digit = number % 10;
//                if (digit != x && digit != y && digit != z) {
//                    digits.add(digit);
//                }
//                number /= 10;
//            }
//        }
//
//        writer.write(String.valueOf(digits.size()));

        var digits = java.util.Arrays.stream(reader.readLine().split(" "))
                .toList();

        var result = reader.readLine()
                .chars()
                .distinct()
                .map(chr -> {
                    if (digits.contains(Character.toString(chr))) {
                        return 0;
                    } else {
                        return 1;
                    }
                })
                .sum();

        writer.write(String.valueOf(result));

        reader.close();
        writer.close();
    }
}
