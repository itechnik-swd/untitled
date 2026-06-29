package org.streams.live_coding;

import java.util.Objects;

public class Book {
    private String title;
    private int pages;
    private int year;

    public Book(String title, int pages, int year) {
        this.title = title;
        this.pages = pages;
        this.year = year;
    }

    public int getPages() {
        return pages;
    }

    public int getYear() {
        return year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, pages, year);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;
        return pages == book.pages && year == book.year && Objects.equals(title, book.title);
    }

    @Override
    public String toString() {
        return "Book{title='" + title + "', pages=" + pages + "year" + "}";
    }
}
