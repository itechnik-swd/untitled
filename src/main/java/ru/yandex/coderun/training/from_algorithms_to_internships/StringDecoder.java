package ru.yandex.coderun.training.from_algorithms_to_internships;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * <b>Задача:</b> "Раскодируй строку"<p>
 * Буквы с "а" по "i" кодируются числами от 1 до 9, буквы с "j" по "z" - от 10#
 * до 26#.<br> Нужно раскодировать строку.<br>
 * <b>Например:</b> "8512#12#15#" -> "hello"
 */
public class StringDecoder {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

            String input = reader.readLine();

            for (int i = 0; i < input.length(); i++) {
                if (i + 2 < input.length() && input.charAt(i + 2) == '#') {
                    int code = Integer.parseInt(input.substring(i, i + 2));
                    writer.write((char) (code + 'a' - 1)); // Таблица кодировки символов ASCII ('a' - 97)
                    i += 2;
                } else {
                    int code = Integer.parseInt(String.valueOf(input.charAt(i)));
                    writer.write((char) (code + 'a' - 1));
                }
            }
        }
    }
}
