package ru.yandex.coderun.quickstart;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Для чтения входных данных необходимо получить их из стандартного потока ввода
 * (<em>System.in</em>).<p> Данные во входном потоке соответствуют описанному в
 * условии формату. Обычно входные данные состоят из нескольких строк. Можно
 * использовать более производительные и удобные классы:
 * <ul>
 *    <li>BufferedReader</li>
 *    <li>BufferedWriter</li>
 *    <li>Scanner</li>
 *    <li>PrintWriter</li>
 * </ul>
 * С помощью <em>BufferedReader</em> можно прочитать из стандартного потока:
 * <ul>
 *     <li>строку --
 * <pre>
 * String str = reader.readLine()</pre></li>
 *     <li>число --
 * <pre>
 * int n = Integer.parseInt(reader.readLine());</pre></li>
 *     <li>массив чисел известной длины <i>len</i> (во входном потоке <b>каждое число на новой строке</b>) --<br>
 * <pre>
 * int[] nums = new int[len];<br>
 * for (int i = 0; i < len; i++) {<br>
 *     nums[i] = Integer.parseInt(reader.readLine());<br>
 * }</pre></li>
 *     <li>последовательность слов в строке, разделённых " " --
 * <pre>
 * String[] parts = reader.readLine().split(" ");</pre></li>
 * </ul>
 * <p>
 * Чтобы вывести результат в стандартный поток вывода (<em>System.out</em>).<p>
 * Через <b>BufferedWriter</b> можно использовать методы:
 * <ul>
 *     <li>writer.write("Строка"); / writer.write(String.valueOf(result));</li>
 *     <li>writer.write('A')</li>
 *     <li>writer.newLine()</li>
 * </ul>
 */
public class AplusB {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        long sum = 0;
        String[] parts = reader.readLine().split(" ");
        for (String part : parts) {
            long num = Long.parseLong(part);
            sum += num;
        }

        writer.write(String.valueOf(sum));

        reader.close();
        writer.close();
    }
}
