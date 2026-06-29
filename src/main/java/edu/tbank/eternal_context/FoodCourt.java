package edu.tbank.eternal_context;

import java.util.Arrays;
import java.util.Scanner;

public class FoodCourt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] costs = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            costs[i] = scanner.nextInt();
        }

        final int INF = Integer.MAX_VALUE / 2;
        int[][] dp = new int[n + 1][n + 2];
        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }
        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            int cost = costs[i];
            boolean givesCoupon = cost > 100;

            for (int j = 0; j <= i; j++) {
                // Оплата деньгами
                int buyCost = dp[i - 1][givesCoupon ? Math.max(0, j - 1) : j] + cost;
                dp[i][j] = buyCost;

                // Использование купона
                if (j > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j + 1]);
                }
            }
        }

        int minCost = Arrays.stream(dp[n]).min().orElse(INF);
        System.out.println(minCost);
    }
}
