package org.example;

public class Solution {

    public static double totalCost(int length, int width, double m2price) {
        if (length <= 0 || width <= 0 || m2price <= 0) {
            return 0;
        }
        int totalRoomArea = length * width;
        double extraFactor = 1.05;
        return Math.round((totalRoomArea * m2price) * extraFactor * 100.0) / 100.0;
    }
}
