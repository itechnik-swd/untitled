package org.example;

public class Example {
    public static void main(String[] args) {
        var s = "abbcbba";
        boolean isPalindrome = isPalindrome(s);
        System.out.println(isPalindrome);

        var t = "abcd";
        System.out.println(isPalindrome(t));

        var u = "a";
        System.out.println(isPalindrome(u));

        var w = "";
        System.out.println(isPalindrome(w));

    }

    private static Boolean isPalindrome(String str) {

        if (str.isEmpty()) {
            return false;
        }
//        Решение через реверс строки
//        var s = new StringBuilder(str).reverse().toString();
//
//        return str.equals(s);

//        Вариант решения с использованием массива символов
//        char[] chars = str.toCharArray();
//
//        for (int i = 0; i < chars.length - i - 1; i++) {
//            if (chars[i] != chars[chars.length - i - 1]) {
//                return false;
//            }
//        }
//
//        return true;

        // Вариант решения через 2 указателя
        var leftIndex = 0;
        var rightIndex = str.length() - 1;

        while (leftIndex < rightIndex) {
            if (str.charAt(leftIndex) == str.charAt(rightIndex)) {
                leftIndex++;
                rightIndex--;
            } else {
                return false;
            }
        }

        return true;
    }
}
