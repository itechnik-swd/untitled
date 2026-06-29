package org.streams.util;

import java.util.List;

public class Book {
    String name;
    List<String> genres;

    public Book(String name, List<String> genres) {
        this.name = name;
        this.genres = genres;
    }

    public String getName() {
        return name;
    }

    public List<String> getGenres() {
        return genres;
    }
}
