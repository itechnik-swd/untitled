package org.threads.pools;

// Реализовать простой пул потоков (thread pool), который может выполнять задачи, представленные в виде Runnable.
// Пул должен поддерживать фиксированное количество потоков и очередь задач.
// Задачи добавляются в пул методом submit, а потоки берут их из очереди и выполняют.
//
// Пример:
// Создать пул с 2 потоками.
// Добавить 5 задач, каждая из которых печатает свое имя и спит 1 секунду.
// Убедиться, что задачи выполняются параллельно, но не более 2 одновременно.
//
// Требования:
// Нельзя использовать ExecutorService.
// Обеспечить потокобезопасность.
// Добавить возможность завершения пула (shutdown).

import java.util.LinkedList;
import java.util.Queue;

public class SimpleThreadPool {

    private final Thread[] workers;
    private final Queue<Runnable> taskQueue;
    private final Object lock = new Object();
    private volatile boolean isShutdown;

    public SimpleThreadPool(int poolSize) {
        if (poolSize <= 0) {
            throw new IllegalArgumentException("Pool size must be positive");
        }

        this.workers = new Thread[poolSize];
        this.taskQueue = new LinkedList<>();
        this.isShutdown = false;

        // Запускаем рабочие потоки
        for (int i = 0; i < poolSize; i++) {
            workers[i] = new WorkerThread("Pool-Thread-" + (i + 1));
            workers[i].start();
        }
    }

    // Добавление задачи в пул
    public void submit(Runnable task) {
        if (task == null) {
            throw new NullPointerException("Task cannot be null");
        }

        synchronized (lock) {
            if (isShutdown) {
                throw new IllegalStateException("Thread pool is shutdown");
            }
            taskQueue.offer(task);
            lock.notify(); // Уведомляем ожидающий поток о новой задаче
        }
    }

    // Завершение работы пула
    public void shutdown() {
        synchronized (lock) {
            isShutdown = true;
            lock.notifyAll(); // Пробуждаем все ожидающие потоки
        }

        // Ожидаем завершения всех рабочих потоков
        for (Thread worker : workers) {
            try {
                worker.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    // Рабочий поток, который выполняет задачи
    private class WorkerThread extends Thread {
        public WorkerThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (true) {
                Runnable task = null;

                synchronized (lock) {
                    // Ожидаем появления задач, если очередь пуста и пул не завершен
                    while (taskQueue.isEmpty() && !isShutdown) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }

                    // Если пул завершен и задач больше нет - выходим
                    if (isShutdown && taskQueue.isEmpty()) {
                        return;
                    }

                    // Берем задачу из очереди
                    task = taskQueue.poll();
                }

                // Выполняем задачу вне синхронизированного блока
                if (task != null) {
                    try {
                        task.run();
                    } catch (Exception e) {
                        System.err.println("Error executing task: " + e.getMessage());
                    }
                }
            }
        }
    }

}
