package org.streams;

import org.util.Payment;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//Задача 1. Агрегация платежей:
//Есть список платежей:
//Пример:
//        [
//        ("A1", 100),
//        ("A2", 50),
//        ("A1", 200),
//        ("A2", 150),
//        ("A3", 300)
//        ]
//Нужно получить:
//        {
//        "A1" -> 300,
//        "A2" -> 200,
//        "A3" -> 300
//        }

public class PaymentGrouping {
    public static void main(String[] args) {
        List<Payment> payments = List.of(
                new Payment("A1", new BigDecimal("100")),
                new Payment("A2", new BigDecimal("50")),
                new Payment("A1", new BigDecimal("200")),
                new Payment("A2", new BigDecimal("150")),
                new Payment("A3", new BigDecimal("300"))
        );

        Map<String, BigDecimal> result = payments.stream()
                .collect(Collectors.groupingBy(
                        Payment::getAccount,
                        Collectors.reducing(BigDecimal.ZERO,
                                Payment::getAmount,
                                BigDecimal::add)));

        System.out.println("Результат с Collectors.reducing()");
        System.out.println(result); // {A1=300, A2=200, A3=300}

        for (Map.Entry<String, BigDecimal> entry : result.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("Выводим результат через forEach");
        result.forEach((key, value) -> System.out.println(key + " -> " + value));
//==============================================================================
        var result2 = payments.stream()
                .collect(Collectors.groupingBy(
                        Payment::getAccount,
                        Collectors.mapping(
                                Payment::getAmount,
                                Collectors.reducing(
                                        BigDecimal.ZERO,
                                        BigDecimal::add))
                ));

        System.out.println("\nРезультат с Collectors.mapping()");
        System.out.println(result2);
//==============================================================================
        var result3 = payments.stream()
                .collect(Collectors.toMap(
                        Payment::getAccount,
                        Payment::getAmount,
                        BigDecimal::add));

        System.out.println("\nРезультат с Collectors.toMap()");
        result3.forEach((k, v) -> System.out.println(k + " -> " + v));

        byte b = 1;
//        b = b + 1;
        b++;
        b = (byte) (b + 1);
        b += 1; // составное присваивание
    }
}
