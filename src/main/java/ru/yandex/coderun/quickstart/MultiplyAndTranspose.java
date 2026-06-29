package ru.yandex.coderun.quickstart;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * 9. Умножай и транспонируй (столбцы становятся строками)!
 */
public class MultiplyAndTranspose {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] input = Arrays.stream(reader.readLine().trim().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = input[0];
        int m = input[1];
        int k = input[2];

        int[][] matrixA = new int[n][m];
        for (int i = 0; i < n; i++) {
            input = Arrays.stream(reader.readLine().trim().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrixA[i] = input;
        }

        int[][] matrixB = new int[m][k];
        for (int i = 0; i < m; i++) {
            input = Arrays.stream(reader.readLine().trim().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrixB[i] = input;
        }

        int[][] matrixC = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                for (int l = 0; l < m; l++) {
                    matrixC[i][j] += matrixA[i][l] * matrixB[l][j];
                }
            }
        }

        int[][] matrixCT = new int[k][n];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                matrixCT[i][j] = matrixC[j][i];
            }
        }

        for (int[] row : matrixCT) {
            writer.write(Arrays.toString(row).replaceAll("[\\[\\],]", "") + "\n");
        }

        reader.close();
        writer.close();
    }
}
