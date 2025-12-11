package org.example;

public class Solution {

    public static double distanceSquared(double x, double y, double xc, double yc) {
        double deltaX = x - xc;
        double deltaY = y - yc;
        return deltaX * deltaX + deltaY * deltaY;
    }

    public static int calculateScore(double distanceSquared, double[] radii, int[] points) {
        for (int i = 0; i < radii.length; i++) {
            double radiusSquared = radii[i] * radii[i];
            if (distanceSquared == radiusSquared) {
                return points[i] / 2;
            }
            if (distanceSquared < radiusSquared) {
                return points[i];
            }
        }
        return 0;
    }

    public static int getArrowScore(double x, double y, double xc, double yc, double[] radii, int[] points) {
        double distanceSquaredResult = distanceSquared(x, y, xc, yc);
        return calculateScore(distanceSquaredResult, radii, points);
    }
}
