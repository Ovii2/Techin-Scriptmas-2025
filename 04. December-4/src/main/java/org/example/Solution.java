package org.example;

import java.util.List;

public class Solution {

    public static double calculateTotalPrice(List<Double> priceList) {
        return priceList.stream()
                .mapToDouble(Double::doubleValue)
                .filter(i -> i > 10)
                .sum();
    }

    public static int countDoubleValues(List<Double> priceList) {
        return Math.toIntExact(priceList.stream()
                .filter(i -> i > 10)
                .count());
    }
}
