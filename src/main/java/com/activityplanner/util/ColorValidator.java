package com.activityplanner.util;

import java.util.regex.Pattern;

public class ColorValidator {
    private static final Pattern HEX_COLOR_PATTERN = Pattern.compile("^#(?:[0-9a-fA-F]{3}){1,2}$");

    public static boolean isValidHexColor(String color) {
        return color != null && HEX_COLOR_PATTERN.matcher(color).matches();
    }
}
