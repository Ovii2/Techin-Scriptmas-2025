package org.example;

public class Main {
    static void main() {
        String[] names = {
                "Petraitis Rokas",
                "Augė Artūras",
                "Mikalauskaitė Aušra",
                "Šlivka Donatas",
                "Stakėnaitė Ieva",
                "Skrėbė Domas",
                "Bruzgaitė Akvilė"
        };
        IO.println(Solution.countNames(names, 'a'));
    }
}
