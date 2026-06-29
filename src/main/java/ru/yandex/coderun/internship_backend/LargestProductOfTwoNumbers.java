package ru.yandex.coderun.internship_backend;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 *
 * 11. Наибольшее произведение двух чисел
 */
public class LargestProductOfTwoNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] numbers = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // Инициализируем значения так, чтобы корректно обновлялись
        int max1 = Integer.MIN_VALUE; // наибольшее
        int max2 = Integer.MIN_VALUE; // второе наибольшее
        int min1 = Integer.MAX_VALUE; // наименьшее
        int min2 = Integer.MAX_VALUE; // второе наименьшее

        for (int num : numbers) {
            // Обновляем два наибольших
            if (num >= max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }

            // Обновляем два наименьших
            if (num <= min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }

        long productMax = (long) max1 * max2;
        long productMin = (long) min1 * min2;

        if (productMax >= productMin) {
            writer.write(max2 + " " + max1);
        } else {
            writer.write(min1 + " " + min2);
        }

        reader.close();
        writer.close();
    }
}
