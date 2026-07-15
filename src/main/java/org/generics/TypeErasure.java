package org.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>Ответ:</b> true<br>
 * <b>Ловушка:</b> В Java дженерики существуют только на этапе компиляции.<br>
 * Во время выполнения (Runtime) информация о типе стирается.<br> И list1, и
 * list2 в байт-коде — это просто ArrayList. Их классы идентичны, поэтому
 * сравнение дает true.
 */
public class TypeErasure {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        System.out.println(list1.getClass() == list2.getClass());
    }
}
