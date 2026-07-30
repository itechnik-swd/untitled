package org.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SolutionWithMinMax {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);

        Optional<Integer> optional = integers.stream()
                .filter(i -> i % 2 == 0)
                .min(Integer::compareTo);

        System.out.println(optional.orElse(null)); // Вывод: 2

        System.out.println("---------------------");

        List<Integer> emptyList = Arrays.asList(20, 1000, 30, -20, 2, 1000);

        Optional<Integer> min = emptyList.stream()
                .min(Integer::compareTo);

        if (min.isPresent()) {
            System.out.println("Минимальное значение: " + min.get());
        } else {
            System.out.println("Минимальное значение не найдено.");
        }

        Optional<Integer> max = emptyList.stream()
                .max(Integer::compareTo);

        if (max.isPresent()) {
            System.out.println("Максимальное значение: " + max.get());
        } else {
            System.out.println("Максимальное значение не найдено.");
        }
    }
}
