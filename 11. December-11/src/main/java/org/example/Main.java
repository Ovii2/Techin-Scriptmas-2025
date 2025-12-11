package org.example;

/**
 * radii - ring sizes
 * points - score value for each ring
 */
public class Main {
    static void main() {
        double[] radii = {1, 3, 5, 10};
        int[] points = {10, 7, 5, 1};
        IO.println(Solution.getArrowScore(2, 0, 0, 0, radii, points));
    }
}
