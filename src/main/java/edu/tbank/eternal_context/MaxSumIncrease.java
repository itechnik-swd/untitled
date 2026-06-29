package edu.tbank.eternal_context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * У Кости есть бумажка, на которой написано n чисел. Также у него есть
 * возможность не больше, чем k раз, взять любое число с бумажки, после чего
 * закрасить одну из старых цифр, а на её месте написать новую произвольную
 * цифру.
 * <p>
 * На какое максимальное значение Костя сможет увеличить сумму всех чисел на
 * листочке?
 * <h6>Формат входных данных</h6>
 * В первой строке входного файла даны два целых числа  — количество чисел на
 * бумажке и ограничение на число операций.<p> (1 &leq; n &leq; 1000, 1 &leq; k
 * &leq; 10<sup>4</sup>)<p> Во второй строке записано <em>n</em> чисел
 * a<sub>i</sub> — числа на бумажке (1 &leq; a<sub>i</sub> &leq;
 * 10<sup>9</sup>).
 * <h6>Формат выходных данных</h6>
 * В выходной файл выведите одно число — максимальную разность между конечной и
 * начальной суммой.
 * <h6>Замечание</h6>
 * В первом примере Костя может изменить две единицы на две девятки, в
 * результате чего сумма чисел увеличится на 16.<p> Во втором примере Костя
 * меняет число 85 на 95.<p> В третьем примере можно ничего не менять.<p>
 * Обратите внимание, что ответ может превышать вместимость 32-битного типа
 * данных.
 * <h6>Примеры данных</h6>
 * <h6>Пример 1</h6>
 * Ввод:<p> 5 2<p> 1 2 1 3 5<p> Вывод: 16
 * <h6>Пример 2</h6>
 * Ввод: 3 1<p> Числа: 99 5 85<p> Вывод: 10
 * <h6>Пример 3</h6>
 * Ввод: 1 10<p> Числа: 9999<p> Вывод: 0
 */
public class MaxSumIncrease {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(reader.readLine());
        ArrayList<Long> gains = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            long num = Long.parseLong(tokenizer.nextToken());
            long placeValue = 1; // Вес текущего разряда (1, 10, 100, ...)

            // Разбиваем число на цифры с конца
            while (num > 0) {
                long digit = num % 10;
                long gain = (9 - digit) * placeValue;

                // Если выгода больше 0, добавляем её в список
                if (gain > 0) {
                    gains.add(gain);
                }

                num /= 10;
                placeValue *= 10;
            }
        }

        // Сортируем все возможные выгоды по убыванию
        gains.sort(Collections.reverseOrder());

        // Суммируем топ-K максимальных выгод
        long maxIncrease = 0;
        int operations = Math.min(k, gains.size());
        for (int i = 0; i < operations; i++) {
            maxIncrease += gains.get(i);
        }

        // Выводим результат
        System.out.println(maxIncrease);
    }
}
