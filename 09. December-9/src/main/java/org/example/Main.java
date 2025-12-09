package org.example;

import java.util.List;

public class Main {
    static void main() {
        List<Integer> melons = List.of(4, 3, 7, 8);
        List<Integer> melons2 = List.of(6, 9, 15, 23, 14, 8);
        List<Integer> melons3 = List.of(3, 12, 18, 5, 4, 87, 1, 23, 42);
        IO.println(Solution.printMelonNumberAndAverageWeight(4, melons));
        IO.println(Solution.printMelonNumberAndAverageWeight(6, melons2));
        IO.println(Solution.printMelonNumberAndAverageWeight(9, melons3));
    }
}
