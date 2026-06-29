package org.example;

import java.util.ArrayList;
import java.util.List;

public class ListMutationTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");

        mutate(list);
        System.out.println(list); // ? [A, B]
    }

    static void mutate(List<String> lst) {
        lst.add("B");
        lst = new ArrayList<>(); // lst is not visible outside
        lst.add("C");
    }
}
