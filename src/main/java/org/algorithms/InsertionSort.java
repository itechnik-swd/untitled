package org.algorithms;

/**
 * Вот классическая реализация алгоритма <b>сортировки вставками</b> (Insertion
 * Sort) на Java.<p> Принцип работы прост: алгоритм проходит по массиву слева
 * направо и берет очередной элемент (ключ), а затем «вставляет» его на
 * правильную позицию среди уже отсортированных элементов слева, сдвигая более
 * крупные элементы вправо.
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] numbers = {12, 11, 13, 5, 6};

        System.out.println("Исходный массив:");
        printArray(numbers);

        insertionSort(numbers);

        System.out.println("\nОтсортированный массив:");
        printArray(numbers);
    }

    // Вспомогательный метод для вывода массива
    private static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void insertionSort(int[] array) {
        int n = array.length;

        // Начинаем со второго элемента (индекс 1),
        // так как элемент с индексом 0 условно считается уже "отсортированным"
        for (int i = 1; i < n; i++) {
            int key = array[i]; // Запоминаем текущий элемент для вставки
            int j = i - 1;

            // Сдвигаем элементы массива, которые больше нашего key,
            // на одну позицию вправо от их текущего положения
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }

            // Помещаем key на освободившееся место
            array[j + 1] = key;
        }
    }
}
