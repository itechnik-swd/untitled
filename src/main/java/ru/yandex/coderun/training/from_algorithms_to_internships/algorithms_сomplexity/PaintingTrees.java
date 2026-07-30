package ru.yandex.coderun.training.from_algorithms_to_internships.algorithms_сomplexity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * A. Покраска деревьев
 */
public class PaintingTrees {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
        Пример ввода и вывода числа n, где -10^9 < n < 10^9:
        int n = Integer.parseInt(reader.readLine());
        writer.write(String.valueOf(n));
        */

        String[] input = reader.readLine().split(" ");
        int p = Integer.parseInt(input[0]); // номер дерева, у которого стоит ведро Васи
        int v = Integer.parseInt(input[1]); // на сколько деревьев он может от него удаляться

        input = reader.readLine().split(" ");
        int q = Integer.parseInt(input[0]); // номер дерева, у которого стоит ведро Маши
        int m = Integer.parseInt(input[1]); // на сколько деревьев она может от него удаляться

        int minv = p - v; // начало отрезка Васи
        int maxv = p + v; // окончание отрезка Васи

        int minm = q - m; // начало отрезка Маши
        int maxm = q + m; // окончание отрезка Маши

        if (Math.max(minv, minm) <= Math.min(maxv, maxm)) {
            writer.write(String.valueOf(Math.max(maxv, maxm) - Math.min(minv, minm) + 1));
        } else {
            writer.write(String.valueOf((maxv - minv + 1) + (maxm - minm + 1)));
        }

        reader.close();
        writer.close();
    }
}
