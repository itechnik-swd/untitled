package org.streams;

// Задача 2: Необходимо оставить только самый свежий ордер
// В системе иногда появляются дубли по orderId.
// Пример:
//        1, 10:00
//        2, 11:00
//        1, 12:00
//        3, 13:00
// Вывести результат:
//        1, 12:00
//        2, 11:00
//        3, 13:00

import org.util.Order;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class Exercise3 {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order("1", LocalTime.of(10, 0)),
                new Order("2", LocalTime.of(11, 0)),
                new Order("1", LocalTime.of(12, 0)),
                new Order("3", LocalTime.of(13, 0))
        );

        // Группируем по orderId и выбираем самый свежий заказ из каждой группы
        List<Order> result = orders.stream()
                .collect(Collectors.groupingBy(Order::getOrderId))
                .values().stream()
                .map(group -> group.stream()
                        .max(Comparator.comparing(Order::getCreatedAt))
                        .orElse(null))
                .filter(Objects::nonNull)
                .toList();

        // Выводим результат
        result.forEach(o ->
                System.out.println(o.getOrderId() + ", " + o.getCreatedAt()));

        System.out.println();

        // Вариант 1 (уже рабочий, но можно упростить):
        List<Order> result1 = orders.stream()
                .collect(Collectors.groupingBy(
                        Order::getOrderId,
                        Collectors.maxBy(Comparator.comparing(Order::getCreatedAt))))
                .values().stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();

        // Выводим результат1
        result1.forEach(o ->
                System.out.println(o.getOrderId() + ", " + o.getCreatedAt()));
//==============================================================================
        // Вариант 2 (альтернативный, корректный):
        Map<String, Order> result2 = orders.stream()
                .collect(Collectors.toMap(
                        Order::getOrderId,                // ключ
                        order -> order,            // значение
                        (existing, replacement) ->
                                // merge function: оставляем более свежий
                                existing.getCreatedAt().isAfter(replacement.getCreatedAt()) ? existing : replacement
                ));

        List<Order> res = new ArrayList<>(result2.values());
        res.forEach(o -> System.out.println("result2: " + o.getOrderId() + ", " + o.getCreatedAt()));

        /*
        Map<String, Order> result = orders.stream()
                .collect(Collectors.groupingBy(
                        Order::orderId,
                        Collectors.maxBy((a, b) -> a.getCreatedAt() > b.getCreatedAt() ? a : b));

        List<Order> res = result.values();
         */
    }
}
