package org.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsExample {
    public static void main(String[] args) {
//        List<?> list = new ArrayList<?>(); // ошибка
        List<?> list = new ArrayList<String>(); // ок


    }

    public static void printList(List<?> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }


    // PECS: from src to dest
    public static <T> void copy(List<? super T> dest, List<? extends T> src) {
        // реализация
    }

    void process(List<?> items) {
        for (Object item : items) {
            // можно читать
        }
        // items.add(...);  // нельзя: тип неизвестен, компилятор запретит
    }
}
