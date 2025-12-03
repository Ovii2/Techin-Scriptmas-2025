package org.example;

public class Solution {

    public static int trimMiddleDigits(int number) {
        if (number < 1000 || number > 9999) {
            throw new IllegalArgumentException("Input must be a four digit number");
        }
        int num1 = number / 1000;
        int num2 = number % 10;
        return num1 * 10 + num2;
    }
}
