package org.streams;

import java.util.List;

public class Accumulator {
    public static void main(String[] args) {
        var numbers = List.of(1, 2, 3, 4, 5);
        // Сумма всех элементов списка с помощью reduce() и лямбда-выражения
        var sum = numbers.stream()
                .reduce(0, (subtotal, element) -> subtotal + element);
        // или используя Integer.sum(subtotal, element)
        // .reduce(0, Integer::sum);

        System.out.println(sum); // => Вывод чисел: 15

        // Максимальный из числовых значений в списке
        var numbers2 = List.of(1, 2, 3, 4, 5);
        // Начальное значение - первый элемент списка
        var maxNumber = numbers2.stream()
                .reduce(numbers2.get(0), (a, b) -> a > b ? a : b);

        System.out.printf("Max number is %d\n", maxNumber);

        var maxNumber2 = numbers2.stream().max(Integer::compareTo);
        maxNumber2.ifPresent(System.out::println);


        // Конкатенация символов в строку
        var letters = List.of("h", "e", "x", "l", "e", "t");
        var result = letters.stream()
                .reduce("", (res, element) -> res + element);
        // “” – начальное значение – пустая строка
        // .reduce("", String::concat);

        System.out.println(result); // hexlet

        // Подсчет общей стоимости товаров на складе с помощью Комбайнёр.
        var products = List.of("Laptop: 800", "Headphones: 50", "Smartphone: 500", "Mouse: 20");

        var totalPrice = products.stream()
                .reduce(0,
                        (summary, product) -> {
                            var parts = product.split(": ");
                            var price = Integer.parseInt(parts[1].trim());
                            return summary + price;
                        },
                        Integer::sum); // Комбайнёр

        System.out.println(totalPrice);
    }
}
