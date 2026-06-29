package org.algorithms;

import java.util.List;
import java.util.logging.Logger;

public class Prefix {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Prefix.class.getName());
        // Найти общий префикс в списке строк.
        List<String> listOfWords = List.of("стол", "стул", "столб", "стык");

        logger.info(commonPrefix(listOfWords));
    }

    private static String commonPrefix(List<String> words) {
        // Проверки на граничные случаи
        if (words == null || words.isEmpty()) {
            return "";
        }

        // Найти минимальную длину строки
        int minLength = words.stream()
                .mapToInt(String::length)
                .min()
                .orElse(0);

        // Проверить наличие пустой строки
        if (minLength == 0) {
            return "";
        }

        // Перебирать каждый символ на позиции
        for (int position = 0; position < minLength; position++) {
            char currentChar = words.get(0).charAt(position);

            // Проверить, совпадает ли символ на этой позиции во всех словах
            for (int i = 1; i < words.size(); i++) {
                if (words.get(i).charAt(position) != currentChar) {
                    // Если не совпадает, вернуть префикс до этой позиции
                    return words.get(0).substring(0, position);
                }
            }
        }

        // Если все символы совпали до minLength, вернуть минимальную строку целиком
        return words.get(0).substring(0, minLength);
    }
}
