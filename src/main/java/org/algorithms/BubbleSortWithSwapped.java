package org.algorithms;

/**
 * Вот классический и наглядный код сортировки пузырьком (Bubble Sort) на
 * Java.<p> Алгоритм постоянно сравнивает соседние элементы и меняет их местами,
 * если они стоят в неправильном порядке — из-за этого самые большие элементы
 * «всплывают» в конец массива, как пузырьки воздуха в воде.
 */
public class BubbleSortWithSwapped {
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Исходный массив:");
        printArray(arr);

        bubbleSort(arr);

        System.out.println("Отсортированный массив:");
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Последний i элементов уже на своих местах
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Меняем местами arr[j] и arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // Если обменов не было, массив отсортирован
            if (!swapped) {
                break;
            }
        }
    }
}
