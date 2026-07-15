package org.threads;

/**
 * <b>Ответ:</b> Вы увидите "Main set running = false", но строка "Thread
 * stopped" не выведется — поток зависнет в бесконечном цикле.<p>
 * <b>Ловушка:</b> Без volatile нет гарантии видимости изменений между потоками.
 * JIT-компилятор может оптимизировать цикл, закешировав значение running в
 * регистре процессора для каждого ядра. Поток никогда не увидит, что переменная
 * стала false.<p>
 * <b>Решение:</b> Добавить static volatile boolean running = true; — тогда
 * изменение сразу будет видно всем потокам.
 */
class Flag {
    static boolean running = true; // БЕЗ volatile

    public static void main(String[] args) throws Exception {
        new Thread(() -> {
            while (Flag.running) {
            } // пустой цикл
            System.out.println("Thread stopped");
        }).start();

        Thread.sleep(1000);
        Flag.running = false;
        System.out.println("Main set running = false");
    }
}
