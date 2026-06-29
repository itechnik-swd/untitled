package org.example;

public class StringPlay {
    public static void main(String[] args) {

        String a = "test";
        String b = "te" + "st";
        String c = new String("test");
        String d = c.intern();

        System.out.println(a == b); // ? true
        System.out.println(a == c); // ? false
        System.out.println(a == d); // ? true
        System.out.println(c == d); // ? false
    }

}
