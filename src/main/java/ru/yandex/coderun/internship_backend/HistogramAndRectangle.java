package ru.yandex.coderun.internship_backend;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 10. Гистограмма и прямоугольник
 * <ul>
 *     <li>Без перебора всех вариантов подряд.</li>
 *     <li>Высоты могут быть равны нулю, и тогда на этом месте прямоугольник «обрывается».</li>
 *     <li>Для каждого элемента быстро найти, где слева и справа находятся ближайшие столбики меньшей высоты,
 *     то задача решена. Остаётся только понять, как сделать этот поиск эффективным, не перебирая каждый раз всех соседей.</li>
 *     <li>Идём по массиву слева направо и держишь в уме «кандидатов» — столбики,
 *     которые могут оказаться левой границей для будущих прямоугольников.
 *     Как понять, кого из них можно выкинуть из рассмотрения, а кто ещё пригодится?</li>
 * </ul>
 */
public class HistogramAndRectangle {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = reader.readLine().split(" ");

        int n = Integer.parseInt(inputs[0]);
        int[] heights = new int[n];

        for (int i = 0; i < n; i++) {
            heights[i] = Integer.parseInt(inputs[i + 1]);
        }

        var maxArea = getMaxArea(heights);

        writer.write(String.valueOf(maxArea));

        reader.close();
        writer.close();
    }

    private static long getMaxArea(int[] heights) {
        long maxArea = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i <= heights.length; i++) {
            int currentHeight = (i == heights.length) ? 0 : heights[i];

            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, (long) height * width);
            }

            stack.push(i);
        }
        return maxArea;
    }
}
