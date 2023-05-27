package com.taf.core.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ResourcesFilePathUtil {
    public static String getJsonBodyFilePathByName(String fileName) {
        return "bodies/%s.json".formatted(fileName);
    }
}
