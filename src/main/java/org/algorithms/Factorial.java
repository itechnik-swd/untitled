package org.algorithms;

public class Factorial {

    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        int result = factorial.calculateFactorial(6);
        System.out.println(result);
    }

    public int calculateFactorial(int x) {

        if (x == 1 || x == 0) {
            return 1;
        }

        return x * calculateFactorial(x - 1);
    }
}
