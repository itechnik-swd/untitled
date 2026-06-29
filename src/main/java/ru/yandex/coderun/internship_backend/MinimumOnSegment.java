package ru.yandex.coderun.internship_backend;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 3. Минимум на отрезке
 */
public class MinimumOnSegment {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = reader.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);

        int[] numbers = new int[n];
        String[] inputNumbers = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(inputNumbers[i]);
        }

        Deque<Integer> deque = new ArrayDeque<>(); // хранит индексы кандидатов в минимумы

        for (int i = 0; i < n; i++) {
            // 1. Удаляем элементы из конца, если они >= текущего
            while (!deque.isEmpty() && numbers[deque.peekLast()] >= numbers[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);

            // 2. Удаляем элементы из начала, если индекс вышел за окно
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // 3. Записываем минимум для окна, когда достигли размера k
            if (i >= k - 1) {
                writer.write(numbers[deque.peekFirst()] + "\n");
            }
        }

        reader.close();
        writer.close();
    }
}
