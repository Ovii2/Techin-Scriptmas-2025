package org.example;

import java.time.LocalTime;

public class Solution {

    public static LocalTime computeTime(int hours, int minutes) {
        return LocalTime.of(hours % 24, minutes % 60).plusMinutes(60);
    }
}
