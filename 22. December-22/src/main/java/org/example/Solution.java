package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void printChristmasTree(String input) {
        String[] words = input.trim().split("\\s+");

        List<String> lines = groupWordsIntoLines(words);
        int maxLength = findMaxLineLength(lines);

        IO.println();
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            if (i == 0) {
                IO.println(padLeft(line, maxLength - 3));
            } else if (i % 2 == 0) {
                IO.println(padLeft(line, maxLength));
            } else {
                int leftPadding = Math.max(0, maxLength - 3);
                IO.println(" ".repeat(leftPadding) + line);
            }
        }
    }

    private static List<String> groupWordsIntoLines(String[] words) {
        List<String> lines = new ArrayList<>();
        int wordIndex = 0;
        int lineNumber = 1;
        while (wordIndex < words.length) {
            int wordsInLine = lineNumber;
            int remainingWords = words.length - wordIndex;
            if (wordsInLine > remainingWords) {
                wordsInLine = remainingWords;
            }
            String[] lineWords = Arrays.copyOfRange(words, wordIndex, wordIndex + wordsInLine);
            String line = String.join(" ", lineWords);
            wordIndex += wordsInLine;
            lineNumber++;
            lines.add(line);
        }
        return lines;
    }

    private static int findMaxLineLength(List<String> lines) {
        return lines.stream()
                .mapToInt(String::length)
                .max()
                .orElse(0);
    }

    public static String padLeft(String s, int n) {
        return String.format("%" + n + "s", s);
    }
}
