package ru.yandex.coderun.quickstart;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * 7. Количество слов в тексте
 */
public class WordsInTextNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
        Пример ввода и вывода числа n, где -10^9 < n < 10^9:
        int n = Integer.parseInt(reader.readLine());
        writer.write(String.valueOf(n));
        */
        long count = reader.lines()
                // Убираем takeWhile, если нужно читать до конца потока (EOF)
                // .takeWhile(l -> !l.isBlank()) // <- если всё же нужно остановиться на пустой строке
                .flatMap(l -> Arrays.stream(l.trim().split("\\s+")))
                .filter(s -> !s.isEmpty()) // Отсеиваем слова, которые состояли только из знаков препинания
                .distinct()
                .count();

        writer.write(String.valueOf(count));

        reader.close();
        writer.close();
    }
}
