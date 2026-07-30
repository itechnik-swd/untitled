package org.anonymous;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "Привет", "как", "дела");

//        Comparator<String> comparator = new Comparator<>() {
//            public int compare(String o1, String o2) {
//                return o1.length() - o2.length();
//            }
//        };

//        Comparator<String> comparator = (o1, o2) -> o1.length() - o2.length();

//        Comparator<String> comparator = (o1, o2) -> {
//            return o1.length() - o2.length();
//        };

        Comparator<String> comparator = Comparator.comparingInt(String::length);

        list.sort(comparator); // Collections.sort(list, comparator);
    }
}
