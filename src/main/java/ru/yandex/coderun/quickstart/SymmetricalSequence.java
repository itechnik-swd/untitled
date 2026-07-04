package ru.yandex.coderun.quickstart;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 13. Симметричная последовательность
 */
public class SymmetricalSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int[] input = readArray(reader, n);

        // Ищем индекс начала самого длинного симметричного суффикса
        int suffixStart = 0;
        for (int i = 0; i < n; i++) {
            if (isPalindrome(input, i, n - 1)) {
                suffixStart = i;
                break;
            }
        }

        int countToAppend = suffixStart;
        writer.write(countToAppend + "\n");

        if (countToAppend > 0) {
            for (int i = suffixStart - 1; i >= 0; i--) {
                writer.write(String.valueOf(input[i]));
                if (i > 0) {
                    writer.write(" ");
                }
            }
        }

        reader.close();
        writer.close();
    }

    private static int[] readArray(BufferedReader reader, int n) throws IOException {
        String[] input = reader.readLine().split(" ");
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }
        return numbers;
    }

    private static boolean isPalindrome(int[] arr, int l, int r) {
        while (l < r) {
            if (arr[l] != arr[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
