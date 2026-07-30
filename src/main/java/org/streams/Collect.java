package org.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Collect {
    public static void main(String[] args) {

        // Пример использования метода collect() для преобразования потока в список
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
        List<String> upperCaseNames = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(upperCaseNames); // Вывод: [ALICE, BOB, CHARLIE, DAVID]

        // Прием использования метода collect() для преобразования потока в массив
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        int[] squaredNumbers = numbers.stream()
                .mapToInt(n -> n * n)
                .toArray();

        System.out.println(Arrays.toString(squaredNumbers)); // Вывод: [1, 4, 9, 16, 25]
    }
}
