package ru.yandex.coderun.quickstart;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 14. Наибольшее произведение трех чисел<p> Попробуй сам подумать, какие вообще
 * комбинации чисел могут дать самое большое произведение. Кажется, что это
 * просто три самых больших числа, но отрицательные числа всё портят: два
 * отрицательных дают положительное произведение, и оно может оказаться больше,
 * чем произведение трёх положительных.<br> Так что правильный ответ — это
 * максимум из двух возможных вариантов. Как думаешь, каких именно?
 */
public class LargestProductOfThreeNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] input = java.util.Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted() // !!!
                .toArray();

        int n = input.length;

        long product1 = (long) input[n - 1] * input[n - 2] * input[n - 3];
        long product2 = (long) input[0] * input[1] * input[n - 1];

        int a, b, c;
        if (product1 >= product2) {
            a = input[n - 1];
            b = input[n - 2];
            c = input[n - 3];
        } else {
            a = input[0];
            b = input[1];
            c = input[n - 1];
        }

        writer.write(a + " " + b + " " + c);

        reader.close();
        writer.close();
    }
}
