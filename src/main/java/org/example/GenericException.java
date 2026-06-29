package org.example;

public class GenericException<T extends Exception> {
    public void throwException() throws T { // Ошибка компиляции
        // ...
    }
}