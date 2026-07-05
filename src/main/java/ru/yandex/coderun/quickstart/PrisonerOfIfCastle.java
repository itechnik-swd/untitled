package ru.yandex.coderun.quickstart;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 19. Узник замка Иф
 */
public class PrisonerOfIfCastle {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
        Пример ввода и вывода числа n, где -10^9 < n < 10^9:
        int n = Integer.parseInt(reader.readLine());
        writer.write(String.valueOf(n));
        */

        // размер кирпича
        int[] brick = new int[3];
        brick[0] = Integer.parseInt(reader.readLine());
        brick[1] = Integer.parseInt(reader.readLine());
        brick[2] = Integer.parseInt(reader.readLine());

        java.util.Arrays.sort(brick);

        // прямоугольное отверстие размером
        int d = Integer.parseInt(reader.readLine());
        int e = Integer.parseInt(reader.readLine());

        // Находим меньшую и большую стороны отверстия
        int holeMin = Math.min(d, e);
        int holeMax = Math.max(d, e);

        // Сравниваем две наименьшие стороны кирпича со сторонами отверстия
        if (brick[0] <= holeMin && brick[1] <= holeMax) {
            writer.write("YES");
        } else {
            writer.write("NO");
        }

        reader.close();
        writer.close();
    }
}
