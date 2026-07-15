package ru.compscicenter;

public class Exception {
    public static void main(String[] args) {
        try {
            test();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    static void test() throws MyException {
        throw new MyException(); // конструирование исключения с помощью new и сразу же его выбрасывание
    }

    static class MyException extends java.lang.Exception {
    }
}
