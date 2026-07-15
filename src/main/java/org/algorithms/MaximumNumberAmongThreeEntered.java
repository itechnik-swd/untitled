package org.algorithms;

import java.util.Scanner;

/**
 * Давай решим простую задачу: напишем метод, который находит максимальное число
 * среди трех введенных.
 */
public class MaximumNumberAmongThreeEntered {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите первое число:");
        int num1 = scanner.nextInt();

        System.out.println("Второе число:");
        int num2 = scanner.nextInt();

        System.out.println("Третье число:");
        int num3 = scanner.nextInt();

        int max = Math.max(num1, Math.max(num2, num3));
        System.out.print("Максимальное число: " + max);
    }
}
