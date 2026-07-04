package ru.yandex.coderun.quickstart;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 15. Определить вид последовательности
 */
public class TypeOfSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        long number = Long.parseLong(reader.readLine());
        long nextNumber = Long.parseLong(reader.readLine());

        // Флаги для определения типа последовательности
        boolean isConstant = true;
        boolean isAscending = true;
        boolean isWeaklyAscending = true;
        boolean isDescending = true;
        boolean isWeaklyDescending = true;

        while (nextNumber != -2000000000L) {
            // Проверка для CONSTANT
            if (number != nextNumber) {
                isConstant = false;
            }

            // Проверка для ASCENDING (строго возрастающая)
            if (number >= nextNumber) {
                isAscending = false;
            }

            // Проверка для WEAKLY ASCENDING (нестрого возрастающая)
            if (number > nextNumber) {
                isWeaklyAscending = false;
            }

            // Проверка для DESCENDING (строго убывающая)
            if (number <= nextNumber) {
                isDescending = false;
            }

            // Проверка для WEAKLY DESCENDING (нестрого убывающая)
            if (number < nextNumber) {
                isWeaklyDescending = false;
            }

            number = nextNumber;
            nextNumber = Long.parseLong(reader.readLine());
        }

        String type = "RANDOM";
        // Определение типа последовательности
        if (isConstant) {
            type = "CONSTANT";
        } else if (isAscending) {
            type = "ASCENDING";
        } else if (isWeaklyAscending) {
            type = "WEAKLY ASCENDING";
        } else if (isDescending) {
            type = "DESCENDING";
        } else if (isWeaklyDescending) {
            type = "WEAKLY DESCENDING";
        }

        writer.write(type);

        reader.close();
        writer.close();
    }
}
