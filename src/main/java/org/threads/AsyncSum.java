package org.threads;

import java.util.concurrent.CompletableFuture;

public class AsyncSum {
    public static void main(String[] args) throws Exception {
        // Первое асинхронное вычисление
        CompletableFuture<Integer> first = CompletableFuture.supplyAsync(() -> 10);

        // Второе асинхронное вычисление
        CompletableFuture<Integer> second = CompletableFuture.supplyAsync(() -> 25);

        // Объединяем оба фьючерса и обрабатываем результат
        CompletableFuture<Integer> sum = first.thenCombine(second, Integer::sum);

        // Блокирующий вызов для получения итогового значения (в реальном коде лучше избегать join/get)
        System.out.println("Сумма: " + sum.join());

    }
}
