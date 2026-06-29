package org.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// Превратить List<List<String>> приходящий на вход в строку, где каждый элемент разделён запятой и пробелом.
// Пример: [[a, b, c], [d, e, f], [g, h, i]] -> {a, b, c, d, e, f, g, h, i}

public class Convertor {
    public static void main(String[] args) {
        List<List<String>> list = Arrays.asList(
                Arrays.asList("a", "b", "c"),
                Arrays.asList("d", "e", "f"),
                Arrays.asList("g", "h", "i")
        );

        list.forEach(System.out::println);

        System.out.println(convertToString(list));
    }

    public static String convertToString(List<List<String>> list) {
        return list.stream()
                .flatMap(List::stream) // Stream<String>
                .collect(Collectors.joining(", ", "{", "}"));
    }
}
