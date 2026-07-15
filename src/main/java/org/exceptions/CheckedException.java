package org.exceptions;

import java.io.IOException;

/**
 * <b>Ответ:</b> Нет, ошибка компиляции: "Unhandled exception type
 * IOException".<br>
 * <b>Ловушка:</b> IOException — это Checked исключение.
 * Его обязательно либо обернуть в try-catch (обработать), либо метод main
 * должен объявить throws IOException.
 */
public class CheckedException {
    public static void main(String[] args) throws IOException { // нужно добавить throws IOException
        risky(); // ошибка компиляции: "Unhandled exception type IOException".
    }

    public static void risky() throws IOException {
        throw new IOException("File not found");
    }
}
