package com._2lazy2name.util;

public class StringUtil {
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty() || str.isBlank();
    }

    public static boolean isUUID(String str) {
        if (str == null) {
            return false;
        }
        str = str.replace("-", "");
        if (str.length() != 32) {
            return false;
        }
        return str.matches("[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}");
    }
}
