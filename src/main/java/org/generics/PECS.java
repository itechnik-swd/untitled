package org.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>Ответ:</b> Скомпилируется только Вариант B. Вариант A выдаст ошибку
 * компиляции.<br>
 * <b>Ловушка:</b> List<? extends Number> означает: "Список неизвестного типа,
 * который является наследником Number".
 * Мы не знаем точно, какой это тип (Integer, Double...), поэтому нельзя ничего
 * добавлять (кроме null), потому что это нарушит типобезопасность. А вот читать
 * можно — все элементы гарантированно будут Number.<p>
 * <b>Правило PECS:</b> Producer Extends, Consumer Super (если читаешь —
 * extends, если кладешь — super).
 */
public class PECS {
    public static void main(String[] args) {
        List<? extends Number> numbers = new ArrayList<>();

        // Вариант A:
        //numbers.add(10);

        // Вариант B:
        Number n = numbers.get(0);
    }
}
