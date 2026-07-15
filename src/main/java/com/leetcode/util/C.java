package com.leetcode.util;

class C implements I {
    public void m() { // доступ package-private – попытка сузить доступ запрещена.
        System.out.println("C");
    }
}
