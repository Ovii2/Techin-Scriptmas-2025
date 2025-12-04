package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static void main() {

        Scanner sc = new Scanner(System.in);
        List<Double> prices = new ArrayList<>();
        IO.println("Enter toy prices: ");

        double price;
        boolean shouldStop = false;

        do {
            String[] line = sc.nextLine().trim().split(";");
            for (String s : line) {
                price = Double.parseDouble(s);
                if (price == 0) {
                    shouldStop = true;
                    break;
                }
                prices.add(price);
            }
            double sum = Solution.calculateTotalPrice(prices);
            int count = Solution.countDoubleValues(prices);

            if (count == 0) {
                System.out.println("At least one item price must be greater than 10 EUR");
                continue;
            }
            System.out.printf("Total prices of magical toys: %.1f EUR%n", sum);
            System.out.printf("Number of magic toys: %d%n", count);

        }
        while (!shouldStop);
    }
}
