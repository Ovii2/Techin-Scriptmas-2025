package org.example;

public class Solution {

    public static void calculateGiftCost(double[][] prices) {
        int itemCount;
        double totalSpent;
        double grandTotal = 0;
        for (int i = 0; i < prices.length; i++) {
            int storeNumber = i + 1;
            totalSpent = 0;
            itemCount = prices[i].length;
            for (int j = 0; j < prices[i].length; j++) {
                totalSpent += prices[i][j];
                grandTotal += prices[i][j];
            }
            IO.println("%d %d %.2f".formatted(storeNumber, itemCount, totalSpent));
        }
        IO.println("%.2f".formatted(grandTotal));
    }
}
