package org.example;

import java.util.stream.IntStream;

public class Solution {

    public static int computeTotalNumberOfSeats(int rows, int seatsInFirstRow) {
        if (rows < 0 || seatsInFirstRow < 0) {
            throw new IllegalArgumentException("Number must be greater than 0");
        }
        return IntStream.range(0, rows)
                .map(i -> seatsInFirstRow + 2 * i)
                .sum();
    }
}
