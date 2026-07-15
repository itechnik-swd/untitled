package org.example;

import java.util.Objects;

public class User {
    private Long id;
    private String name;

    // Конструктор, геттеры и сеттеры...

    @Override
    public int hashCode() {
        // Objects.hash(varargs...) вычисляет хэш-код для любого количества объектов,
        // корректно обрабатывая внутри себя null-значения
        return Objects.hash(id, name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;             // Проверка на идентичность ссылок
        if (!(o instanceof User))
            return false; // Проверка типа (современный вариант вместо instanceof с паттерном)

        User user = (User) o;

        // Objects.equals(a, b) возвращает:
        // - true, если оба аргумента null
        // - результат a.equals(b), если оба не null
        // - false, если один null, а другой нет
        return Objects.equals(id, user.id) &&
                Objects.equals(name, user.name);
    }
}
