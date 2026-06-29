package org.streams.util;

import java.util.List;

public class Reader {
    String name;
    List<Book> books;

    public Reader(String name, List<Book> books) {
        this.name = name;
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }
}
