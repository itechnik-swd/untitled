package edu.tbank.eternal_context;

import java.util.Scanner;

public class Mobile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();

        System.out.print(a + c * Math.max(0, d - b));
        scanner.close();
    }
}
