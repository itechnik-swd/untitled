package ru.yandex.coderun.quickstart;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 16. Улучшение успеваемости
 */

public class ImprovingAcademicPerformance {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
        Пример ввода и вывода числа n, где -10^9 < n < 10^9:
        int n = Integer.parseInt(reader.readLine());
        writer.write(String.valueOf(n));
        */

        long a = Long.parseLong(reader.readLine()); // a двоек
        long b = Long.parseLong(reader.readLine()); // b троек
        long c = Long.parseLong(reader.readLine()); // с четвёрок

        long temp = 3 * a + b - c;
        long d = (temp <= 0) ? 0 : (temp + 2) / 3; // округление вверх

        writer.write(String.valueOf(d));

        reader.close();
        writer.close();
    }
}
