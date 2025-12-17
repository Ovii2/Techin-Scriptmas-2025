package org.example;

public class Solution {

    public static void countJuiceBottles(int[] array) {
        for (int juiceAmount : array) {
            int count5Litres = juiceAmount / 5;
            int remainder5L = juiceAmount % 5;
            int count2Litres = remainder5L / 2;
            int count1Litres = remainder5L % 2;
            IO.println("%d %d %d".formatted(count5Litres, count2Litres, count1Litres));
        }
    }
}
