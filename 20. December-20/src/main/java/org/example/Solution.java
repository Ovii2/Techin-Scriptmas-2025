package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Solution {

    public static void printCallSummary(List<Map<String, Object>> elves, Map<String, Double> priceList) {
        double grandTotal = calculateGrandTotalCallPrice(elves, priceList);
        sortElvesByLastName(elves)
                .forEach(elf -> {
                    String firstName = elf.get("firstName").toString();
                    String lastName = elf.get("lastName").toString();
                    double callPricePerElf = calculateCallPricePerElf(elf, priceList);
                    IO.println("%s %s %.2f".formatted(lastName, firstName, callPricePerElf));
                });
        IO.println("Total: %.2f".formatted(grandTotal));
    }

    public static Stream<Map<String, Object>> sortElvesByLastName(List<Map<String, Object>> elves) {
        return elves.stream()
                .sorted(Comparator.comparing(elf -> (String) elf.get("lastName")));
    }

    public static double calculateCallPricePerElf(Map<String, Object> elf, Map<String, Double> priceList) {
        return ((List<Map<String, Object>>) elf.get("calls")).stream()
                .map(call -> {
                    String city = (String) call.get("city");
                    Integer minutes = (Integer) call.get("minutes");
                    return minutes * priceList.get(city);
                })
                .reduce(0.0, Double::sum);
    }

    public static double calculateGrandTotalCallPrice(List<Map<String, Object>> elves, Map<String, Double> priceList) {
        return elves.stream()
                .flatMap(elf -> ((List<Map<String, Object>>) elf.get("calls"))
                        .stream())
                .map(call -> {
                    String city = (String) call.get("city");
                    Integer minutes = (Integer) call.get("minutes");
                    return minutes * priceList.get(city);
                })
                .reduce(0.0, Double::sum);
    }
}
