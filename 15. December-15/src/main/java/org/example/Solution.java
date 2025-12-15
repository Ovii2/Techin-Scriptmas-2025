package org.example;

public class Solution {

    public static void getLowestPrice(double x, double y, double z) {
        double smallest = Math.min(x, Math.min(y, z));
        IO.println("Peter will spend %.2f".formatted(smallest));
    }
}
