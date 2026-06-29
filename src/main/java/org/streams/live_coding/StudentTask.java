package org.streams.live_coding;

import java.util.Comparator;
import java.util.List;

public class StudentTask {
    public static void main(String[] args) {
        // Подготовка данных
        List<Student> students = List.of(
                new Student("Ivan", List.of(
                        new Book("Java Core", 500, 2015),
                        new Book("Clean Code", 450, 2008),
                        new Book("Old History", 200, 1990),
                        new Book("Spring in Action", 600, 2020),
                        new Book("Clean Code", 450, 2008) // Дубликат
                )),
                new Student("Anna", List.of(
                        new Book("Effective Java", 400, 2017),
                        new Book("Hibernate", 350, 2019),
                        new Book("SQL", 150, 1999),
                        new Book("Algorithms", 800, 2011),
                        new Book("Design Patterns", 400, 2004)
                ))
        );
        /**
         1. При помощи одного (не допускается объявление никаких промежуточных переменных, совсем никаких) стрима
         1.1. Вывести в консоль каждого студента (переопределить toString())
         1.2. Получить для каждого студента список книг
         1.3. Получить книги
         1.4. Отсортировать книги по количеству страниц (не забывайте про условия для сравнения объектов).
         1.5. Оставить только уникальные книги
         1.6. Отфильтровать книги, оставив только те, которые были выпущены после 2000 года
         1.7. Ограничить стрим на 3 элемента
         1.8. Получить из книг годы их издания
         1.9. При помощи методов "короткого замыкания" вернуть Optional от даты издания
         1.10. При помощи методов получения значения из Optional вывести в консоль год издания либо запись о том, такая книга отсутствует.
         */
        students.stream()
                .peek(System.out::println) // 1.1.
                .map(Student::getBooks)
                .flatMap(List::stream) // List<Book>::stream; Collection::stream
                .sorted(Comparator.comparingInt(Book::getPages))
                .distinct() // 1.5.
                .filter(book -> book.getYear() > 2000) // 1.6
                .limit(3) // 1.7
                .map(Book::getYear)
                .findFirst().ifPresentOrElse(System.out::println, () -> System.out.println("Такая книга отсутствует"));

    }

}
