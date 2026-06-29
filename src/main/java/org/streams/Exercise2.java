package org.streams;

import org.util.Order;

import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

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

public class Exercise2 {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order("1", LocalTime.of(10, 0)),
                new Order("2", LocalTime.of(11, 0)),
                new Order("1", LocalTime.of(12, 0)),
                new Order("3", LocalTime.of(13, 0))
        );

        // Group by orderId and keep only the most recent order
        List<Order> result = orders.stream()
                .collect(Collectors.groupingBy(
                        Order::getOrderId,
                        Collectors.maxBy(Comparator.comparing(Order::getCreatedAt))
                ))
                .values().stream()
                .filter(java.util.Optional::isPresent)
                .map(java.util.Optional::get)
                .sorted(Comparator.comparing(Order::getOrderId))
                .toList();

        // Print the result
        result.forEach(order ->
                System.out.println(order.getOrderId() + ", " + order.getCreatedAt())
        );

        System.out.println("Using TreeMap:");

        // Keep only the most recent order for each orderId
        TreeMap<String, Order> uniqueOrders = new TreeMap<>();
        for (Order order : orders) {
            uniqueOrders.merge(order.getOrderId(), order,
                    (existing, newer) ->
                            newer.getCreatedAt().isAfter(existing.getCreatedAt()) ? newer : existing);
        }

        // Print the result
        uniqueOrders.values().forEach(order ->
                System.out.println(order.getOrderId() + ", " + order.getCreatedAt())
        );
    }
}
