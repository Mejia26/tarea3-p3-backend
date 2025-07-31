package com.activityplanner.util;

public class ActivityValidator {
    public static boolean isHourInRange(Integer hour) {
        return hour != null && hour >= 0 && hour <= 23;
    }
}