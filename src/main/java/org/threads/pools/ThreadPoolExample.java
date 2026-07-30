package org.threads.pools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
    public static void main(String[] args) {
        // Создаём пул из 3 потоков
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 0; i <= 10; i++) {
            final int taskId = i;
            executor.submit(() -> {
                System.out.println("Task " + taskId + " выполняется в потоке: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000); // Имитация работы
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        // Корректно завершаем работу пула
        executor.shutdown();
        // Если нужно ждать завершения всех задач:
        // try { executor.awaitTermination(60, TimeUnit.SECONDS); } catch (InterruptedException e) {}
    }
}
