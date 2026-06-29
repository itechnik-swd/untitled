package org.example;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
//        System.out.printf("Hello and welcome!");

//        for (int i = 1; i <= 5; i++) {
        //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
        // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
//            System.out.println("i = " + i);
//        }

//        int[] a = {1, 2};
//        int[] b = {1, 2};
//        System.out.println(a == b);
//
//        int[] c = a;
//        System.out.println(c == a);
//        System.out.println(c == b);

        int[] array = {1, 9, 3, 2, 5, 7};
        countSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void countSort(int[] array) {
        final int MAX_COUNT = 100; // необходимо задать максимальное число
        // либо передать его как параметр метода
        int[] count = new int[MAX_COUNT];

        for (int k : array) {
            count[k] += 1;

        }

        int arrayIndex = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                array[arrayIndex] = i;
                arrayIndex++;
            }
        }
    }

    public static int[] countingSort(int[] theArray, int maxValue) {
        // Массив со «счётчиками» размером от 0 до максимального значения
        int[] numCounts = new int[maxValue + 1];
        // В соответствующей ячейке (индекс = значение) увеличиваем счётчик
        for (int num : theArray) {
            numCounts[num]++;
        }
        // Подготавливаем массив для отсортированного результата
        int[] sortedArray = new int[theArray.length];
        int currentSortedIndex = 0;
        // Идём по массиву со «счётчиками»
        for (int n = 0; n < numCounts.length; n++) {
            int count = numCounts[n];
            // Идём по количеству значений
            for (int k = 0; k < count; k++) {
                sortedArray[currentSortedIndex] = n;
                currentSortedIndex++;
            }
        }
        return sortedArray;
    }
}
