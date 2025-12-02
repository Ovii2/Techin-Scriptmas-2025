package org.example;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Solution {
    public static String calculateTimeSinceMidnight(int hours, int minutes) {
        if (hours < 0 || hours > 23) {
            throw new IllegalArgumentException("Valid hour values 0 - 23");
        } else if (minutes < 0 || minutes > 59) {
            throw new IllegalArgumentException("Valid minute values 0 - 59");
        }
        LocalTime currentTime = LocalTime.of(hours, minutes);

        long minutesPassed = ChronoUnit.MINUTES.between(LocalTime.MIDNIGHT, currentTime);
        long secondsPassed = minutesPassed * 60;

        return """
                Minutes Passed : %d
                Seconds Passed : %d
                """.formatted(minutesPassed, secondsPassed);
    }
}
