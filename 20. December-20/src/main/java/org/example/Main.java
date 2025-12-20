package org.example;

import java.util.List;
import java.util.Map;

public class Main {
    static void main() {

        List<Map<String, Object>> elves = List.of(
                Map.of(
                        "firstName", "Jingle",
                        "lastName", "Sparkfoot",
                        "calls", List.of(
                                Map.of("city", "London", "minutes", 12),
                                Map.of("city", "Paris", "minutes", 7)
                        )
                ),
                Map.of(
                        "firstName", "Twinkle",
                        "lastName", "Icicletoes",
                        "calls", List.of(
                                Map.of("city", "NewYork", "minutes", 20),
                                Map.of("city", "London", "minutes", 5)
                        )
                ),
                Map.of(
                        "firstName", "Pudding",
                        "lastName", "Gumdrops",
                        "calls", List.of(
                                Map.of("city", "Paris", "minutes", 15))));

        Map<String, Double> priceList = Map.of(
                "London", 0.50,
                "Paris", 0.40,
                "NewYork", 0.70
        );

        Solution.printCallSummary(elves, priceList);
    }
}
