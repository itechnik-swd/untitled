package org.streams;

import java.util.Arrays;
import java.util.List;

public class LengthsString {
    public static void main(String[] args) {
        // Преобразование строк в их длины.
        List<String> strings = Arrays.asList("apple", "banana", "orange", "peach");

        strings.stream()
                .map(String::length)
                .forEach(System.out::println);
    }
}
