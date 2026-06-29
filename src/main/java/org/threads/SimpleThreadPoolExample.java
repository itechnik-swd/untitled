package org.threads;

public class SimpleThreadPoolExample {
    public static void main(String[] args) {
        // Создаем пул с 2 потоками
        SimpleThreadPool threadPool = new SimpleThreadPool(2);

        // Добавляем 5 задач
        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            threadPool.submit(() -> {
                System.out.println("Задача " + taskId + " выполняется в потоке "
                        + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000); // Имитируем длительную работу
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Задача " + taskId + " завершена");
            });
        }

        // Ждем некоторое время, чтобы все задачи выполнились
        // В реальном коде можно использовать shutdown() и join()
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Завершаем работу пула
        threadPool.shutdown();
        System.out.println("Пул потоков завершил работу");
    }
}
