package ru.yandex.coderun.quickstart;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 17. Сапёр<p>
 * <h6>Формат вывода</h6>
 * Выведите построенное поле, разделяя строки поля переводом строки, а столбцы -
 * пробелом.
 */
public class Minesweeper {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]);

        int[][] field = new int[n][m];

        // Читаем координаты мин и отмечаем их на поле
        for (int i = 0; i < k; i++) {
            input = reader.readLine().split(" "); // координаты мин задаются в формате 1-indexed
            int p = Integer.parseInt(input[0]) - 1; // перевод координаты в 0-index
            int q = Integer.parseInt(input[1]) - 1; // перевод координаты в 0-index
            field[p][q] = -1; // -1 означает мину
        }

        reader.close();

        for (int i = 0; i < n; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < m; j++) {
                if (j > 0) {
                    row.append(" ");
                }

                if (field[i][j] == -1) {
                    row.append("*");
                } else {
                    int mineCount = countMines(field, i, j, n, m);
                    row.append(mineCount);
                }
            }
            writer.write(row + "\n");
        }

        writer.close();
    }

    private static int countMines(int[][] field, int x, int y, int n, int m) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int ni = x + i;
                int nj = y + j;
                // Проверяем, что соседняя клетка находится в пределах поля
                if (ni >= 0 && ni < n && nj >= 0 && nj < m && field[ni][nj] == -1) {
                    count++;
                }
            }
        }
        return count;
    }
}
