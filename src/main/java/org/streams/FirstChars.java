package org.streams;

// Найти первые буквы всех слов, длина которых больше 3 символов, и вернуть их в
// верхнем регистре, без повторений и отсортированными

import java.util.List;

public class FirstChars {
    public static void main(String[] args) {
        List<String> words = List.of("cat", "elephant", "dog", "eagle", "fish", "emu", "antelope");

        words.stream()
                .filter(w -> w.length() > 3)
                .map(w -> w.substring(0, 1).toUpperCase())
                .distinct()
                .sorted()
                .forEach(System.out::println); // A, E, F
    }
}
