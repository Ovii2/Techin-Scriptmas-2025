package org.example;

public class Solution {

    public static String calculateGifts(int[][] data) {
        int total = 0;
        int giftCount;
        var workshopNumber = 0;
        for (int[] rows : data) {
            workshopNumber++;
            giftCount = 0;
            for (int column : rows) {
                total += column;
                giftCount += column;
            }
            IO.println("Workshop %d made %d gifts".formatted(workshopNumber, giftCount));
        }
        return "Santa's total gift count is %d".formatted(total);
    }
}
