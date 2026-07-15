package ru.yandex.coderun.training.from_algorithms_to_internships;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * <b>Задача:</b> "Олигополия"<p>
 * У каждой компании есть начальный капитал.<br> Компания может поглотить
 * компанию с меньшим капиталом и забрать её капитал себе.<br> Побеждает
 * единственная оставшаяся компания. Определить, кто может победить.<br> Размер
 * компаний даётся в порядке неубывания.<br>
 * <b>Пример:</b> 1 2 3 -> 3
 * <p>
 * В игре «Олигополия» <i>N</i> компаний. Для каждой компании известна её
 * капитализация: для i-й компании она равна a_i бурлей. Компания <i>i</i> может
 * поглотить компанию <i>j</i>, если a_i строго больше a_j; после этого компания
 * j исчезает, а капитал компании i становится равен a_i + a_j. Поглощения могут
 * происходить в произвольном порядке. Побеждает компания, которая смогла
 * поглотить все остальные.
 * <p>
 * Вам даны стартовые капиталы компаний. Определите, какие из них, теоретически,
 * могут стать победителями.
 */
public class Oligopoly {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        int[] comp = new int[n];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            comp[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int[] ans = solve(n, comp);

        // Быстрый вывод результата через пробел (аналог print(*ans))
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(ans[i]);
            if (i < n - 1) {
                sb.append(" ");
            }
        }
        writer.write(sb.toString().trim());
        reader.close();
        writer.close();
    }

    public static int[] solve(int n, int[] comp) {
        if (n == 1) {
            return new int[]{1};
        }

        long nowSum = comp[0];
        int firstWinner = n; // начало второй "ступеньки"; = n - признак того, что ещё не найдено
        int lastLoser = 0;

        for (int i = 1; i < n - 1; i++) {
            nowSum += comp[i];
            if (comp[i] > comp[i - 1] && nowSum > comp[i + 1]) {
                if (firstWinner == n) {
                    firstWinner = i;
                }
            }
            if (nowSum <= comp[i + 1]) {
                lastLoser = i;
            }
        }

        int winnerPos = Math.max(firstWinner, lastLoser + 1);
        int[] ans = new int[n];

        // Заполняем массив: первые winnerPos элементов будут 0 (уже по умолчанию в Java),
        // а оставшиеся (n - winnerPos) элементов заполняем единицами.
        for (int i = winnerPos; i < n; i++) {
            ans[i] = 1;
        }

        if (comp[n - 1] > comp[n - 2]) {
            ans[n - 1] = 1;
        }

        return ans;
    }
}
