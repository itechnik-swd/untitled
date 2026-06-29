package ru.yandex.coderun.quickstart;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 5. 29 задача аналитики
 */
public class AnalyticsTask29 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
        Пример ввода и вывода числа n, где -10^9 < n < 10^9:
        int n = Integer.parseInt(reader.readLine());
        writer.write(String.valueOf(n));
        */

        String[] input = reader.readLine().split(" ");
        double a = Double.parseDouble(input[0]);
        double b = Double.parseDouble(input[1]);
        double c = Double.parseDouble(input[2]);

        double discriminant = b * b - 4 * a * c;

        if (discriminant < 0) {
            writer.write("0");
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            writer.write("1\n" + root);
        } else {
            double sqrtD = Math.sqrt(discriminant);
            double x1 = (-b - sqrtD) / (2 * a);
            double x2 = (-b + sqrtD) / (2 * a);

            if (x1 > x2) {
                double temp = x1;
                x1 = x2;
                x2 = temp;
            }
            writer.write("2\n" + x1 + " " + x2);
        }

        reader.close();
        writer.close();
    }
}
