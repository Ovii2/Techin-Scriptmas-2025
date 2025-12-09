package org.example;

public class Solution {

    public static void printChristmasLightsGrid(int number) {
        int width = (number * 2) + 3;
        IO.println("#".repeat(width));
        for (int row = 1; row <= number; row++) {
            IO.print("# ");
            for (int col = 1; col <= number; col++) {
                int sum = row + col;
                if (sum % 3 == 0 && sum % 5 == 0) {
                    IO.print("G");
                } else if (sum % 3 == 0) {
                    IO.print("T");
                } else if (sum % 5 == 0) {
                    IO.print("S");
                } else {
                    IO.print(".");
                }
                IO.print(" ");
            }
            IO.print("#");
            IO.println();
        }
        IO.println("#".repeat(width));
    }
}
