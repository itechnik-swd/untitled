package org.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Как обходить "стирание типов" (Type erasure)
 *
 * @param <T>
 */
public class Zoo<T> {
    Class<T> clazz;
    List<T> animals = new ArrayList<>();

    Zoo(Class<T> clazz) {
        this.clazz = clazz;
    }

    // Как это использовать
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Zoo<Tiger> zoo = new Zoo<>(Tiger.class); // вот тут передаётся тип!
        Tiger tiger = zoo.createNewAnimal();
    }

    public T createNewAnimal() throws InstantiationException, IllegalAccessException {
        T animal = clazz.newInstance(); // 'newInstance()' помечен как устаревший начиная с версии 9
        animals.add(animal);
        return animal;
    }
}
