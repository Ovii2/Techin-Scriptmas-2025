package org.example;

public class Solution {

    public static String countNames(String[] names, char lastChar) {
        int count = 0;
        String lastname;
        String firstname;
        StringBuilder resultFullName = new StringBuilder();
        for (var name : names) {
            lastname = name.split(" ")[0].trim();
            firstname = name.split(" ")[1].trim();

            if (!firstname.isEmpty() && lastChar == firstname.toLowerCase().charAt(firstname.length() - 1)) {
                count++;
                resultFullName.append(lastname).append(" ").append(firstname).append("\n");
            }
        }
        if (count == 0) {
            throw new IllegalArgumentException("No matching first names found.");
        }
        return """
                %d
                %s
                """.formatted(count, resultFullName);
    }
}
