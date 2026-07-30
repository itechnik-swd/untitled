package org.threads.pools;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Реализовать простой пул потоков (thread pool), который может выполнять
 * задачи, представленные в виде Runnable.<br> Пул должен поддерживать
 * фиксированное количество потоков и очередь задач. Задачи добавляются в пул
 * методом submit(), а потоки берут их из очереди и выполняют.<p> Пример:
 * Создать пул с 2 потоками. Добавить 5 задач, каждая из которых печатает свое
 * имя и спит 1 секунду. Убедиться, что задачи выполняются параллельно, но не
 * более 2 одновременно.<p> Требования: Нельзя использовать ExecutorService.
 * Обеспечить потокобезопасность. Добавить возможность завершения пула
 * (shutdown).
 */
public class MyThreadPool {
    // поля
    private final BlockingQueue<Runnable> taskQueue;
    private volatile boolean isShutdown;

    // конструктор
    public MyThreadPool(int poolSize) {
        this.taskQueue = new LinkedBlockingQueue<>();
        Thread[] workers = new Worker[poolSize];

        for (int i = 0; i < poolSize; i++) {
            workers[i] = new Worker();
            workers[i].start();
        }
    }

    // submit()
    public void submit(Runnable task) {
        if (!isShutdown) {
            taskQueue.offer(task);
        }
    }

    // shutdown()
    public void shatdown() {
        isShutdown = true;
    }

    private class Worker extends Thread {
        @Override
        public void run() {
            while (!isShutdown || !taskQueue.isEmpty()) {
                Runnable task = null;
                try {
                    task = taskQueue.take();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                task.run();
            }
        }
    }
}
