package com.JMC;

public class Main {

    public static void main(String[] args) {
        Page newPage = new Page();
        System.out.println(newPage.str + newPage.ints[0] + newPage.ints[1]);
        newPage.setInts(2);
        System.out.println(newPage.str + newPage.ints[0] + newPage.ints[1]);
        newPage.setInts(3, 4);
        System.out.println(newPage.str + newPage.ints[0] + newPage.ints[1]);
    }
}
