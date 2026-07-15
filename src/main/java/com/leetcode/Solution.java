package com.leetcode;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        var list = new ArrayList<>();
        list.add(1);
        list.add("2");
        list.add(3.0);
        list.add(null);
        list.add("null");
        System.out.println(list);

    }


    public static boolean isPalindrome(String str) {
        if (str == null) return false;
        String cleaned = str.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        int left = 0, right = cleaned.length() - 1;
        while (left < right) {
            if (cleaned.charAt(left++) != cleaned.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeWithReverse(String str) {
        if (str == null) return false;
        String cleaned = str.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String reversed = new StringBuilder(cleaned).reverse().toString();
        return cleaned.equals(reversed);
    }

}
