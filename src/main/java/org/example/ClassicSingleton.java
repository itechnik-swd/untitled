package org.example;

public class ClassicSingleton {

    // volatile необходим для предотвращения чтения не до конца сконструированного объекта
    private static volatile ClassicSingleton instance = null;

    // Приватный конструктор блокирует создание извне
    private ClassicSingleton() {
        // Защита от рефлексии: выбросить исключение, если экземпляр уже создан
        if (instance != null) {
            throw new IllegalStateException("Already instantiated.");
        }
    }

    public static ClassicSingleton getInstance() {
        if (instance == null) { // Первая проверка (без синхронизации)
            synchronized (ClassicSingleton.class) {
                if (instance == null) { // Вторая проверка (под блокировкой)
                    instance = new ClassicSingleton();
                }
            }
        }
        return instance;
    }
}
