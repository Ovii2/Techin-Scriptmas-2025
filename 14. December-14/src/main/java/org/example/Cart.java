package org.example;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    private final Map<String, Double> cart = new HashMap<>();
    private final Map<String, Double> promoMap = Map.of(
            "PROMO10", 0.10,
            "PROMO25", 0.25,
            "SANTA50", 0.50);

    private double activeDiscountRate = 0.0;


    public void add(String id, double price) {
        if (id == null || id.isBlank()) {
            return;
        }
        if (price < 0 || cart.containsKey(id)) {
            return;
        }
        cart.put(id, price);
    }

    public void remove(String id) {
        if (id == null || id.isBlank()) {
            return;
        }
        cart.remove(id);
    }

    public void total() {
        double sum = cart.values().stream()
                .mapToDouble(Double::doubleValue)
                .sum();
        double discountedTotal = sum * (1 - activeDiscountRate);
        IO.println(discountedTotal);
    }

    public void applyDiscount(String code) {
        if (!promoMap.containsKey(code)) {
            return;
        }
        activeDiscountRate = promoMap.get(code);
    }

    public void clear() {
        activeDiscountRate = 0.0;
        cart.clear();
    }

    public void list() {
        if (cart.isEmpty()) {
            IO.println("Cart is empty");
            return;
        }
        cart.forEach((k, v) -> {
            System.out.printf("Gift: %s Price: %.2f%n", k, v);
        });
    }
}
