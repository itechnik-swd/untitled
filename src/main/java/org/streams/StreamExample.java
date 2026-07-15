package org.streams;

import org.util.User;

import java.util.List;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        // class User(name, age)
        var users = List.of(
                new User("Alice", 22),
                new User("Bob", 17),
                new User("Charlie", 24),
                new User("Diana", 16)
        );

        var names = users.stream() // создаём стрим
                .filter(user -> user.age() > 18) // Фильтрация пользователей
                // старше 18 лет
                .map(User::name) // Преобразование User в String (имя пользователя)
                .sorted() // Сортировка имён в алфавитном порядке
                .toList(); // Сбор результата в список
        // или вместо toList() закончить методом forEach(System.out::println)
        names.forEach(System.out::println); // Вывод имён

        String cake = "\uD83C\uDF70";
        System.out.println(cake);

        // Поток уже был использован, повторное терминальное действие вызывает исключение.
        // IllegalStateException: stream has already been operated upon or closed
        Stream<Integer> stream = Stream.of(1, 2, 3, 4);
//        long count = stream.filter(i -> i > 2).count();
        stream.forEach(System.out::print);
    }
}
