package org.example;

public class Main {
    static void main() {
        Cart cart = new Cart();

        cart.add("train", 30);
        cart.add("doll", 20);
        cart.applyDiscount("PROMO25");
        cart.total();
        cart.remove("train");
        cart.total();
        cart.list();
        cart.clear();
    }
}
