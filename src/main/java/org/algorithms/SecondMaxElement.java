package org.algorithms;

public class SecondMaxElement {
    public static void main(String[] args) {
//        int[] array = new int[] {33, 41, 11, 44, 4, 2, 6, 7, 8 ,9, 10};
        int[] array = new int[]{44, 33, 11, 41, 4, 2, 6, 7, 8, 9, 10};
        System.out.println(getSecondMaxElement(array));
    }

    public static int getSecondMaxElement(int[] array) {
        int maxValue = Integer.MIN_VALUE; // не array[0]
        int result = maxValue;

        for (int v : array) {
            if (v > maxValue) {
                result = maxValue; //
                maxValue = v; // новое максимальное значение
            } else if (v > result) {
                result = v;
            }
        }

        return result;
    }
}
