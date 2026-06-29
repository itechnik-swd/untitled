package ru.yandex.coderun.quickstart;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 2. Треугольник
 * <ul>
 *     <li>Треугольник — это три точки, не лежащие на одной прямой.</li>
 *     <li>Треугольник существует, если каждая сторона меньше суммы двух других.</li>
 * </ul>
 */
public class Triangle {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
        Пример ввода и вывода числа n, где -10^9 < n < 10^9:
        int n = Integer.parseInt(reader.readLine());
        writer.write(String.valueOf(n));
        */
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());

        if (a < b + c && b < a + c && c < a + b) {
            writer.write("YES");
        } else {
            writer.write("NO");
        }

        reader.close();
        writer.close();
    }
}
