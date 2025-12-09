package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Solution {

    public static BigDecimal calculateAverageWeight(List<Integer> weight) {
        double result = weight.stream()
                .mapToInt(i -> i)
                .average()
                .orElse(0);

        return BigDecimal.valueOf(result).setScale(2, RoundingMode.HALF_UP);
    }

    public static int findClosesWeightToAverage(List<Integer> melons) {
        BigDecimal averageWeight = calculateAverageWeight(melons);
        return IntStream.range(0, melons.size())
                .boxed()
                .min(Comparator.comparingInt(i -> averageWeight
                        .subtract(BigDecimal.valueOf(melons.get(i)))
                        .abs()
                        .intValue()
                ))
                .orElse(0) + 1;
    }

    public static String printMelonNumberAndAverageWeight(int numberOfMelons, List<Integer> weight) {
        if (numberOfMelons != weight.size()) {
            throw new IllegalArgumentException("Expected %d weights but got %d".formatted(weight.size(), numberOfMelons));
        }
        int closestIndex = findClosesWeightToAverage(weight);
        BigDecimal averageWeight = calculateAverageWeight(weight);

        return "%d %.2f".formatted(closestIndex, averageWeight);
    }
}
