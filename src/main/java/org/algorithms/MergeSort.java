package org.algorithms;

/**
 * Вот классическая реализация сортировки слиянием (Merge Sort) на Java.<p> Этот
 * алгоритм работает по принципу «разделяй и властвуй»: Массив рекурсивно
 * делится пополам, пока не получится множество подмассивов из 1 элемента. Затем
 * эти мелкие отсортированные элементы сливаются обратно в один большой
 * отсортированный массив.
 */
public class MergeSort {
    // Главный метод, принимающий массив
    public static void mergeSort(int[] array) {
        if (array == null || array.length <= 1) {
            return; // Базовый случай: массив из 0 или 1 элемента уже отсортирован
        }

        int mid = array.length / 2;

        // Создаем левый и правый подмассивы
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];

        // Заполняем подмассивы данными
        System.arraycopy(array, 0, left, 0, mid);
        System.arraycopy(array, mid, right, 0, array.length - mid);

        // Рекурсивно сортируем обе половины
        mergeSort(left);
        mergeSort(right);

        // Сливаем два отсортированных подмассива в один
        merge(array, left, right);
    }

    // Метод для слияния двух отсортированных массивов в один
    private static void merge(int[] target, int[] left, int[] right) {
        int i = 0; // Индекс для левого массива
        int j = 0; // Индекс для правого массива
        int k = 0; // Индекс для результирующего массива

        // Сравниваем элементы из left и right и кладём меньший в target
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                target[k++] = left[i++];
            } else {
                target[k++] = right[j++];
            }
        }

        // Копируем оставшиеся элементы из left (если есть)
        while (i < left.length) {
            target[k++] = left[i++];
        }

        // Копируем оставшиеся элементы из right (если есть)
        while (j < right.length) {
            target[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        int[] numbers = {38, 27, 43, 3, 9, 82, 10};

        System.out.println("Исходный массив:");
        printArray(numbers);

        mergeSort(numbers);

        System.out.println("\nОтсортированный массив:");
        printArray(numbers);
    }

    private static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
