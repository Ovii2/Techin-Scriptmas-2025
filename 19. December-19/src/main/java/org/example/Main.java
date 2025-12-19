package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    static void main() {

        Scanner sc = new Scanner(System.in);
        IO.println("Enter number of toys");
        int toysInTheBox = sc.nextInt();
        IO.println("Enter toy numbers (in one line)");
        List<Integer> toyNumbers = Solution.readToyNumbers(toysInTheBox, sc);
        List<Integer> duplicates = Solution.countToys(toyNumbers);
        Solution.formatNumbers(duplicates);
    }
}
