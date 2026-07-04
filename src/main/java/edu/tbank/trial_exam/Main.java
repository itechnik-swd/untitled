package edu.tbank.trial_exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    private static long[] a;
    // Мемоизация для ускорения рекурсии: Ключ — (индекс_монеты * смещение + остаток)
    // Так как остатки могут быть большими, используем Map для каждого уровня отдельно
    private static Map<Long, Long>[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        long x = Long.parseLong(tokenizer.nextToken());

        a = new long[n];
        tokenizer = new StringTokenizer(reader.readLine());

        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(tokenizer.nextToken());
        }

        // Инициализируем массив мап для мемоизации
        memo = new HashMap[n];

        for (int i = 0; i < n; i++) {
            memo[i] = new HashMap<>();
        }

        // Запускаем рекурсию с самого крупного номинала (индекс n - 1)
        System.out.println(solve(n - 1, x));
    }

    /**
     * @param idx
     *         индекс текущего номинала монеты
     * @param rem
     *         остаток суммы x, которую нужно "покрыть" на текущем и меньших
     *         уровнях
     *
     * @return минимальное суммарное количество монет для оплаты и сдачи
     */
    private static long solve(int idx, long rem) {
        // Базовый случай: дошли до самой мелкой монеты (а1 = 1)
        if (idx == 0) {
            // Так как а[0] = 1, нам нужно ровно rem монет для оплаты, а сдача будет 0 монет.
            // (Или наоборот, если rem отрицательный, но rem всегда >= 0 в нашей логике)
            return rem;
        }

        if (memo[idx].containsKey(rem)) {
            return memo[idx].get(rem);
        }

        long currentCoin = a[idx];

        // Вариант 1: Округляем вниз (берем k монет текущего номинала для оплаты)
        long k1 = rem / currentCoin;
        long rem1 = rem % currentCoin;
        long res1 = k1 + solve(idx - 1, rem1);

        // Вариант 2: Округляем вверх (берем k + 1 монет, создавая избыток, который пойдет в сдачу)
        long res2 = Long.MAX_VALUE;

        if (rem1 != 0) { // Имеет смысл округлять вверх, только если остаток не делится нацело
            long k2 = k1 + 1;
            long rem2 = currentCoin - rem1; // Этот избыток вернется сдачей на меньших номиналах
            res2 = k2 + solve(idx - 1, rem2);
        }

        long ans = Math.min(res1, res2);
        memo[idx].put(rem, ans);

        return ans;
    }
}
