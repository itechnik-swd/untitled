package org.algorithms;

/**
 * The type Prime digits square.
 */
// Реализовать метод.
// На вход строка, на выход - строка, полученная из простых цифр, возведённых
// в квадрат.
//
// Простым числом называют такое натуральное число, которое больше 1 и
// делится только на 1 и само на себя.
// Например, это числа 2, 3, 5, 7 и т. д.
//
// Например, String s = "gf89fghg3fh3" на выходе 99 в данном примере

public class PrimeDigitsSquare {
    public static void main(String[] args) {
        String s = "gf89fghg3fh3";
        String result = squarePrimeDigits(s);
        System.out.println(result); // Выведет: 99

        // Дополнительные тесты
        System.out.println(squarePrimeDigits("123456789")); // 49? (только 2,3,5,7)
        System.out.println(squarePrimeDigits("abc"));       // (пустая строка)
        System.out.println(squarePrimeDigits("2a3b5c7"));   // 49259? (4,9,25,49)
    }

    /**
     * Square prime digits string.
     *
     * @param input
     *         the input
     *
     * @return the string
     */
    public static String squarePrimeDigits(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                int digit = Character.getNumericValue(c);
                if (isPrime(digit)) {
                    int square = digit * digit;
                    result.append(square);
                }
            }
        }

        return result.toString();
    }

    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
