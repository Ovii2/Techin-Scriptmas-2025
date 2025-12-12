package org.example;

import java.util.*;

public class Solution {

    public static String[][] groupWords(String[] words) {
        Map<String, List<String>> groupsBySignature = new HashMap<>();
        for (var word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String signature = new String(chars);
            groupsBySignature.computeIfAbsent(signature, k -> new ArrayList<>()).add(word);
        }
        List<List<String>> allGroups = new ArrayList<>(groupsBySignature.values());
        allGroups.sort(Comparator.comparing(List::size, Comparator.reverseOrder()));
        String[][] result = new String[allGroups.size()][];
        for (int i = 0; i < allGroups.size(); i++) {
            result[i] = allGroups.get(i).toArray(new String[0]);
        }
        return result;
    }
}
