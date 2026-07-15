package org.algorithms;

import java.util.Scanner;

public class AmountFinding {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите первое число:");
        int num1 = scanner.nextInt();

        System.out.println("Второе число:");
        int num2 = scanner.nextInt();

        System.out.println("Третье число:");
        int num3 = scanner.nextInt();

        int result = num1 + num2 + num3;
        System.out.print("Сумма чисел: " + result);
    }
}
