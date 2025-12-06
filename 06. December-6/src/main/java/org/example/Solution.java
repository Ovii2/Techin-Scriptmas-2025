package org.example;

import java.time.Duration;
import java.time.LocalTime;

public class Solution {

    public static String computeLandingTime(int hours, int minutes, int airTime) {
        validateTime(hours, 0, 23, "Valid hour values %d - %d");
        validateTime(minutes, 0, 59, "Valid minute values %d - %d");
        if (airTime <= 0) {
            throw new IllegalArgumentException("Air time must be greater than 0");
        }

        LocalTime takeOfTime = LocalTime.of(hours, minutes);
        LocalTime landingTime = takeOfTime.plus(Duration.ofMinutes(airTime));

        String hoursSuffix = landingTime.getHour() == 1 ? "" : "s";
        String minutesSuffix = landingTime.getMinute() == 1 ? "" : "s";

        return """
                Landing time at :
                %d hour%s
                %d minute%s
                """.formatted(landingTime.getHour(), hoursSuffix, landingTime.getMinute(), minutesSuffix);
    }

    public static void validateTime(int value, int min, int max, String message) {
        if (value < min || value > max) {
            throw new IllegalArgumentException(message.formatted(min, max));
        }
    }
}
