package org.algorithms;

public class BinarySearch {

    public static void main(String[] args) {
        int[] sortedArray = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        int target = 23;

        int result = binarySearch(sortedArray, target);

        if (result != -1) {
            System.out.println("Элемент " + target + " найден по индексу: " + result);
        } else {
            System.out.println("Элемент " + target + " не найден.");
        }
    }

    // Метод бинарного поиска
    // Возвращает индекс найденного элемента или -1, если элемент не найден
    public static int binarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            // Используем эту формулу вместо (low + high) / 2,
            // чтобы избежать переполнения типов при очень больших значениях
            int mid = low + (high - low) / 2;

            if (array[mid] == target) {
                return mid; // Элемент найден, возвращаем его индекс
            }

            if (array[mid] < target) {
                low = mid + 1; // Искомый элемент справа
            } else {
                high = mid - 1; // Искомый элемент слева
            }
        }

        return -1; // Элемент не найден
    }
}
