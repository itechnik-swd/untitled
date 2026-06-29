package org.streams;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) {
        System.out.println("Есть список слов. Объедините их в одну строку, разделяя запятыми.");
        List<String> words = List.of("Java", "Stream", "API");

        var str1 = words.stream()
                .collect(Collectors.joining(", "));

        System.out.println(str1);

        var str2 = String.join(", ", words);
        System.out.println(str2);
//==============================================================================
        System.out.println("\nНайти все уникальные символы, которые встречаются в списке слов.");
        List<String> words2 = List.of("hello", "world");

        Set<Character> uniqueChars = words2.stream()
                // Преобразуем строки к потоку символов (int)
                .flatMapToInt(String::chars)
                // Удаляем дубликаты с помощью distinct()
                .distinct()
                // Преобразуем int в char
                .mapToObj(c -> (char) c)
                // Собираем Stream<Characters> в коллекцию Set<Characters>
                .collect(Collectors.toSet());

        System.out.println(uniqueChars);
    }
}
