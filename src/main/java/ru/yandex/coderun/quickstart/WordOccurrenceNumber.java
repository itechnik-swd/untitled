package ru.yandex.coderun.quickstart;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 20. Номер появления слова
 */
public class WordOccurrenceNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
        Пример ввода и вывода числа n, где -10^9 < n < 10^9:
        int n = Integer.parseInt(reader.readLine());
        writer.write(String.valueOf(n));
        */

        Map<String, Integer> map = new HashMap<>();

        String line;
        while ((line = reader.readLine()) != null) {
            if (line.isEmpty()) {
                break;
            }

            String[] str = line.trim().toLowerCase().split("\\s+");

            for (String s : str) {
                int count = map.getOrDefault(s, 0);
                writer.write(count + " ");
                map.put(s, count + 1);
            }
        }

        reader.close();
        writer.close();
    }
}
