package ru.yandex.coderun.quickstart;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 10. Ещё одна задача на теорию чисел<p> Вам даны 2 натуральных числа a и b.
 * Необходимо посчитать НОД(a, b) и НОК(a, b).<p> Напомним, что:<p> НОД(a,b)−
 * <b>наибольшее</b> натуральное число, на которое числа a, b делятся без
 * остатка.<br> НОК(a,b)− <b>наименьшее</b> натуральное число, которое делится
 * на числа a, b без остатка.
 */
public class AnotherProblemNumberTheory {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] input = java.util.Arrays.stream(reader.readLine().trim().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int a = input[0];
        int b = input[1];

        // в условии сказано "натуральные числа",
        // поэтому 0 не должен поступать на вход,
        // добавление проверки сделало бы код более надежным.
        if (a == 0 || b == 0) {
            writer.write((a + b) + " " + 0);
            reader.close();
            writer.close();
            return;
        }

        long nod = getNod(a, b);
        long nok = (long) a * b / nod;

        writer.write(nod + " ");
        writer.write(String.valueOf(nok));

        reader.close();
        writer.close();
    }

    static long getNod(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
