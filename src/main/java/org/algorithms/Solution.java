package org.algorithms;

// Вы поднимаетесь по лестнице. Чтобы достичь вершины, нужно преодолеть n ступенек.
// За один шаг вы можете подняться либо на 1 ступеньку, либо на 2 ступеньки.
// Напишите реализацию метода, который возвращает количество различных способов подняться на вершину лестницы.
// Примеры
// n = 1
// Ответ: 1
// Объяснение: Только один способ: [1]
//
// n = 2
// Ответ: 2
// Объяснение: Два способа: [1,1] и [2]
//
// n = 3
// Ответ: 3
// Объяснение: Три способа: [1,1,1], [1,2], [2,1]
//
// n = 4
// Ответ: 5
// Объяснение: [1,1,1,1], [1,1,2], [1,2,1], [2,1,1], [2,2]

public class Solution {
    public static void main(String[] args) {
        System.out.println(climbStairs(1)); // ? 1
        System.out.println(climbStairs(2)); // ? 2
        System.out.println(climbStairs(3)); // ? 3
        System.out.println(climbStairs(4)); // ? 5
        System.out.println(climbStairs(5)); // ? 8
        System.out.println();
        System.out.println(climbStairsDP(1));
        System.out.println(climbStairsDP(2));
        System.out.println(climbStairsDP(3));
        System.out.println(climbStairsDP(4));
        System.out.println(climbStairsDP(5));

    }

    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[n];
    }

    // Динамическое программирование: Используем массив для хранения уже
    // вычисленных значений, избегая повторных вычислений.
    public static int climbStairsDP(int n) {
        if (n <= 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1; // 1 способ оказаться на 0 ступеньке
        dp[1] = 1; // 1 способ оказаться на 1 ступеньке

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
