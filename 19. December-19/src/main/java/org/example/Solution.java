package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {

    public static List<Integer> countToys(List<Integer> toyNumbers) {
        return IntStream.rangeClosed(1, 100)
                .filter(i -> Collections.frequency(toyNumbers, i) > 1)
                .boxed()
                .toList();
    }

    public static List<Integer> readToyNumbers(int number, Scanner sc) {
        int min = 1;
        int max = 100;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            int toyNumber = sc.nextInt();
            if (toyNumber < min || toyNumber > max) {
                throw new IllegalArgumentException("Toy number must be between %d and %d. Try again.".formatted(min, max));
            }
            result.add(toyNumber);
        }
        return result;
    }

    public static void formatNumbers(List<Integer> numbers) {
        for (var c : numbers) {
            IO.print(c + " ");
        }
    }
}
