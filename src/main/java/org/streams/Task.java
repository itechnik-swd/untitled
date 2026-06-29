package org.streams;

import org.util.User;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task {
    public static void main(String[] args) {
        System.out.println("Группировка элементов списка");
        List<String> list = Arrays.asList("a", "bb", "ccc", "dd", "eee");
        Map<Integer, List<String>> result = list.stream()
                .collect(Collectors.groupingBy(String::length));

        System.out.println(result); // Результат {1=[a], 2=[bb, dd], 3=[ccc, eee]}
        result.forEach((key, value) -> System.out.println(key + ": " + value));
        System.out.println("-------------------------------------------------");
//==============================================================================
        System.out.println("Отсортируйте список строк по длине, по возрастанию.");
        List<String> items = List.of("pear", "banana", "apple", "orange");

        var res = items.stream()
                // Comparator.naturalOrder()
                //.thenComparing()
                //.compare()
                //.compareTo()
                .sorted(Comparator.comparingInt(String::length))
                .toList();

        System.out.println(res);
        System.out.println("-------------------------------------------------");
//==============================================================================
        System.out.println("Отсортируйте список строк по длине, *по убыванию*.");
        List<String> items2 = List.of("pear", "banana", "apple", "kiwi");

        var res2 = items2.stream()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .toList();

        System.out.println(res2);
        System.out.println("-------------------------------------------------");
//==============================================================================
        System.out.println("Подсчитайте, сколько раз каждое слово встречается в списке.");
        List<String> words = List.of("apple", "banana", "apple", "orange", "banana", "apple");
        Map<String, Long> wordCount = words.stream()
                // .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
                .collect(Collectors.groupingBy(key -> key, Collectors.counting()));

        System.out.println(wordCount);
        System.out.println("-------------------------------------------------");
//==============================================================================
        System.out.println("Есть список пользователей. Разделите их по возрасту.");
        // record User(String name, int age) {}
        List<User> users = List.of(
                new User("Alice", 30),
                new User("Bob", 25),
                new User("Charlie", 30),
                new User("David", 25)
        );

        System.out.println("Группировка по возрасту со списком имён:");
        Map<Integer, List<String>> groupedNames = users.stream()
                .collect(Collectors.groupingBy(
                        User::age,
                        Collectors.mapping(
                                User::name,
                                Collectors.toList())));

        System.out.println(groupedNames);
        groupedNames.forEach((k, v) -> System.out.println(k + ": " + v));

        System.out.println("Группировка по возрасту со списком Users:");
        Map<Integer, List<User>> groupedUsers = users.stream()
                .collect(Collectors.groupingBy(User::age));

        System.out.println("Через цикл for");
        for (var entry : groupedUsers.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("Через forEach");
        groupedUsers.forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println("-------------------------------------------------");
//==============================================================================
        System.out.println("Найдите второе по величине число в списке.");
        int[] ints = {5, 3, 9, 1, 9, 7}; // {1, 3, 5, 7, 9, 9} -> 7
        System.out.println("Через алгоритм:");
        System.out.println(getSecondMaxElement(ints));

        System.out.println("Через stream:");
        List<Integer> numbers = Arrays.asList(5, 3, 9, 3, 1, 9, 7);

        var secondMaxValue = numbers.stream()
                .distinct() // 5, 3, 9, 1, 7
                .sorted(Comparator.reverseOrder()) // 9, 7, 5, 3, 1
                // Под капотом в sorted(Comparator.naturalOrder()).
                .skip(1) // 7, 5, 3, 1
                .findFirst(); // 7

        secondMaxValue.ifPresent(System.out::println);
        System.out.println("-------------------------------------------------");
//==============================================================================
        System.out.println("Есть список имён. Определите, есть ли имя, начинающееся с буквы A.");
        List<String> names = List.of("Bob", "Charlie", "Alice", "David");

        var hasNameStartingWithA = names.stream()
                .anyMatch(name -> name.startsWith("A"));

        // anyMatch() -> хотя бы 1 соответствует;
        // noneMatch() -> никто (ни один) не соответствует;
        // allMatch() -> соответствуют все.
        System.out.println(hasNameStartingWithA);
        System.out.println("-------------------------------------------------");
//==============================================================================
        // Из списка чисел оставить только квадраты нечётных чисел.
        // Список чисел перевести в квадраты только нечётных чисел.
        List<Integer> integerList = List.of(1, 2, 3, 4, 5);

        var oddSquares = integerList.stream()
                .filter(n -> n % 2 != 0)
                .map(x -> x * x)
                .toList();

        System.out.println(oddSquares);
        System.out.println("-------------------------------------------------");
//==============================================================================
        // Получить второго по длине имени пользователя (уникального)
        List<String> namesList = List.of("Anna", "Bob", "Catherine", "Daniel", "Anna", "Eve");

        var secondMaxLengthName = namesList.stream()
                .distinct() // "Anna", "Bob", "Catherine", "Daniel", "Eve"
                .sorted(Comparator.comparingInt(String::length).reversed())
                // "Catherine", "Daniel", "Anna", "Bob", "Eve"
                .skip(1) // пропускаем первый элемент и берём второй
                .findFirst(); // "Daniel"

        System.out.println(secondMaxLengthName);
        secondMaxLengthName.ifPresent(System.out::println);
        System.out.println("-------------------------------------------------");
    }

    // Алгоритм
    public static int getSecondMaxElement(int[] arr) {
        int maxValue = Integer.MIN_VALUE; // не array[0]
        int result = maxValue;

        for (int v : arr) {
            if (v > maxValue) {
                result = maxValue; //
                maxValue = v; // новое максимальное значение
            } else if (v > result) {
                result = v;
            }
        }

        return result;
    }
}
