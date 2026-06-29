package ru.yandex.coderun.quickstart;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 4. Выставление тегов
 */
public class SettingTags {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        int result = 0;
        for (int i = 1; i <= n; i++) {
            result += fib(i);
        }

        writer.write(String.valueOf(result));

        reader.close();
        writer.close();
    }

    private static int fib(int i) {
        if (i == 1 || i == 2) return 1;
        return fib(i - 1) + fib(i - 2);
    }
}
