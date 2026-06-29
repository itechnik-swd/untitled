package org.algorithms;

import java.util.ArrayList;
import java.util.List;

public class BubbleSorting {
    public static void main(String[] args) {
        var fruits = new ArrayList<>(List.of("Orange", "Apple", "Banana", "Grapes", "Cherry"));

        for (int i = 0; i < fruits.size(); i++) {
            for (int j = 0; j < fruits.size() - i - 1; j++) {
                if (fruits.get(j).compareTo(fruits.get(j + 1)) > 0) {
                    // Обмен элементов
                    var temp = fruits.get(j);
                    fruits.set(j, fruits.get(j + 1));
                    fruits.set(j + 1, temp);
                }
            }
        }

        System.out.println(fruits); // Вывод: [Apple, Banana, Cherry, Grapes, Orange]
    }
}
