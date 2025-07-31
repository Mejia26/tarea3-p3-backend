package com.activityplanner.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static LocalDateTime parse(String datetime) {
        return LocalDateTime.parse(datetime, FORMATTER);
    }

    public static String format(LocalDateTime datetime) {
        return datetime.format(FORMATTER);
    }
}
