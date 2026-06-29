package org.streams;

// Есть список читателей. Каждый читатель читает несколько книг.
// Каждая книга относится к одному или нескольким жанрам (например, "Фантастика", "Драма").
// Нужно:
// 1. Найти всех читателей, которые читают книгу с названием "Гарри Поттер".
// 2. Из этих читателей собрать список уникальных жанров всех прочитанных ими книг.

import org.streams.util.Book;
import org.streams.util.Reader;

import java.util.Collection;
import java.util.List;

public class ReadersList {
    public static void main(String[] args) {
        List<Reader> readers = List.of(
                new Reader("Анна", List.of(
                        new Book("Война и мир", List.of("Драма", "История")),
                        new Book("Гарри Поттер", List.of("Фантастика", "Приключения")),
                        new Book("Преступление и наказание", List.of("Драма", "Классика"))
                )),
                new Reader("Борис", List.of(
                        new Book("Гарри Поттер", List.of("Фантастика", "Приключения")),
                        new Book("Мастер и Маргарита", List.of("Фантастика", "Философия"))
                )),
                new Reader("Виктория", List.of(
                        new Book("1984", List.of("Антиутопия", "Политика")),
                        new Book("Преступление и наказание", List.of("Драма", "Классика"))
                ))
        );

        var garriPotterReaders = readers.stream()
                .filter(r -> r.getBooks().stream()
                        .anyMatch(b -> b.getName().equals("Гарри Поттер")))
                .toList();

        System.out.println("Читатели Гарри Поттера:");
        garriPotterReaders.stream()
                .map(Reader::getName)
                .forEach(System.out::println);

        // 2. Из этих читателей собрать список уникальных жанров всех прочитанных ими книг.
        var uniqueGenres = garriPotterReaders.stream()
                .flatMap(reader -> reader.getBooks().stream()
                        .map(Book::getGenres))
                .flatMap(Collection::stream)
                .distinct()
                .toList();

        System.out.println("\nУникальные жанры:");
        System.out.println(uniqueGenres);
    }
}
