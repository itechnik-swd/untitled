package org.threads;

/**
 * <b>Ответ:</b> Выведет "Condition met!" (всё работает корректно).<br>
 * <b>Ловушка:</b> Здесь нет ловушки, это правильный паттерн!<br>
 * Важно запомнить для тестов: wait() всегда должен быть в цикле while
 * (!условие), потому что поток может проснуться ложным образом (spurious
 * wakeup).<br> Если бы было if (!condition) lock.wait(); — это была бы ошибка.
 */
public class Example {
    static final Object lock = new Object();
    static boolean condition = false;

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                while (!condition) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Condition met!");
            }
        });

        t1.start();
        Thread.sleep(100);

        synchronized (lock) {
            condition = true;
            lock.notifyAll();
        }
    }
}
