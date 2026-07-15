package org.exceptions;

/**
 * <b>Ответ:</b> Да, скомпилируется и выполнится, выбросив исключение.<br>
 * <b>Ловушка:</b> RuntimeException и его наследники — это Unchecked
 * исключения.<br>
 * Компилятор не требует их обрабатывать или объявлять в throws. Многие путают и
 * думают, что раз метод объявил throws, то обязательно нужен try-catch. Это
 * обязательно только для Exception (кроме RuntimeException).
 */
public class CheckedUnchecked {
    public static void main(String[] args) {
        risky(); // нет try-catch
    }

    public static void risky() throws RuntimeException {
        throw new RuntimeException("Boom!");
    }
}
